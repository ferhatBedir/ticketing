package com.ticketing.dto;

import lombok.Data;

import java.util.Date;


@Data
public class FlyingDTO {

    private Long id;
    private Date createDate;
    private AirlineCompanyDTO airlineCompany;
    private Date boardingTime;
    private Date destinationTime;
    private RouteDTO flyingRoute;
    private Double price;
    private Integer quota;
    private Integer remainingQuota;
}
