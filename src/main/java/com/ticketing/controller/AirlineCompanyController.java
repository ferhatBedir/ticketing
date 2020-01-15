package com.ticketing.controller;


import com.ticketing.service.AirlineCompanyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketing/airline")
@Api(tags = "AirlineCompanyController API")
public class AirlineCompanyController {

    @Autowired
    private AirlineCompanyService airlineCompanyService;



}
