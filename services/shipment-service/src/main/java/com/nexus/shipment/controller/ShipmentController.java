package com.nexus.shipment.controller;

import com.nexus.shipment.dto.ShipmentCreateRequestDto;
import com.nexus.shipment.dto.ShipmentCreateResponseDto;
import com.nexus.shipment.dto.ShipmentResponseDto;
import com.nexus.shipment.service.ShipmentService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<ShipmentCreateResponseDto> createShipment(@Valid @RequestBody ShipmentCreateRequestDto request) {
        ShipmentCreateResponseDto response = shipmentService.createShipment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipmentResponseDto> getShipmentById(@PathVariable UUID id) {
        ShipmentResponseDto response = shipmentService.getShipmentById(id);
        return ResponseEntity.ok(response);
    }
}
