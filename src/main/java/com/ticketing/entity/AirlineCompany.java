package com.ticketing.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "AIRLINE_COMPANY")
@Entity
public class AirlineCompany {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "GENERAL_CENTER", nullable = false)
    private String generalCenter;

    @Column(name = "EMPLOYEE_COUNT", nullable = false)
    private Integer employeeCount;


}
