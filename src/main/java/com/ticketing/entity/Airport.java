package com.ticketing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "airport", catalog = "master", schema = "dbo")
@Entity
public class Airport {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Column(name = "AIRPORT_NAME", nullable = false)
    private String airportName;

    @Column(name = "AIRPORT_LOCATION", nullable = false)
    private String airportLocation;

}
