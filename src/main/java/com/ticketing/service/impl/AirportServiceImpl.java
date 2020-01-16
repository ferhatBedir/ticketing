package com.ticketing.service.impl;

import com.ticketing.dto.AirportDTO;
import com.ticketing.entity.Airport;
import com.ticketing.repository.AirportRepository;
import com.ticketing.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        airportRepository.save(airport);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AirportDTO> findAllAirport() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public AirportDTO findByAirportId(Long id) {
        return null;
    }

    @Override
    public void updateAirport(Long airportId, AirportDTO airportDTO) {

    }

    @Override
    public void deleteAirport(Long airportId) {

    }

    private Airport convertToAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setCreateDate(new Date());
        airport.setAirportName(airportDTO.getAirportName());
        airport.setAirportLocation(airportDTO.getAirportLocation());
        return airport;
    }
}
