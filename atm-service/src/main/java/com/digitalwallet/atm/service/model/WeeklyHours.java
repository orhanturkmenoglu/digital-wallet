package com.digitalwallet.atm.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "weekly_hours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeeklyHours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "atm_id")  // ATM'yi bağlamak için bir dış anahtar
    private Atm atm;

    private String openingTime;
    private String closingTime;
}
