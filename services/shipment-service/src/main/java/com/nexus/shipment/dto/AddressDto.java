package com.nexus.shipment.dto;


import jakarta.validation.constraints.NotBlank;

public record AddressDto(

    @NotBlank(message = "Address line 1 is required")
    String addressLine1,

    String addressLine2,

    @NotBlank(message = "City is required")
    String city,

    @NotBlank(message = "State is required")
    String state,

    @NotBlank(message = "Postal code is required")
    String postalCode,

    @NotBlank()
    String country
) {
}
