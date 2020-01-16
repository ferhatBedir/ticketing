package com.ticketing.service;

import com.ticketing.dto.FlyingDTO;

import java.util.List;

public interface FlyingService {

    void addNewFlying(FlyingDTO flyingDTO);

    List<FlyingDTO> findAllActiveFlying();

    List<FlyingDTO> findAll();

    FlyingDTO findById(Long flyingId);

    void update(Long flyingId, FlyingDTO flyingDTO);

    void deleteByFlyingId(Long flyingId);
}
