package com.ticketing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "flying", catalog = "tempdb", schema = "dbo")
@Entity
public class Flying {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AIRLINE_COMPANY_ID", referencedColumnName = "ID", nullable = false)
    private AirlineCompany airlineCompany;

    @Column(name = "BOARDING_TIME", nullable = false)
    private Date boardingTime;

    @Column(name = "DESTINATION_TIME")
    private Date destinationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FLYING_ROUTE_ID", referencedColumnName = "ID", nullable = false)
    private Route flyingRoute;

    @Column(name = "PRICE", nullable = false)
    private Double ticketPrice;

    @Column(name = "QUOTA", nullable = false)
    private Integer quota;

    @Column(name = "REMAINING_QUOTA", nullable = false)
    private Integer remainingQuota;
}
