package com.ticketing.controller;


import com.ticketing.dto.FlyingDTO;
import com.ticketing.service.FlyingService;
import com.ticketing.util.VerificationProcedures;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing/flying")
@Api(tags = "FlyingController API")
public class FlyingController {

    private VerificationProcedures verificationProcedures;
    private FlyingService flyingService;

    @Autowired
    public FlyingController(VerificationProcedures verificationProcedures, FlyingService flyingService) {
        this.verificationProcedures = verificationProcedures;
        this.flyingService = flyingService;
    }


    @PostMapping("/add")
    public void addFlying(@RequestBody FlyingDTO flyingDTO) {
        verificationProcedures.checkData(flyingDTO);
        flyingService.addNewFlying(flyingDTO);
    }

    @GetMapping("/findActiveFlying")
    public List<FlyingDTO> findAllActiveFlying() {
        return flyingService.findAllActiveFlying();
    }

    @GetMapping("/findAll")
    public List<FlyingDTO> findAllFlying() {
        return flyingService.findAll();
    }

    @GetMapping("/find")
    public FlyingDTO findByFlyingId(@RequestParam(value = "id") Long flyingId) {
        return flyingService.findById(flyingId);
    }

    @PostMapping("/update")
    public void updateFlying(@RequestParam(value = "id") Long flyingId, @RequestBody FlyingDTO flyingDTO) {
        flyingService.update(flyingId, flyingDTO);
    }

    @DeleteMapping("/delete")
    public void deleteFlying(@RequestParam(value = "id") Long flyingId) {
        flyingService.deleteByFlyingId(flyingId);
    }
}
