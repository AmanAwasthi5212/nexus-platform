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
}
