package com.ticketing.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TicketDto {


    private Long id;
    @NotNull
    private Long flyingId;
    @NotNull
    private Double ticketPrice;

    private Integer quota;

    private Integer remainingQuota;

    private Integer ticketNumber;

    private Date ticketBuyDate;
}
