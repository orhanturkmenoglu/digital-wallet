package com.digitalwallet.atm.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne  // ATM ile ilişki
    @JoinColumn(name = "atm_id")  // ATM'yi bağlayan dış anahtar
    private ATM atm;

    @Column(name = "address_line_1")
    private String line1;

    @Column(name = "address_line_2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "postcode")
    private String postcode;


    private LocalDateTime createDate;

    private LocalDateTime lastUpdateDate;

    @PrePersist
    public void init() {
        this.createDate = LocalDateTime.now();  // Olusturma tarihini otomatik olarak ayarla
        this.lastUpdateDate = LocalDateTime.now();
    }

}
