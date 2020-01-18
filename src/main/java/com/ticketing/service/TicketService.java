package com.ticketing.service;

import com.ticketing.dto.TicketDTO;
import com.ticketing.dto.TicketInfo;

public interface TicketService {


    TicketInfo getTicketInfoByFlyingId(Long flyingId);

    TicketDTO buyTicket(TicketDTO ticketDTO) throws Exception;

    TicketDTO findTicketByTicketNumber(String ticketNumber);

    void ticketVoidByTicketNumber(String ticketNumber) throws Exception;
}
