package com.ticketing.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class AirlineCompanyDTO {

    private Long id;
    private Date createDate;
    @NotNull
    private String companyName;
    @NotNull
    private String generalCenter;
    @NotNull
    private Integer employeeCount;
}
