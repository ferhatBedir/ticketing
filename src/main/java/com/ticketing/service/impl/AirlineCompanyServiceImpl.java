package com.ticketing.service.impl;

import com.ticketing.dto.AirlineCompanyDTO;
import com.ticketing.entity.AirlineCompany;
import com.ticketing.repository.AirlineCompanyRepository;
import com.ticketing.service.AirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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


    private List<AirlineCompanyDTO> convertToAirlineCompanyDTOList(List<AirlineCompany> airlineCompanyList) {
        List<AirlineCompanyDTO> airlineCompanyDTOList = new ArrayList<>();
        if (airlineCompanyList == null || airlineCompanyList.size() == 0) {

        } else {
            airlineCompanyList.forEach(airlineCompany -> {
                AirlineCompanyDTO airlineCompanyDTO = convertToAirlineCompanyDTO(airlineCompany);
                airlineCompanyDTOList.add(airlineCompanyDTO);
            });
        }
        return airlineCompanyDTOList;
    }


    private AirlineCompanyDTO convertToAirlineCompanyDTO(AirlineCompany airlineCompany) {
        AirlineCompanyDTO airlineCompanyDTO = new AirlineCompanyDTO();
        airlineCompanyDTO.setId(airlineCompany.getId());
        airlineCompanyDTO.setCompanyName(airlineCompany.getCompanyName());
        airlineCompanyDTO.setCreateDate(airlineCompany.getCreateDate());
        airlineCompanyDTO.setEmployeeCount(airlineCompany.getEmployeeCount());
        airlineCompanyDTO.setGeneralCenter(airlineCompany.getGeneralCenter());
        return airlineCompanyDTO;

    }


    private AirlineCompany convertToAirlineCompany(AirlineCompanyDTO airlineCompanyDTO) {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter(airlineCompanyDTO.getGeneralCenter());
        airlineCompany.setCompanyName(airlineCompanyDTO.getCompanyName());
        airlineCompany.setEmployeeCount(airlineCompanyDTO.getEmployeeCount());
        return airlineCompany;
    }
}
