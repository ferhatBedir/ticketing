package com.ticketing.controller;


import com.ticketing.dto.RouteDTO;
import com.ticketing.service.RouteService;
import com.ticketing.util.VerificationProcedures;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing/route")
@Api(tags = "RouteController API")
public class RouteController {


    private RouteService routeService;
    private VerificationProcedures verificationProcedures;


    @Autowired
    public RouteController(RouteService routeService, VerificationProcedures verificationProcedures) {
        this.routeService = routeService;
        this.verificationProcedures = verificationProcedures;
    }


    @PostMapping("/add")
    public void addNewRoute(@RequestBody RouteDTO routeDTO) {
        verificationProcedures.checkData(routeDTO);
        routeService.addRoute(routeDTO);
    }

    @GetMapping("/findAll")
    public List<RouteDTO> findAllRoute() {
        return routeService.findAllRoute();
    }

    @GetMapping("/find")
    public RouteDTO findById(@RequestParam(value = "id") Long routeId) {
        return routeService.findByRouteId(routeId);
    }

    @PostMapping("/update")
    public void update(@RequestParam(value = "id") Long routeId, @RequestBody RouteDTO routeDTO) {
        verificationProcedures.checkData(routeDTO);
        routeService.updateRoute(routeId, routeDTO);
    }

    @DeleteMapping("/delete")
    public void deleteRoute(@RequestParam(value = "id")Long routeId){
        routeService.deleteRoute(routeId);
    }
}
