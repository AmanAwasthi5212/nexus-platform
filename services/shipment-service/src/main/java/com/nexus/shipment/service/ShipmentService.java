package com.nexus.shipment.service;

import com.nexus.shipment.dto.*;
import com.nexus.shipment.entity.Shipment;
import com.nexus.shipment.exception.ShipmentNotFoundException;
import com.nexus.shipment.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Transactional
    public ShipmentCreateResponseDto createShipment(ShipmentCreateRequestDto request) {
        ContactDto sender = request.sender();
        ContactDto receiver = request.receiver();

        Shipment shipment = new Shipment(
            sender.fullName(), receiver.fullName(),
            sender.email(), receiver.email(),
            sender.phoneNumber(), receiver.phoneNumber(),
            sender.address().addressLine1(), sender.address().addressLine2(),
            sender.address().city(), sender.address().state(),
            sender.address().postalCode(), sender.address().country(),
            receiver.address().addressLine1(), receiver.address().addressLine2(),
            receiver.address().city(), receiver.address().state(),
            receiver.address().postalCode(), receiver.address().country(),
            request.weight(), request.weightUnit(),
            request.packageDescription()
        );

        Shipment saved = shipmentRepository.save(shipment);

        return new ShipmentCreateResponseDto(
            saved.getId().toString(),
            saved.getStatus(),
            saved.getCreatedAt()
        );
    }

    @Transactional(readOnly = true)
    public ShipmentResponseDto getShipmentById(UUID id) {
        Shipment shipment = shipmentRepository.findById(id)
            .orElseThrow(() -> new ShipmentNotFoundException(id));

        return toResponseDto(shipment);
    }

    private ShipmentResponseDto toResponseDto(Shipment shipment) {
        ContactDto sender = new ContactDto(
            shipment.getSenderName(),
            shipment.getSenderPhoneNumber(),
            shipment.getSenderEmail(),
            new AddressDto(
                shipment.getSenderAddressLine1(),
                shipment.getSenderAddressLine2(),
                shipment.getSenderCity(),
                shipment.getSenderState(),
                shipment.getSenderPostalCode(),
                shipment.getSenderCountry()
            )
        );

        ContactDto receiver = new ContactDto(
            shipment.getReceiverName(),
            shipment.getReceiverPhoneNumber(),
            shipment.getReceiverEmail(),
            new AddressDto(
                shipment.getReceiverAddressLine1(),
                shipment.getReceiverAddressLine2(),
                shipment.getReceiverCity(),
                shipment.getReceiverState(),
                shipment.getReceiverPostalCode(),
                shipment.getReceiverCountry()
            )
        );

        return new ShipmentResponseDto(
            shipment.getId().toString(),
            shipment.getStatus(),
            sender,
            receiver,
            shipment.getWeight(),
            shipment.getWeightUnit(),
            shipment.getPackageDescription(),
            shipment.getCreatedAt()
        );
    }

}
