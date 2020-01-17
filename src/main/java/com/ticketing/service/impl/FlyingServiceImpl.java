package com.ticketing.service.impl;

import com.ticketing.dto.FlyingDTO;
import com.ticketing.entity.AirlineCompany;
import com.ticketing.entity.Airport;
import com.ticketing.entity.Flying;
import com.ticketing.entity.Route;
import com.ticketing.exception.ExceptionMessage;
import com.ticketing.repository.AirlineCompanyRepository;
import com.ticketing.repository.AirportRepository;
import com.ticketing.repository.FlyingRepository;
import com.ticketing.repository.RouteRepository;
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

    private FlyingRepository flyingRepository;
    private RouteRepository routeRepository;
    private AirlineCompanyRepository airlineCompanyRepository;
    private AirportRepository airportRepository;

    @Autowired
    public FlyingServiceImpl(FlyingRepository flyingRepository,
                             RouteRepository routeRepository,
                             AirlineCompanyRepository airlineCompanyRepository, AirportRepository airportRepository) {
        this.flyingRepository = flyingRepository;
        this.routeRepository = routeRepository;
        this.airlineCompanyRepository = airlineCompanyRepository;
        this.airportRepository = airportRepository;
    }


    @Override
    public void addNewFlying(FlyingDTO flyingDTO) {
        Flying flying = convertToFlying(flyingDTO);
        if (flying == null) {
            throw new NullPointerException(ExceptionMessage.SOME_PARAMETERS_IS_NULL);
        }
        AirlineCompany airlineCompany = airlineCompanyRepository.findFirstById(flyingDTO.getAirlineCompanyId());
        Route route = routeRepository.findFirstById(flyingDTO.getFlyingRouteId());
        if (route == null || airlineCompany == null) {
            throw new NullPointerException(ExceptionMessage.ROUTE_OR_AIRLINE_COMPANY_IS_NULL);
        }
        flying.setFlyingRoute(route);
        flying.setAirlineCompany(airlineCompany);
        flyingRepository.save(flying);
    }

    @Override
    public List<FlyingDTO> findAllActiveFlying() {
        List<Flying> flyingList = flyingRepository.findOneByBoardingTimeAfter(new Date());
        return convertToFlyingDTOList(flyingList);
    }

    @Override
    public List<FlyingDTO> findAll() {
        List<Flying> flyingList = flyingRepository.findAll();
        return convertToFlyingDTOList(flyingList);
    }

    @Override
    public FlyingDTO findById(Long flyingId) {
        Flying flying = flyingRepository.findFirstById(flyingId);
        return convertToFlyingDTO(flying);
    }

    @Override
    public void updateFlying(Long flyingId, FlyingDTO flyingDTO) throws Exception {
        Flying flying = flyingRepository.findFirstById(flyingId);
        if (flying == null || flyingDTO == null) {
            throw new NullPointerException(ExceptionMessage.SOME_PARAMETERS_IS_NULL);
        }
        Route route = routeRepository.findFirstById(flyingDTO.getFlyingRouteId());
        AirlineCompany airlineCompany = airlineCompanyRepository.findFirstById(flyingDTO.getAirlineCompanyId());
        if (route == null || airlineCompany == null) {
            throw new NullPointerException(ExceptionMessage.ROUTE_OR_AIRLINE_COMPANY_IS_NULL);
        }
        Airport boardingAirport = airportRepository.findFirstById(route.getStartingPlace().getId());
        Airport destinationAirport = airportRepository.findFirstById(route.getDestination().getId());
        if (boardingAirport == null || destinationAirport == null) {
            throw new NullPointerException(ExceptionMessage.BOARDING_AIRPORT_OR_DESTINATION_AIRPORT_NOT_FOUND);
        }

        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);

        flying.setFlyingRoute(route);
        flying.setAirlineCompany(airlineCompany);
        if ((flyingDTO.getBoardingTime().getTime() < flying.getBoardingTime().getTime()) ||
                (flyingDTO.getDestinationTime().getTime() < flyingDTO.getBoardingTime().getTime())) {
            throw new Exception(ExceptionMessage.BOARDING_TIME_CANNOT_BE_SMALLER);
        }
        flying.setBoardingTime(flyingDTO.getBoardingTime());
        flying.setDestinationTime(flyingDTO.getDestinationTime());
        flyingRepository.save(flying);

    }

    @Override
    public void deleteByFlyingId(Long flyingId) {
        Flying flying = flyingRepository.findFirstById(flyingId);
        if (flying == null) {
            throw new NullPointerException(ExceptionMessage.FLYING_NOT_FOUND);
        }
        flyingRepository.delete(flying);
    }

    private List<FlyingDTO> convertToFlyingDTOList(List<Flying> flyingList) {
        List<FlyingDTO> flyingDTOList = new ArrayList<>();
        if (flyingList == null || flyingList.size() == 0) {
            return flyingDTOList;
        } else {
            flyingList.forEach(flying -> {
                FlyingDTO flyingDTO = convertToFlyingDTO(flying);
                flyingDTOList.add(flyingDTO);
            });
        }
        return flyingDTOList;
    }

    private FlyingDTO convertToFlyingDTO(Flying flying) {
        if (flying == null) {
            return null;
        }
        FlyingDTO flyingDTO = new FlyingDTO();
        flyingDTO.setId(flying.getId());
        flyingDTO.setBoardingTime(flying.getBoardingTime());
        flyingDTO.setCreateDate(flying.getCreateDate());
        flyingDTO.setDestinationTime(flying.getDestinationTime());
        flyingDTO.setFlyingRouteId(flying.getFlyingRoute().getId());
        flyingDTO.setAirlineCompanyId(flying.getAirlineCompany().getId());
        return flyingDTO;
    }

    private Flying convertToFlying(FlyingDTO flyingDTO) {
        if (flyingDTO != null && (flyingDTO.getBoardingTime() != null &&
                flyingDTO.getDestinationTime() != null &&
                flyingDTO.getAirlineCompanyId() != null &&
                flyingDTO.getFlyingRouteId() != null)) {
            Flying flying = new Flying();
            flying.setBoardingTime(flyingDTO.getBoardingTime());
            flying.setCreateDate(new Date());
            flying.setDestinationTime(flyingDTO.getDestinationTime());
            return flying;
        }
        return null;
    }


}
