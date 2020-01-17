package com.ticketing.service.impl;

import com.ticketing.dto.RouteDTO;
import com.ticketing.entity.Route;
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


    @Override
    public void addRoute(RouteDTO routeDTO) {
        /**
         * add method will write
         */
    }

    @Override
    public List<RouteDTO> findAllRoute() {
        /**
         * findAll method will write
         */
        return null;
    }

    @Override
    public RouteDTO findByRouteId(Long routeId) {
        /**
         * find method will write
         */
        Route route = routeRepository.findFirstById(routeId);
        return null;
    }

    @Override
    public void updateRoute(Long routeId, RouteDTO routeDTO) {
        /**
         * update method will write
         */
    }

    @Override
    public void deleteRoute(Long routeId) {
        /**
         * delete method will write
         */
    }


    private List<RouteDTO> convertToRouteDTOList(List<Route> routeList) {
        List<RouteDTO> routeDTOList = new ArrayList<>();
        if (routeList == null || routeList.size() == 0) {

        } else {
            routeList.forEach(route -> {
                RouteDTO routeDTO = convertToRouteDTO(route);
                routeDTOList.add(routeDTO);
            });
        }
        return routeDTOList;
    }

    private RouteDTO convertToRouteDTO(Route route) {
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(route.getId());
        routeDTO.setAirplaneHeight(route.getAirplaneHeight());
        routeDTO.setAirplaneSpeed(route.getAirplaneSpeed());
        routeDTO.setCreateDate(route.getCreateDate());
//        routeDTO.setStartingPlace(route.getStartingPlace());
//        routeDTO.setDestination(route.getDestination());
        routeDTO.setDistance(route.getDistance());
        return routeDTO;
    }

    private Route convertToRoute(RouteDTO routeDTO) {
        Route route = new Route();
        route.setAirplaneHeight(routeDTO.getAirplaneHeight());
        route.setAirplaneSpeed(routeDTO.getAirplaneSpeed());
        route.setCreateDate(new Date());
//        route.setDestination(routeDTO.getDestination());
        route.setDistance(routeDTO.getDistance());
//        route.setStartingPlace(routeDTO.getStartingPlace());
        return route;
    }
}
