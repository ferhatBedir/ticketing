package com.ticketing.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RouteDTO {

    private Long id;
    private Date createDate;
    @NotNull
    private AirportDTO startingPlace;
    @NotNull
    private AirportDTO destination;
    @NotNull
    private Integer airplaneSpeed;
    @NotNull
    private Integer airplaneHeight;
    @NotNull
    private Integer distance;
}
