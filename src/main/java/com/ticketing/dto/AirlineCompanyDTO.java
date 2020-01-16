package com.ticketing.dto;

import lombok.Data;

import java.util.Date;


@Data
public class AirlineCompanyDTO {


    private Long id;
    private Date createDate;
    private String companyName;
    private String generalCenter;
    private Integer employeeCount;
}
