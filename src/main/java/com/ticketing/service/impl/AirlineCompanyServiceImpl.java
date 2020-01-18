package com.ticketing.service.impl;

import com.ticketing.dto.AirlineCompanyDTO;
import com.ticketing.entity.AirlineCompany;
import com.ticketing.exception.ExceptionMessage;
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
        AirlineCompany airlineCompany = convertToAirlineCompany(airlineCompanyDTO);
        if (airlineCompany == null) {
            throw new NullPointerException(ExceptionMessage.PARAMETER_IS_NULL);
        }
        airlineCompanyRepository.save(airlineCompany);

    }

    @Override
    @Transactional(readOnly = true)
    public List<AirlineCompanyDTO> findAllAirlineCompany() {
        List<AirlineCompany> airlineCompanyList = airlineCompanyRepository.findAll();
        if (airlineCompanyList == null || airlineCompanyList.size() == 0) {
            return null;
        } else {
            return convertToAirlineCompanyDTOList(airlineCompanyList);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public AirlineCompanyDTO findByAirlineCompanyId(Long airlineId) {
        AirlineCompany airlineCompany = airlineCompanyRepository.findFirstById(airlineId);
        return convertToAirlineCompanyDTO(airlineCompany);
    }

    @Override
    public void updateAirlineCompany(Long airlineId, AirlineCompanyDTO airlineCompanyDTO) {
        AirlineCompany airlineCompany = airlineCompanyRepository.findFirstById(airlineId);
        if (airlineCompany == null || airlineCompanyDTO == null) {
            throw new NullPointerException(ExceptionMessage.SOME_PARAMETERS_IS_NULL);
        }
        airlineCompany.setGeneralCenter(airlineCompanyDTO.getGeneralCenter());
        airlineCompany.setCompanyName(airlineCompanyDTO.getCompanyName());
        airlineCompany.setEmployeeCount(airlineCompanyDTO.getEmployeeCount());

        airlineCompanyRepository.save(airlineCompany);
    }

    @Override
    public void deleteAirlineCompany(Long airlineId) {
        AirlineCompany airlineCompany = airlineCompanyRepository.findFirstById(airlineId);
        if (airlineCompany == null) {
            throw new NullPointerException(ExceptionMessage.AIRLINE_NOT_FOUND);
        }
        airlineCompanyRepository.delete(airlineCompany);
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
        if (airlineCompany == null) {
            return null;
        }
        AirlineCompanyDTO airlineCompanyDTO = new AirlineCompanyDTO();
        airlineCompanyDTO.setId(airlineCompany.getId());
        airlineCompanyDTO.setCompanyName(airlineCompany.getCompanyName());
        airlineCompanyDTO.setCreateDate(airlineCompany.getCreateDate());
        airlineCompanyDTO.setEmployeeCount(airlineCompany.getEmployeeCount());
        airlineCompanyDTO.setGeneralCenter(airlineCompany.getGeneralCenter());
        return airlineCompanyDTO;

    }

    private AirlineCompany convertToAirlineCompany(AirlineCompanyDTO airlineCompanyDTO) {
        if (airlineCompanyDTO == null ||
                (airlineCompanyDTO.getCompanyName() == null ||
                        airlineCompanyDTO.getGeneralCenter() == null ||
                        airlineCompanyDTO.getEmployeeCount() == null)) {
            throw new NullPointerException(ExceptionMessage.PARAMETER_IS_NULL);
        }
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setCreateDate(new Date());
        airlineCompany.setGeneralCenter(airlineCompanyDTO.getGeneralCenter());
        airlineCompany.setCompanyName(airlineCompanyDTO.getCompanyName());
        airlineCompany.setEmployeeCount(airlineCompanyDTO.getEmployeeCount());
        return airlineCompany;
    }
}
