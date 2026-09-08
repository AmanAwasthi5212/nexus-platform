package com.nexus.shipment.service;

import com.nexus.shipment.dto.ContactDto;
import com.nexus.shipment.dto.ShipmentCreateRequestDto;
import com.nexus.shipment.dto.ShipmentCreateResponseDto;
import com.nexus.shipment.entity.Shipment;
import com.nexus.shipment.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
