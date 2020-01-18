package com.ticketing.service.impl;

import com.ticketing.dto.FlyingDTO;
import com.ticketing.dto.TicketDTO;
import com.ticketing.dto.TicketInfo;
import com.ticketing.entity.Ticket;
import com.ticketing.exception.ExceptionMessage;
import com.ticketing.repository.TicketRepository;
import com.ticketing.service.FlyingService;
import com.ticketing.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class TicketServiceImpl implements TicketService {


    private FlyingService flyingService;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(FlyingService flyingService, TicketRepository ticketRepository) {
        this.flyingService = flyingService;
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public TicketInfo getTicketInfoByFlyingId(Long flyingId) {
        FlyingDTO flyingDTO = flyingService.findById(flyingId);
        if (flyingDTO == null) {
            throw new NullPointerException(ExceptionMessage.FLYING_NOT_FOUND);
        }

        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setFlyingId(flyingDTO.getId());
        ticketInfo.setAirlineCompanyId(flyingDTO.getAirlineCompanyId());
        ticketInfo.setBoardingTime(flyingDTO.getBoardingTime());
        ticketInfo.setDestinationTime(flyingDTO.getDestinationTime());
        ticketInfo.setFlyingRouteId(flyingDTO.getFlyingRouteId());
        ticketInfo.setQuota(flyingDTO.getQuota());
        ticketInfo.setTicketPrice(calculateTicketMoney(flyingDTO.getQuota(), flyingDTO.getRemainingQuota(), flyingDTO.getTicketPrice()));
        ticketInfo.setRemainingQuota(flyingDTO.getRemainingQuota());
        return ticketInfo;
    }

    @Override
    public TicketDTO buyTicket(TicketDTO ticketDTO) throws Exception {
        FlyingDTO flyingDTO = flyingService.findById(ticketDTO.getFlyingId());
        if (flyingDTO == null) {
            throw new NullPointerException(ExceptionMessage.FLYING_NOT_FOUND);
        }

        if (flyingDTO.getRemainingQuota().equals(0)) {
            throw new Exception(ExceptionMessage.AIRPLANE_IS_FULL);
        }


        Double ticketMoney = calculateTicketMoney(flyingDTO.getQuota(), flyingDTO.getRemainingQuota(), flyingDTO.getTicketPrice());

        if (ticketDTO.getTicketMoney() < ticketMoney) {
            throw new Exception(ExceptionMessage.INSUFFICIENT_MONEY);
        }

        Ticket ticket = new Ticket();
        Date now = new Date();
        ticket.setMoneyPaid(ticketMoney);
        ticket.setFlying(flyingService.findByIdForTicket(ticketDTO.getFlyingId()));
        ticket.setTicketBuyDate(now);
        ticket.setTicketNumber(String.valueOf(now.getTime()));
        Ticket registerTicket = ticketRepository.save(ticket);
        TicketDTO registerTicketDTO = convertToTicketDTO(registerTicket);
        updateFlying(flyingDTO);
        return registerTicketDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public TicketDTO findTicketByTicketNumber(String ticketNumber) {
        Ticket ticket = ticketRepository.findFirstByTicketNumber(ticketNumber);
        if (ticket == null) {
            throw new NullPointerException(ExceptionMessage.TICKET_NOT_FOUND);
        }
        return convertToTicketDTO(ticket);
    }

    @Override
    public void ticketVoidByTicketNumber(String ticketNumber) throws Exception {
        Ticket ticket = ticketRepository.findFirstByTicketNumber(ticketNumber);
        if (ticket.getFlying().getBoardingTime().getTime() < new Date().getTime()) {
            throw new Exception(ExceptionMessage.TICKET_IRREVOCABLE);
        }

        FlyingDTO flyingDTO = flyingService.findById(ticket.getFlying().getId());
        flyingDTO.setRemainingQuota(flyingDTO.getRemainingQuota() + 1);
        flyingService.updateFlying(ticket.getFlying().getId(), flyingDTO);

        ticketRepository.delete(ticket);
    }

    private TicketDTO convertToTicketDTO(Ticket registerTicket) {
        TicketDTO ticketDTO = new TicketDTO();
        if (registerTicket != null) {
            ticketDTO.setId(registerTicket.getId());
            ticketDTO.setFlyingId(registerTicket.getFlying().getId());
            ticketDTO.setMoneyPaid(registerTicket.getMoneyPaid());
            ticketDTO.setTicketBuyDate(registerTicket.getTicketBuyDate());
            ticketDTO.setTicketMoney(registerTicket.getMoneyPaid());
            ticketDTO.setTicketNumber(registerTicket.getTicketNumber());
        }
        return ticketDTO;

    }

    private void updateFlying(FlyingDTO flyingDTO) throws Exception {
        Integer newRemainingQuota = flyingDTO.getRemainingQuota() - 1;
        flyingDTO.setRemainingQuota(newRemainingQuota);
        flyingService.updateFlying(flyingDTO.getId(), flyingDTO);
    }

    private Double calculateTicketMoney(Integer quota, Integer remainingQuota, Double ticketPrice) {
        int rate = Math.round((100 * (quota - remainingQuota)) / quota);

        if (rate <= 9)
            return ticketPrice;
        else if (rate <= 19)
            return ticketPrice + ((ticketPrice / 100) * 10);
        else if (rate <= 29)
            return ticketPrice + ((ticketPrice / 100) * 20);
        else if (rate <= 39)
            return ticketPrice + ((ticketPrice / 100) * 30);
        else if (rate <= 49)
            return ticketPrice + ((ticketPrice / 100) * 40);
        else if (rate <= 59)
            return ticketPrice + ((ticketPrice / 100) * 50);
        else if (rate <= 69)
            return ticketPrice + ((ticketPrice / 100) * 60);
        else if (rate <= 79)
            return ticketPrice + ((ticketPrice / 100) * 70);
        else if (rate <= 89)
            return ticketPrice + ((ticketPrice / 100) * 80);
        else
            return ticketPrice + ((ticketPrice / 100) * 90);
    }
}
