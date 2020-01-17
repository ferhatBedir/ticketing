package com.ticketing.controller;


import com.ticketing.service.TicketService;
import com.ticketing.util.VerificationProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("//ticketing/buy")
public class TicketController {


    private TicketService ticketService;
    private VerificationProcedures verificationProcedures;


    @Autowired
    public TicketController(TicketService ticketService, VerificationProcedures verificationProcedures) {
        this.ticketService = ticketService;
        this.verificationProcedures = verificationProcedures;
    }
}
