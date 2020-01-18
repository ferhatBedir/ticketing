package com.ticketing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "ticket", catalog = "tempdb", schema = "dbo")
@Entity
public class Ticket {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FLYING_ID", referencedColumnName = "ID", nullable = false)
    private Flying flying;

    @Column(name = "TICKET_NUMBER", nullable = false)
    private String ticketNumber;

    @Column(name = "TICKET_BUY_DATE", nullable = false)
    private Date ticketBuyDate;

    @Column(name = "MONEY_PAID", nullable = false)
    private Double moneyPaid;
}
