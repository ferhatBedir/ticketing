package com.ticketing.service;

import com.ticketing.dto.FlyingDTO;
import com.ticketing.entity.Flying;

import java.util.List;

public interface FlyingService {

    void addNewFlying(FlyingDTO flyingDTO);

    List<FlyingDTO> findAllActiveFlying();

    List<FlyingDTO> findAll();

    FlyingDTO findById(Long flyingId);

    void updateFlying(Long flyingId, FlyingDTO flyingDTO) throws Exception;

    void deleteByFlyingId(Long flyingId);

    Flying findByIdForTicket(Long flyingId);
}
