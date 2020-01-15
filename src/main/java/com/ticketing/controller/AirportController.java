package com.ticketing.controller;

import com.ticketing.service.AirportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketing/airport")
@Api(tags = "AirportController API")
public class AirportController {

    @Autowired
    private AirportService airportService;




}
