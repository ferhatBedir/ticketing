package com.ticketing.controller;


import com.ticketing.service.RouteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketing/route")
@Api(tags = "RouteController API")
public class RouteController {

    @Autowired
    private RouteService routeService;




}
