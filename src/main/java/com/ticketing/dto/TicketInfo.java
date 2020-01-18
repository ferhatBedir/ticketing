package com.ticketing.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TicketInfo {

    private Long flyingId;
    private Long airlineCompanyId;
    private Date boardingTime;
    private Date destinationTime;
    private Long flyingRouteId;
    private Double ticketPrice;
    private Integer quota;
    private Integer remainingQuota;
}
