package com.nexus.shipment.controller;

import com.nexus.shipment.dto.ShipmentCreateResponseDto;
import com.nexus.shipment.service.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShipmentController.class)
class ShipmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ShipmentService shipmentService;

    @Test
    void shouldCreateShipment() throws Exception {

        when(shipmentService.createShipment(any()))
            .thenReturn(
                new ShipmentCreateResponseDto(
                    "SHP-DEMO-001",
                    "CREATED",
                    Instant.parse("2026-08-27T12:00:00Z")
                )
            );

        String requestBody = """
            {
              "sender": {
                "fullName": "Aman Awasthi",
                "phoneNumber": "+91XXXXXXXXXX",
                "email": "aman@example.com",
                "address": {
                  "addressLine1": "21 Example Road",
                  "addressLine2": "Sector 62",
                  "city": "Noida",
                  "state": "Uttar Pradesh",
                  "postalCode": "201301",
                  "country": "India"
                }
              },
              "receiver": {
                "fullName": "Max Mustermann",
                "phoneNumber": "+49XXXXXXXXXX",
                "email": "max@example.com",
                "address": {
                  "addressLine1": "Alexanderplatz 1",
                  "addressLine2": null,
                  "city": "Berlin",
                  "state": "Berlin",
                  "postalCode": "10178",
                  "country": "Germany"
                }
              },
              "weight": 5.25,
              "weightUnit": "KG",
              "packageDescription": "Electronics accessories"
            }
            """;

        mockMvc.perform(
                post("/api/v1/shipments")
                    .contentType(APPLICATION_JSON)
                    .content(requestBody)
            )
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.shipmentId")
                .value("SHP-DEMO-001"))
            .andExpect(jsonPath("$.status")
                .value("CREATED"));
    }

    @Test
    void shouldRejectInvalidShipmentRequest() throws Exception {

        String invalidRequestBody = """
            {
              "sender": null,
              "receiver": null,
              "weight": -5,
              "weightUnit": "",
              "packageDescription": "Invalid shipment"
            }
            """;

        mockMvc.perform(
                post("/api/v1/shipments")
                    .contentType(APPLICATION_JSON)
                    .content(invalidRequestBody)
            )
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code")
                .value("SHIPMENT_VALIDATION_FAILED"))
            .andExpect(jsonPath("$.message")
                .value("Shipment request contains invalid fields"))
            .andExpect(jsonPath("$.timestamp")
                .exists())
            .andExpect(jsonPath("$.errors")
                .isArray())
            .andExpect(jsonPath("$.errors.length()")
                .value(4))
            .andDo(result ->
                System.out.println(
                    "\n===== INVALID REQUEST RESPONSE =====\n"
                        + result.getResponse().getContentAsString()
                        + "\n====================================\n"
                )
            );

        verifyNoInteractions(shipmentService);
    }

    @Test
    void shouldRejectBlankWeightUnit() throws Exception {

        String requestWithBlankWeightUnit = """
            {
              "sender": {
                "fullName": "Aman Awasthi",
                "phoneNumber": "+91XXXXXXXXXX",
                "email": "aman@example.com",
                "address": {
                  "addressLine1": "21 Example Road",
                  "addressLine2": "Sector 62",
                  "city": "Noida",
                  "state": "Uttar Pradesh",
                  "postalCode": "201301",
                  "country": "India"
                }
              },
              "receiver": {
                "fullName": "Max Mustermann",
                "phoneNumber": "+49XXXXXXXXXX",
                "email": "max@example.com",
                "address": {
                  "addressLine1": "Alexanderplatz 1",
                  "addressLine2": null,
                  "city": "Berlin",
                  "state": "Berlin",
                  "postalCode": "10178",
                  "country": "Germany"
                }
              },
              "weight": 5.25,
              "weightUnit": "",
              "packageDescription": "Electronics accessories"
            }
            """;

        mockMvc.perform(
                post("/api/v1/shipments")
                    .contentType(APPLICATION_JSON)
                    .content(requestWithBlankWeightUnit)
            )
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors.length()").value(1));

        verifyNoInteractions(shipmentService);
    }
}
