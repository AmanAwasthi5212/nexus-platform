package com.nexus.shipment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "shipments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String senderEmail;

    @Column(nullable = false)
    private String receiverEmail;

    @Column(nullable = false)
    private String senderPhoneNumber;

    @Column(nullable = false)
    private String receiverPhoneNumber;

    @Column(nullable = false)
    private String senderAddressLine1;

    private String senderAddressLine2;

    @Column(nullable = false)
    private String senderCity;

    private String senderState;

    @Column(nullable = false)
    private String senderPostalCode;

    @Column(nullable = false)
    private String senderCountry;

    @Column(nullable = false)
    private String receiverAddressLine1;

    private String receiverAddressLine2;

    @Column(nullable = false)
    private String receiverCity;

    private String receiverState;

    @Column(nullable = false)
    private String receiverPostalCode;

    @Column(nullable = false)
    private String receiverCountry;

    @Column(nullable = false)
    private BigDecimal weight;

    @Column(nullable = false)
    private String weightUnit;

    private String packageDescription;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    public Shipment(
        String senderName, String receiverName,
        String senderEmail, String receiverEmail,
        String senderPhoneNumber, String receiverPhoneNumber,
        String senderAddressLine1, String senderAddressLine2,
        String senderCity, String senderState,
        String senderPostalCode, String senderCountry,
        String receiverAddressLine1, String receiverAddressLine2,
        String receiverCity, String receiverState,
        String receiverPostalCode, String receiverCountry,
        BigDecimal weight, String weightUnit,
        String packageDescription
    ) {
        this.status = "CREATED";
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.senderAddressLine1 = senderAddressLine1;
        this.senderAddressLine2 = senderAddressLine2;
        this.senderCity = senderCity;
        this.senderState = senderState;
        this.senderPostalCode = senderPostalCode;
        this.senderCountry = senderCountry;
        this.receiverAddressLine1 = receiverAddressLine1;
        this.receiverAddressLine2 = receiverAddressLine2;
        this.receiverCity = receiverCity;
        this.receiverState = receiverState;
        this.receiverPostalCode = receiverPostalCode;
        this.receiverCountry = receiverCountry;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.packageDescription = packageDescription;
        this.createdAt = Instant.now();
    }
}
