package com.digitalwallet.atm.service.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "atm")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Atm {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("atm_id")
    private String id;

    @JsonProperty("bank_id")
    private String bankId;


    @Enumerated(EnumType.STRING)
    @JsonProperty("atm_type")
    private AtmType type;

    @JsonProperty("is_accessible")
    private boolean isAccessible;

    @JsonProperty("has_deposit_capability")
    private boolean hasDepositCapability;

    @JsonProperty("balance_inquiry_fee")
    private double balanceInquiryFee;

    @JsonProperty("cash_withdrawal_national_fee")
    private double cashWithdrawalNationalFee;

    @JsonProperty("cash_withdrawal_international_fee")
    private double cashWithdrawalInternationalFee;

    @JsonProperty("supported_currencies")
    @ElementCollection
    @CollectionTable(name = "atm_supported_currencies", joinColumns = @JoinColumn(name = "atm_id"))
    @Column(name = "currency")
    private List<String> supportedCurrencies;


    @JsonProperty("supported_languages")
    @ElementCollection
    @CollectionTable(name = "atm_supported_languages", joinColumns = @JoinColumn(name = "atm_id"))
    @Column(name = "language")
    private List<String> supportedLanguages;

    @JsonProperty("services")
    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL)
    private List<AtmService> services;

    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL)
    private List<WeeklyHours> weeklyHours;  // Haftalık saatler

    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL)  // Bir ATM'nin birden fazla adresi olabilir
    private List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;  // ATM'nin coğrafi konumu


}
