package com.ticketing.service.impl;

import com.ticketing.dto.RouteDTO;
import com.ticketing.entity.Route;
import com.ticketing.repository.RouteRepository;
import com.ticketing.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
