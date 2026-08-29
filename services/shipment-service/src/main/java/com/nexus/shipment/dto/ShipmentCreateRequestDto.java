package com.nexus.shipment.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ShipmentCreateRequestDto (

    @NotNull(message = "Sender is required")
    @Valid
    ContactDto sender,

    @NotNull(message = "Receiver is required")
    @Valid
    ContactDto receiver,

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be greater than zero")
    BigDecimal weight,

    @NotNull(message = "Weight unit is required")
    String weightUnit,

    String packageDescription
) {
}
