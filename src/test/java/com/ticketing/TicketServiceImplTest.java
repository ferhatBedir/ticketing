package com.ticketing;


import com.ticketing.dto.FlyingDTO;
import com.ticketing.dto.TicketDTO;
import com.ticketing.dto.TicketInfo;
import com.ticketing.entity.*;
import com.ticketing.repository.FlyingRepository;
import com.ticketing.repository.TicketRepository;
import com.ticketing.service.impl.FlyingServiceImpl;
import com.ticketing.service.impl.TicketServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TicketServiceImplTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private FlyingServiceImpl flyingService;

    @InjectMocks
    private TicketServiceImpl ticketService;


    @Test
    public void getTicketInfo_whenRequestToTicketInfoEndPointShouldBeReturnTicketInfo() {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setQuota(100);
        flyingDTO.setRemainingQuota(100);
        flyingDTO.setTicketPrice(100D);

        when(flyingService.findById(1L)).thenReturn(flyingDTO);
        TicketInfo ticketInfo = ticketService.getTicketInfoByFlyingId(1L);

        Assertions.assertThat(ticketInfo).isNotNull();
        Assertions.assertThat((ticketInfo.getFlyingId())).isEqualTo(flyingDTO.getId());
    }

    @Test(expected = NullPointerException.class)
    public void getTicketInfo_whenFlyingIdNotFoundShouldThrowException() {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setQuota(100);
        flyingDTO.setRemainingQuota(100);
        flyingDTO.setTicketPrice(100D);

        when(flyingService.findById(1L)).thenReturn(flyingDTO);
        TicketInfo ticketInfo = ticketService.getTicketInfoByFlyingId(2L);

        Assertions.assertThat(ticketInfo).isNull();
    }

    @Test(expected = NullPointerException.class)
    public void getTicketInfo_whenFlyingIdIsNullShouldThrowException() {
        TicketInfo ticketInfo = ticketService.getTicketInfoByFlyingId(null);
        Assertions.assertThat(ticketInfo).isNull();
    }

    @Test
    public void buyTicket_whenRequestToTicketBuyShouldBuyTicket() throws Exception {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setQuota(100);
        flyingDTO.setRemainingQuota(100);
        flyingDTO.setTicketPrice(100D);

        when(flyingService.findById(1L)).thenReturn(flyingDTO);

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFlyingId(1L);
        ticketDTO.setTicketMoney(100D);

        ticketService.buyTicket(ticketDTO);
    }

    @Test(expected = NullPointerException.class)
    public void buyTicket_whenFlyingIdNotFoundShouldBeReturnThrowException() throws Exception {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setQuota(100);
        flyingDTO.setRemainingQuota(100);
        flyingDTO.setTicketPrice(100D);

        when(flyingService.findById(1L)).thenReturn(flyingDTO);

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFlyingId(2L);
        ticketDTO.setTicketMoney(100D);

        ticketService.buyTicket(ticketDTO);
    }

    @Test(expected = NullPointerException.class)
    public void buyTicket_whenFlyingIdIsNullShouldThrowException() throws Exception {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setQuota(100);
        flyingDTO.setRemainingQuota(100);
        flyingDTO.setTicketPrice(100D);

        when(flyingService.findById(1L)).thenReturn(flyingDTO);

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFlyingId(null);
        ticketDTO.setTicketMoney(100D);

        ticketService.buyTicket(ticketDTO);
    }

    @Test(expected = NullPointerException.class)
    public void buyTicket_whenTicketDTOIsNullShouldThrowException() throws Exception {
        FlyingDTO flyingDTO = null;
        when(flyingService.findById(1L)).thenReturn(flyingDTO);

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFlyingId(1L);
        ticketDTO.setTicketMoney(100D);
        ticketService.buyTicket(ticketDTO);
    }

    @Test(expected = Exception.class)
    public void buyTicket_whenTicketMoneyIsNotEnoughThrowException() throws Exception {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setQuota(100);
        flyingDTO.setRemainingQuota(100);
        flyingDTO.setTicketPrice(200D);

        when(flyingService.findById(1L)).thenReturn(flyingDTO);

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFlyingId(1L);
        ticketDTO.setTicketMoney(100D);

        ticketService.buyTicket(ticketDTO);
    }

    @Test(expected = Exception.class)
    public void buyTicket_whenTicketMoneyIsNullThrowException() throws Exception {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setBoardingTime(new Date());
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setQuota(100);
        flyingDTO.setRemainingQuota(100);
        flyingDTO.setTicketPrice(200D);

        when(flyingService.findById(1L)).thenReturn(flyingDTO);

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFlyingId(1L);
        ticketDTO.setTicketMoney(null);

        ticketService.buyTicket(ticketDTO);
    }

    @Test
    public void findMyTicketByTicketNumber_whenRequestToFindMyTicketShouldBeReturnYourTicketInfo() {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setAirportName("Airport Name 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setAirportName("Airport Name 2");

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(destinationAirport);
        route.setDestination(destinationAirport);
        route.setCreateDate(new Date());
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setCompanyName("Airline Company Name");
        airlineCompany.setGeneralCenter("Airline Company Region 1");
        airlineCompany.setEmployeeCount(1000);

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setAirlineCompany(airlineCompany);
        flying.setFlyingRoute(route);
        flying.setBoardingTime(new Date());
        flying.setDestinationTime(new Date());
        flying.setTicketPrice(100D);
        flying.setQuota(100);
        flying.setRemainingQuota(100);


        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setMoneyPaid(100D);
        ticket.setFlying(flying);
        ticket.setTicketBuyDate(new Date());
        String ticketNumber = String.valueOf(new Date().getTime());
        ticket.setTicketNumber(ticketNumber);

        when(ticketRepository.findFirstByTicketNumber(ticketNumber)).thenReturn(ticket);

        TicketDTO ticketDTO = ticketService.findTicketByTicketNumber(ticketNumber);

        Assertions.assertThat(ticketDTO).isNotNull();
        Assertions.assertThat(ticketDTO.getFlyingId()).isEqualTo(flying.getId());
    }

    @Test(expected = NullPointerException.class)
    public void findMyTicketByTicketNumber_whenTicketNumberIsNullShouldReturnThrowException() {
        when(ticketRepository.findFirstByTicketNumber(null)).thenReturn(null);
        TicketDTO ticketDTO = ticketService.findTicketByTicketNumber(null);
        Assertions.assertThat(ticketDTO).isNull();
    }

    @Test(expected = NullPointerException.class)
    public void myTicketVoidByTicketNumber_whenTicketNumberNotFoundShouldReturnNull() throws Exception {
        when(ticketRepository.findFirstByTicketNumber("A-123")).thenReturn(new Ticket());
        ticketService.ticketVoidByTicketNumber("A-124");
    }

    @Test(expected = NullPointerException.class)
    public void myTicketVoidByTicketNumber_whenTicketNumberIsNullShouldThrowException() throws Exception {
        when(ticketRepository.findFirstByTicketNumber(null)).thenReturn(null);
        ticketService.ticketVoidByTicketNumber(null);
    }

    @Test(expected = Exception.class)
    public void myTicketVoidByTicketNumber_whenNowTimeBeforeTicketFlyingBoardingTimeReturnNotBeVoidTicket() throws Exception {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setAirportName("Airport Name 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setAirportName("Airport Name 2");

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(destinationAirport);
        route.setDestination(destinationAirport);
        route.setCreateDate(new Date());
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setCompanyName("Airline Company Name");
        airlineCompany.setGeneralCenter("Airline Company Region 1");
        airlineCompany.setEmployeeCount(1000);

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setAirlineCompany(airlineCompany);
        flying.setFlyingRoute(route);
        flying.setBoardingTime(new Date());
        flying.setDestinationTime(new Date());
        flying.setTicketPrice(100D);
        flying.setQuota(100);
        flying.setRemainingQuota(100);


        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setMoneyPaid(100D);
        ticket.setFlying(flying);
        ticket.setTicketBuyDate(new Date());
        String ticketNumber = String.valueOf(new Date().getTime());
        ticket.setTicketNumber(ticketNumber);

        when(ticketRepository.findFirstByTicketNumber(ticketNumber)).thenReturn(ticket);
        ticketService.ticketVoidByTicketNumber(ticketNumber);
    }

    @Test
    public void myTicketVoidByTicketNumber_whenNowTimeAfterTicketFlyingBoardingTimeThenShouldVoidTicket() throws Exception {
        Airport boardingAirport = new Airport();
        boardingAirport.setId(1L);
        boardingAirport.setCreateDate(new Date());
        boardingAirport.setAirportLocation("Region 1");
        boardingAirport.setAirportName("Airport Name 1");

        Airport destinationAirport = new Airport();
        destinationAirport.setId(2L);
        destinationAirport.setCreateDate(new Date());
        destinationAirport.setAirportLocation("Region 2");
        destinationAirport.setAirportName("Airport Name 2");

        Route route = new Route();
        route.setId(1L);
        route.setStartingPlace(destinationAirport);
        route.setDestination(destinationAirport);
        route.setCreateDate(new Date());
        route.setDistance(1000);
        route.setAirplaneSpeed(1000);
        route.setAirplaneHeight(1000);

        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setId(1L);
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setCompanyName("Airline Company Name");
        airlineCompany.setGeneralCenter("Airline Company Region 1");
        airlineCompany.setEmployeeCount(1000);

        Flying flying = new Flying();
        flying.setId(1L);
        flying.setCreateDate(new Date());
        flying.setAirlineCompany(airlineCompany);
        flying.setFlyingRoute(route);
        flying.setBoardingTime(new Date(new Date().getTime() + 5000L));
        flying.setDestinationTime(new Date());
        flying.setTicketPrice(100D);
        flying.setQuota(100);
        flying.setRemainingQuota(100);

        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(1L);
        flying.setBoardingTime(new Date(new Date().getTime() + 5000L));
        flyingDTO.setDestinationTime(new Date());
        flyingDTO.setAirlineCompanyId(1L);
        flyingDTO.setFlyingRouteId(1L);
        flyingDTO.setQuota(90);
        flyingDTO.setRemainingQuota(80);
        flyingDTO.setCreateDate(new Date());
        flyingDTO.setTicketPrice(50D);


        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setMoneyPaid(100D);
        ticket.setFlying(flying);
        ticket.setTicketBuyDate(new Date());
        String ticketNumber = String.valueOf(new Date().getTime());
        ticket.setTicketNumber(ticketNumber);

        when(ticketRepository.findFirstByTicketNumber(ticketNumber)).thenReturn(ticket);
        when(flyingService.findById(1L)).thenReturn(flyingDTO);
        ticketService.ticketVoidByTicketNumber(ticketNumber);
    }


}