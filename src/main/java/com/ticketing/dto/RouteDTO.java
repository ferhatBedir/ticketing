package com.ticketing.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RouteDTO {

    private Long id;
    private Date createDate;
    private AirportDTO startingPlace;
    private AirportDTO destination;
    private Integer airplaneSpeed;
    private Integer airplaneHeight;
    private Integer distance;
}
