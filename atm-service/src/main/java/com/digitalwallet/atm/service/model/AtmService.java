package com.digitalwallet.atm.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "atm_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtmService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "atm_id",referencedColumnName = "atm_id")
    private Atm atm;

    @JsonProperty("service_code")
    private String serviceCode;
}
