package com.digitalwallet.atm.service.model;


import com.digitalwallet.atm.service.enums.ATMType;

import jakarta.persistence.*;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;
import org.digitalwallet.common.utils.Prefix;

import java.util.List;

@Prefix("ATM")
@Entity
@Table(name = "atm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATM extends BaseEntity {

    private String bankId;

    @Enumerated(EnumType.STRING)
    private ATMType type;

    private boolean isAccessible;

    private boolean hasDepositCapability;

    private double balanceInquiryFee;

    private double cashWithdrawalNationalFee;

    private double cashWithdrawalInternationalFee;

    @ElementCollection
    @CollectionTable(name = "atm_supported_currencies", joinColumns = @JoinColumn(name = "atm_id"))
    @Column(name = "currency")
    private List<String> supportedCurrencies;

    @ElementCollection
    @CollectionTable(name = "atm_supported_languages", joinColumns = @JoinColumn(name = "atm_id"))
    @Column(name = "language")
    private List<String> supportedLanguages;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ToString.Exclude
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "atm_service_code",
            joinColumns = @JoinColumn(name = "atm_id"),
            inverseJoinColumns = @JoinColumn(name = "service_code_id")
    )
    @ToString.Exclude
    private List<ATMServiceCode> services;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

}
