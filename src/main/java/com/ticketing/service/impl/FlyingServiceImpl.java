package com.ticketing.service.impl;

import com.ticketing.dto.FlyingDTO;
import com.ticketing.entity.Flying;
import com.ticketing.repository.FlyingRepository;
import com.ticketing.service.FlyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class FlyingServiceImpl implements FlyingService {

    @Autowired
    private FlyingRepository flyingRepository;


    @Override
    public void addNewFlying(FlyingDTO flyingDTO) {
        /**
         * add method will write
         */
    }

    @Override
    public List<FlyingDTO> findAllActiveFlying() {
        /**
         * findAllActive method will write
         */
        return null;
    }

    @Override
    public List<FlyingDTO> findAll() {
        /**
         * findAll method will write
         */
        return null;
    }

    @Override
    public FlyingDTO findById(Long flyingId) {
        /**
         * find method will write
         */
        Flying flying = flyingRepository.findFirstById(flyingId);
        return null;
    }

    @Override
    public void update(Long flyingId, FlyingDTO flyingDTO) {
        /**
         * update method will write
         */
    }

    @Override
    public void deleteByFlyingId(Long flyingId) {
        /**
         * delete method will write
         */
    }


}
