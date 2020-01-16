package com.ticketing.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class FlyingDTO {

    private Long id;
    private Date createDate;
    @NotNull
    private AirlineCompanyDTO airlineCompany;
    @NotNull
    private Date boardingTime;
    @NotNull
    private Date destinationTime;
    @NotNull
    private RouteDTO flyingRoute;
    @NotNull
    private Double price;
    @NotNull
    private Integer quota;
    @NotNull
    private Integer remainingQuota;
}
