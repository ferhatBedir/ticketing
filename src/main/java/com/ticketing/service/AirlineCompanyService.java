package com.ticketing.service;

import com.ticketing.dto.AirlineCompanyDTO;

import java.util.List;

public interface AirlineCompanyService {

    void addAirlineCompany(AirlineCompanyDTO airlineCompanyDTO);

    List<AirlineCompanyDTO> findAllAirlineCompany();

    AirlineCompanyDTO findByAirlineCompanyId(Long airlineId);

    void updateAirlineCompany(Long airlineId, AirlineCompanyDTO airlineCompanyDTO);

    void deleteAirlineCompany(Long airlineId);
}
