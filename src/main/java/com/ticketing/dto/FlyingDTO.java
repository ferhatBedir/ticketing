package com.ticketing.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class FlyingDTO {

    private Long id;
    private Date createDate;
    @NotNull
    private Long airlineCompanyId;
    @NotNull
    private Date boardingTime;
    @NotNull
    private Date destinationTime;
    @NotNull
    private Long flyingRouteId;
}
