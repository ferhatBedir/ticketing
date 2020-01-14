package com.ticketing.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "AIRPORT")
@Entity
public class Airport {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AIRPORT_NAME", nullable = false)
    private String airportName;


    @Column(name = "AIRPORT_LOCATION", nullable = false)
    private String airportLocation;

}
