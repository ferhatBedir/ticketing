package com.ticketing.service.impl;

import com.ticketing.dto.RouteDTO;
import com.ticketing.entity.Airport;
import com.ticketing.entity.Route;
import com.ticketing.exception.ExceptionMessage;
import com.ticketing.repository.AirportRepository;
import com.ticketing.repository.RouteRepository;
import com.ticketing.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Transactional
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private AirportRepository airportRepository;


    @Override
    public void addRoute(RouteDTO routeDTO) {
        Route route = convertToRoute(routeDTO);
        Airport boardingAirport = airportRepository.findFirstById(routeDTO.getBoardingAirportId());
        Airport destinationAirport = airportRepository.findFirstById(routeDTO.getDestinationAirportId());
        if (boardingAirport == null || destinationAirport == null) {
            throw new NullPointerException(ExceptionMessage.BOARDING_AIRPORT_OR_DESTINATION_AIRPORT_NOT_FOUND);
        }
        route.setDestination(destinationAirport);
        route.setStartingPlace(boardingAirport);
        routeRepository.save(route);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RouteDTO> findAllRoute() {
        List<Route> routeList = routeRepository.findAll();
        return convertToRouteDTOList(routeList);
    }

    @Override
    @Transactional(readOnly = true)
    public RouteDTO findByRouteId(Long routeId) {
        Route route = routeRepository.findFirstById(routeId);
        return convertToRouteDTO(route);
    }

    @Override
    public void updateRoute(Long routeId, RouteDTO routeDTO) {
        Route route = routeRepository.findFirstById(routeId);
        if (route == null || routeDTO == null) {
            throw new NullPointerException(ExceptionMessage.SOME_PARAMETERS_IS_NULL);
        }
        Airport boardingAirport = airportRepository.findFirstById(routeDTO.getBoardingAirportId());
        Airport destinationAirport = airportRepository.findFirstById(routeDTO.getDestinationAirportId());
        if (boardingAirport == null || destinationAirport == null) {
            throw new NullPointerException(ExceptionMessage.BOARDING_AIRPORT_OR_DESTINATION_AIRPORT_NOT_FOUND);
        }

        route.setDistance(routeDTO.getDistance());
        route.setAirplaneSpeed(routeDTO.getAirplaneSpeed());
        route.setAirplaneHeight(routeDTO.getAirplaneHeight());
        route.setStartingPlace(boardingAirport);
        route.setDestination(destinationAirport);
        routeRepository.save(route);
    }

    @Override
    public void deleteRoute(Long routeId) {
        Route route = routeRepository.findFirstById(routeId);
        if (route == null) {
            throw new NullPointerException(ExceptionMessage.ROUTE_NOT_FOUND);
        }
        routeRepository.delete(route);
    }

    private List<RouteDTO> convertToRouteDTOList(List<Route> routeList) {
        if (routeList == null || routeList.size() == 0) {
            return new ArrayList<>();
        }
        List<RouteDTO> routeDTOList = new ArrayList<>();
        routeList.forEach(route -> {
            RouteDTO routeDTO = convertToRouteDTO(route);
            routeDTOList.add(routeDTO);
        });
        return routeDTOList;
    }

    private RouteDTO convertToRouteDTO(Route route) {
        if (route == null) {
            return null;
        }
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(route.getId());
        routeDTO.setAirplaneHeight(route.getAirplaneHeight());
        routeDTO.setAirplaneSpeed(route.getAirplaneSpeed());
        routeDTO.setCreateDate(route.getCreateDate());
        routeDTO.setBoardingAirportId(route.getStartingPlace().getId());
        routeDTO.setDestinationAirportId(route.getDestination().getId());
        routeDTO.setDistance(route.getDistance());
        return routeDTO;
    }

    private Route convertToRoute(RouteDTO routeDTO) {
        if (routeDTO == null || (routeDTO.getAirplaneHeight() == null ||
                routeDTO.getAirplaneSpeed() == null ||
                routeDTO.getDistance() == null)) {
            throw new NullPointerException(ExceptionMessage.SOME_PARAMETERS_IS_NULL);
        }
        Route route = new Route();
        route.setAirplaneHeight(routeDTO.getAirplaneHeight());
        route.setAirplaneSpeed(routeDTO.getAirplaneSpeed());
        route.setCreateDate(new Date());
        route.setDistance(routeDTO.getDistance());
        return route;
    }
}
