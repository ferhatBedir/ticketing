package com.ticketing.service.impl;

import com.ticketing.dto.FlyingDTO;
import com.ticketing.entity.Flying;
import com.ticketing.repository.FlyingRepository;
import com.ticketing.service.FlyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    private List<FlyingDTO> convertToFlyingDTOList(List<Flying> flyingList) {
        List<FlyingDTO> flyingDTOList = new ArrayList<>();
        if (flyingList == null || flyingList.size() == 0) {

        } else {
            flyingList.forEach(flying -> {
                FlyingDTO flyingDTO = convertToFlyingDTO(flying);
                flyingDTOList.add(flyingDTO);
            });
        }
        return flyingDTOList;
    }

    private FlyingDTO convertToFlyingDTO(Flying flying) {
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(flying.getId());
//        flyingDTO.setAirlineCompany(flying.getAirlineCompany());
        flyingDTO.setBoardingTime(flying.getBoardingTime());
        flyingDTO.setCreateDate(flying.getCreateDate());
        flyingDTO.setDestinationTime(flying.getDestinationTime());
//        flyingDTO.setFlyingRoute(flying.getFlyingRoute());
        return flyingDTO;
    }

    private Flying convertToFlying(FlyingDTO flyingDTO) {
        Flying flying = new Flying();
//        flying.setAirlineCompany(flyingDTO.getAirlineCompany());
        flying.setBoardingTime(flyingDTO.getBoardingTime());
        flying.setCreateDate(new Date());
        flying.setDestinationTime(flyingDTO.getDestinationTime());
//        flying.setFlyingRoute(flyingDTO.getFlyingRoute());
        return null;
    }


}
