package com.ticketing.service;

import com.ticketing.dto.RouteDTO;

import java.util.List;

public interface RouteService {

    void addRoute(RouteDTO routeDTO);

    List<RouteDTO> findAllRoute();

    RouteDTO findByRouteId(Long routeId);

    void updateRoute(Long routeId, RouteDTO routeDTO);

    void deleteRoute(Long routeId);
}
