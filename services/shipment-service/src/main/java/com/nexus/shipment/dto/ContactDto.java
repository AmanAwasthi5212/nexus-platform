package com.nexus.shipment.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactDto(

    @NotBlank(message = "Full name is required")
    String fullName,

    @NotBlank(message = "Phone number is required")
    String phoneNumber,

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email,

    @NotNull(message = "Address is required")
    @Valid
    AddressDto address
) {
}

