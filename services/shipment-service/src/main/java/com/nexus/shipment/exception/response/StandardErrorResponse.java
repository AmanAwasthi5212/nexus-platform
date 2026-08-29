package com.nexus.shipment.exception.response;

import java.time.Instant;
import java.util.List;

public record StandardErrorResponse(
    String code,
    String message,
    Instant timestamp,
    String traceId,
    List<ValidationError> errors
) {

    public record ValidationError(
        String field,
        String message
    ) {
    }
}
