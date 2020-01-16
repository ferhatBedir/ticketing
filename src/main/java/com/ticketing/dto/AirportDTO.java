package com.ticketing.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AirportDTO {

    private Long id;
    private Date createDate;
    @NotNull
    private String airportName;
    @NotNull
    private String airportLocation;
}
