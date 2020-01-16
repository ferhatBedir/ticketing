package com.ticketing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "airport_company", catalog = "master", schema = "dbo")
@Entity
public class AirlineCompany {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "GENERAL_CENTER", nullable = false)
    private String generalCenter;

    @Column(name = "EMPLOYEE_COUNT", nullable = false)
    private Integer employeeCount;


}
