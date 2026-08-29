package com.nexus.shipment.service;

import com.nexus.shipment.dto.ShipmentCreateRequestDto;
import com.nexus.shipment.dto.ShipmentCreateResponseDto;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ShipmentService {

    public ShipmentCreateResponseDto createShipment(ShipmentCreateRequestDto request) {
        return new ShipmentCreateResponseDto( "SHP-DEMO-001",
            "CREATED",
            Instant.now());
    }
}
