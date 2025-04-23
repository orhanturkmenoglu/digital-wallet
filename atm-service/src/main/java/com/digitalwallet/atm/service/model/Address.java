package com.digitalwallet.atm.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonProperty("address_id")
    private UUID id;

    @ManyToOne  // ATM ile ilişki
    @JoinColumn(name = "atm_id")  // ATM'yi bağlayan dış anahtar
    private Atm atm;

    @JsonProperty("line_1")
    @Column(name = "address_line_1")
    private String line1;

    @JsonProperty("line_2")
    @Column(name = "address_line_2")
    private String line2;

    @JsonProperty("city")
    @Column(name = "city")
    private String city;

    @JsonProperty("state")
    @Column(name = "state")
    private String state;

    @JsonProperty("country_code")
    @Column(name = "country_code")
    private String countryCode;

    @JsonProperty("postcode")
    @Column(name = "postcode")
    private String postcode;

}
