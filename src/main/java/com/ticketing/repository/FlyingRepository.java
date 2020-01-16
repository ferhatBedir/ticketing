package com.ticketing.repository;


import com.ticketing.entity.Flying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyingRepository extends JpaRepository<Flying, Long> {

    Flying findFirstById(Long flyingId);
}
