package com.nexus.shipment.dto;

import java.time.Instant;

public record ShipmentCreateResponseDto (
    String shipmentId,
    String status,
    Instant createdAt
) {
}
