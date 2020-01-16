package com.ticketing.service;

import com.ticketing.dto.AirportDTO;

import java.util.List;

public interface AirportService {

    void addAirport(AirportDTO airportDTO);

    List<AirportDTO> findAllAirport();

    AirportDTO findByAirportId(Long id);

    void updateAirport(Long airportId, AirportDTO airportDTO);

    void deleteAirport(Long airportId);
}
