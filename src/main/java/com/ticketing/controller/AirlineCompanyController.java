package com.ticketing.controller;


import com.ticketing.dto.AirlineCompanyDTO;
import com.ticketing.service.AirlineCompanyService;
import com.ticketing.util.VerificationProcedures;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing/airline")
@Api(tags = "AirlineCompanyController API")
public class AirlineCompanyController {

    private AirlineCompanyService airlineCompanyService;
    private VerificationProcedures verificationProcedures;

    @Autowired
    public AirlineCompanyController(AirlineCompanyService airlineCompanyService,
                                    VerificationProcedures verificationProcedures) {
        this.airlineCompanyService = airlineCompanyService;
        this.verificationProcedures = verificationProcedures;
    }


    @PostMapping("/add")
    public void addNewAirline(@RequestBody AirlineCompanyDTO airlineCompanyDTO) {
        verificationProcedures.checkData(airlineCompanyDTO);
        airlineCompanyService.addAirlineCompany(airlineCompanyDTO);
    }

    @GetMapping("/findAll")
    public List<AirlineCompanyDTO> findAlAirline() {
        return airlineCompanyService.findAllAirlineCompany();
    }

    @GetMapping("/find")
    public AirlineCompanyDTO findById(@RequestParam(value = "id") Long airlineId) {
        return airlineCompanyService.findByAirlineCompanyId(airlineId);
    }

    @PostMapping("/update")
    public void updateAirline(@RequestParam(value = "id") Long airlineId, @RequestBody AirlineCompanyDTO airlineCompanyDTO) {
        airlineCompanyService.updateAirlineCompany(airlineId, airlineCompanyDTO);
    }

    @DeleteMapping("/delete")
    public void deleteAirline(@RequestParam(value = "id") Long airlineId) {
        airlineCompanyService.deleteAirlineCompany(airlineId);
    }
}
