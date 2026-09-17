package com.nexus.shipment.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record ShipmentResponseDto(
    String shipmentId,
    String status,
    ContactDto sender,
    ContactDto receiver,
    BigDecimal weight,
    String weightUnit,
    String packageDescription,
    Instant createdAt
) {
}
