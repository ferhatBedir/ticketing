package com.ticketing.repository;


import com.ticketing.entity.Flying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlyingRepository extends JpaRepository<Flying, Long> {

    Flying findFirstById(Long flyingId);

    List<Flying> findOneByBoardingTimeAfter(Date date);
}
