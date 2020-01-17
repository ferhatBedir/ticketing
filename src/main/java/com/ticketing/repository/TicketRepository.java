package com.ticketing.repository;

import com.ticketing.entity.Ticket;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaEntityInformation<Ticket, Long> {

    Ticket findFirstById(Long tickerId);

    Ticket findFirstByTicketNumber(Integer ticketNumber);

    Ticket findFirstByFlyingId(Long flyingId);
}
