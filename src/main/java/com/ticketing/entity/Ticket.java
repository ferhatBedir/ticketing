package com.ticketing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "ticket", catalog = "master", schema = "dbo")
@Entity
public class Ticket {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FLYING_ID", referencedColumnName = "ID", nullable = false)
    private Flying flying;

    @Column(name = "PRICE", nullable = false)
    private Double ticketPrice;

    @Column(name = "QUOTA", nullable = false)
    private Integer quota;

    @Column(name = "REMAINING_QUOTA", nullable = false)
    private Integer remainingQuota;

    @Column(name = "TICKET_NUMBER", nullable = false)
    private Integer ticketNumber;

    @Column(name = "TICKET_BUY_DATE", nullable = false)
    private Date ticketBuyDate;
}
