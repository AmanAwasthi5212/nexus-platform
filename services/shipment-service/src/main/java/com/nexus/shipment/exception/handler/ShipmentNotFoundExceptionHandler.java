package com.nexus.shipment.exception.handler;

import com.nexus.shipment.exception.ShipmentNotFoundException;
import com.nexus.shipment.exception.response.StandardErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Collections;

@RestControllerAdvice
public class ShipmentNotFoundExceptionHandler {

    @ExceptionHandler(ShipmentNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> handleShipmentNotFound(
        ShipmentNotFoundException exception) {

        StandardErrorResponse response =
            new StandardErrorResponse(
                "SHIPMENT_NOT_FOUND",
                exception.getMessage(),
                Instant.now(),
                null,
                Collections.emptyList()
            );

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(response);
    }
}
