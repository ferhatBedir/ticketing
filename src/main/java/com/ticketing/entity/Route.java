package com.ticketing.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "ROUTE")
@Entity
public class Route {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STARTING_PLACE_ID", referencedColumnName = "ID", nullable = false)
    private Airport startingPlace;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DESTINATION_ID", referencedColumnName = "ID", nullable = false)
    private Airport destination;

    @Column(name = "AIRPLANE_SPEED", nullable = false)
    private Integer airplaneSpeed;

    @Column(name = "AIRPLANE_HEIGHT", nullable = false)
    private Integer airplaneHeight;

    @Column(name = "DISTANCE", nullable = false)
    private Integer distance;

}
