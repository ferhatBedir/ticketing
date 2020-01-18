package com.ticketing.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TicketDTO {


    private Long id;
    @NotNull
    private Long flyingId;
    @NotNull
    private Double ticketMoney;

    private String ticketNumber;

    private Date ticketBuyDate;

    private Double moneyPaid;
}
