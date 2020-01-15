package com.ticketing.controller;


import com.ticketing.service.FlyingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketing/flying")
@Api(tags = "FlyingController API")
public class FlyingController {

    @Autowired
    private FlyingService flyingService;




}
