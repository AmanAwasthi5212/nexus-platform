package com.nexus.shipment.service;

import com.nexus.shipment.dto.AddressDto;
import com.nexus.shipment.dto.ContactDto;
import com.nexus.shipment.dto.ShipmentCreateRequestDto;
import com.nexus.shipment.dto.ShipmentCreateResponseDto;
import com.nexus.shipment.entity.Shipment;
import com.nexus.shipment.repository.ShipmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShipmentServiceTest {

    @Mock
    private ShipmentRepository shipmentRepository;

    @InjectMocks
    private ShipmentService shipmentService;

    @Test
    void createShipment_shouldMapRequestAndReturnResponseFromSavedEntity() {
        ContactDto sender = new ContactDto(
            "John Doe", "9999999999", "john@example.com",
            new AddressDto("221B Baker Street", null, "London", "Greater London", "NW16XE", "UK")
        );
        ContactDto receiver = new ContactDto(
            "Jane Smith", "8888888888", "jane@example.com",
            new AddressDto("42 Wallaby Way", null, "Sydney", "NSW", "2000", "Australia")
        );
        ShipmentCreateRequestDto request = new ShipmentCreateRequestDto(
            sender, receiver, new BigDecimal("12.5"), "KG", "Electronics"
        );

        UUID fakeId = UUID.randomUUID();
        Instant fakeCreatedAt = Instant.now();
        Shipment fakeSavedShipment = mock(Shipment.class);
        when(fakeSavedShipment.getId()).thenReturn(fakeId);
        when(fakeSavedShipment.getStatus()).thenReturn("CREATED");
        when(fakeSavedShipment.getCreatedAt()).thenReturn(fakeCreatedAt);

        when(shipmentRepository.save(any(Shipment.class))).thenReturn(fakeSavedShipment);

        ShipmentCreateResponseDto response = shipmentService.createShipment(request);

        assertEquals(fakeId.toString(), response.shipmentId());
        assertEquals("CREATED", response.status());
        assertEquals(fakeCreatedAt, response.createdAt());

        ArgumentCaptor<Shipment> captor = ArgumentCaptor.forClass(Shipment.class);
        verify(shipmentRepository).save(captor.capture());
        Shipment savedArgument = captor.getValue();

        assertEquals("John Doe", savedArgument.getSenderName());
        assertEquals("Sydney", savedArgument.getReceiverCity());
        assertEquals(0, new BigDecimal("12.5").compareTo(savedArgument.getWeight()));
    }
}
