package com.ticketing.repository;

import com.ticketing.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findFirstById(Long tickerId);

    Ticket findFirstByTicketNumber(String ticketNumber);

    Ticket findFirstByFlyingId(Long flyingId);
}
