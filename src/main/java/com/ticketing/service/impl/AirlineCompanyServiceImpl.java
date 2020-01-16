package com.ticketing.service.impl;

import com.ticketing.dto.AirlineCompanyDTO;
import com.ticketing.entity.AirlineCompany;
import com.ticketing.repository.AirlineCompanyRepository;
import com.ticketing.service.AirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    @Autowired
    private AirlineCompanyRepository airlineCompanyRepository;


    @Override
    public void addAirlineCompany(AirlineCompanyDTO airlineCompanyDTO) {
        /**
         * add method will write
         */
    }

    @Override
    public List<AirlineCompanyDTO> findAllAirlineCompany() {
        /**
         * findAll method will write
         */
        return null;
    }

    @Override
    public AirlineCompanyDTO findByAirlineCompanyId(Long airlineId) {
        /**
         * find method will write
         */
        AirlineCompany airlineCompany = airlineCompanyRepository.findFirstById(airlineId);
        return null;
    }

    @Override
    public void updateAirlineCompany(Long airlineId, AirlineCompanyDTO airlineCompanyDTO) {
        /**
         * update method will write
         */
    }

    @Override
    public void deleteAirlineCompany(Long airlineId) {
        /**
         * delete method will write
         */
    }
}
