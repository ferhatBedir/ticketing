package com.ticketing.service.impl;

import com.ticketing.dto.AirportDTO;
import com.ticketing.entity.Airport;
import com.ticketing.exception.ExceptionMessage;
import com.ticketing.repository.AirportRepository;
import com.ticketing.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Transactional
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;


    @Override
    public void addAirport(AirportDTO airportDTO) {
        Airport airport = convertToAirport(airportDTO);
        if (airport == null) {
            throw new NullPointerException(ExceptionMessage.PARAMETER_IS_NULL);
        }
        airportRepository.save(airport);

    }

    @Transactional(readOnly = true)
    @Override
    public List<AirportDTO> findAllAirport() {
        return convertToAirportDTOList(airportRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public AirportDTO findByAirportId(Long id) {
        Airport airport = airportRepository.findFirstById(id);
        return convertToAirportDTO(airport);
    }

    @Override
    public void updateAirport(Long airportId, AirportDTO airportDTO) {
        Airport airport = airportRepository.findFirstById(airportId);
        if (airportDTO == null || airport == null) {
            throw new NullPointerException(ExceptionMessage.SOME_PARAMETERS_IS_NULL);
        }
        airport.setAirportName(airportDTO.getAirportName());
        airport.setAirportLocation(airportDTO.getAirportLocation());
        airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(Long airportId) {
        Airport airport = airportRepository.findFirstById(airportId);
        if (airport == null) {
            throw new NullPointerException(ExceptionMessage.AIRPORT_NOT_FOUND);
        }
        airportRepository.delete(airport);
    }

    private Airport convertToAirport(AirportDTO airportDTO) {
        if ((airportDTO != null) && (airportDTO.getAirportLocation() != null && airportDTO.getAirportName() != null)) {
            Airport airport = new Airport();
            airport.setCreateDate(new Date());
            airport.setAirportName(airportDTO.getAirportName());
            airport.setAirportLocation(airportDTO.getAirportLocation());
            return airport;
        }
        return null;
    }

    private List<AirportDTO> convertToAirportDTOList(List<Airport> airportList) {
        List<AirportDTO> airportDTOList = new ArrayList<>();
        if (airportList != null && airportList.size() != 0) {
            airportList.forEach(airport -> {
                AirportDTO airportDTO = convertToAirportDTO(airport);
                airportDTOList.add(airportDTO);
            });
        }
        return airportDTOList;
    }

    private AirportDTO convertToAirportDTO(Airport airport) {
        if (airport == null) {
            return null;
        }
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setId(airport.getId());
        airportDTO.setAirportName(airport.getAirportName());
        airportDTO.setAirportLocation(airport.getAirportLocation());
        airportDTO.setCreateDate(airport.getCreateDate());
        return airportDTO;
    }
}
