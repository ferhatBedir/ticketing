package com.ticketing.controller;


import com.ticketing.dto.TicketDTO;
import com.ticketing.dto.TicketInfo;
import com.ticketing.service.TicketService;
import com.ticketing.util.VerificationProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticketing/buy")
public class TicketController {


    private TicketService ticketService;
    private VerificationProcedures verificationProcedures;


    @Autowired
    public TicketController(TicketService ticketService,
                            VerificationProcedures verificationProcedures) {
        this.ticketService = ticketService;
        this.verificationProcedures = verificationProcedures;
    }


    @GetMapping("/ticketInfo")
    public TicketInfo getTicketInfo(@RequestParam(value = "id") Long flyingId) {
        return ticketService.getTicketInfoByFlyingId(flyingId);
    }

    @PostMapping()
    public TicketDTO buyTicket(@RequestBody TicketDTO ticketDTO) throws Exception {
        verificationProcedures.checkData(ticketDTO);
        return ticketService.buyTicket(ticketDTO);
    }

    @GetMapping("/findMyTicket")
    public TicketDTO findMyTicketByTicketNumber(@RequestParam(value = "ticketNumber") String ticketNumber) {
        return ticketService.findTicketByTicketNumber(ticketNumber);
    }

    @GetMapping("/void")
    public void myTicketVoidByTicketNumber(@RequestParam(value = "ticketNumber") String ticketNumber) throws Exception {
        ticketService.ticketVoidByTicketNumber(ticketNumber);
    }


}
