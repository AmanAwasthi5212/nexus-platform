package com.nexus.shipment.exception.handler;

import com.nexus.shipment.exception.response.StandardErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorResponse> handleValidationException(
        MethodArgumentNotValidException exception) {

        List<StandardErrorResponse.ValidationError> errors =
            exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new StandardErrorResponse.ValidationError(
                    error.getField(),
                    error.getDefaultMessage()
                ))
                .toList();

        StandardErrorResponse response =
            new StandardErrorResponse(
                "SHIPMENT_VALIDATION_FAILED",
                "Shipment request contains invalid fields",
                Instant.now(),
                null,
                errors
            );

        return ResponseEntity
            .badRequest()
            .body(response);
    }
}
