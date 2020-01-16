package com.ticketing.controller;

import com.ticketing.dto.AirportDTO;
import com.ticketing.service.AirportService;
import com.ticketing.util.VerificationProcedures;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing/airport")
@Api(tags = "AirportController API")
public class AirportController {


    private AirportService airportService;
    private VerificationProcedures verificationProcedures;

    @Autowired
    public AirportController(AirportService airportService, VerificationProcedures verificationProcedures) {
        this.airportService = airportService;
        this.verificationProcedures = verificationProcedures;
    }


    @PostMapping("/add")
    public void addNewAirport(@RequestBody AirportDTO airportDTO) {
        verificationProcedures.checkData(airportDTO);
        airportService.addAirport(airportDTO);
    }

    @GetMapping("/findAll")
    public List<AirportDTO> findAllAirport() {
        return airportService.findAllAirport();
    }

    @GetMapping("/find")
    public AirportDTO findById(@RequestParam(value = "id") Long airportId) {
        return airportService.findByAirportId(airportId);
    }

    @PostMapping("/update")
    public void updateAirport(@RequestParam(value = "id") Long airportId, @RequestBody AirportDTO airportDTO) {
        verificationProcedures.checkData(airportDTO);
        airportService.updateAirport(airportId, airportDTO);
    }


    @DeleteMapping("/delete")
    public void deleteAirport(@RequestParam(value = "id") Long airportId) {
        airportService.deleteAirport(airportId);
    }
}
