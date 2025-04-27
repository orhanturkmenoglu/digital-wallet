package com.digitalwallet.atm.service.model;


import com.digitalwallet.atm.service.enums.ATMType;
import com.digitalwallet.atm.service.utils.IdGenerator;
import com.digitalwallet.atm.service.utils.Prefix;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Prefix("atm")
@Entity
@Table(name = "atm")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATM {

    @Id
    private String id;

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

    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL)
    private List<ATMServiceCode> services;

    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL)
    private List<WeeklyHours> weeklyHours;  // Haftalık saatler

    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL)  // Bir ATM'nin birden fazla adresi olabilir
    private List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;  // ATM'nin coğrafi konumu

    private LocalDateTime createDate;

    private LocalDateTime lastUpdateDate;


    @PrePersist
    public void init() {
        if (this.id == null) {
            this.id = IdGenerator.generateId(this);
        }
        this.createDate = LocalDateTime.now();  // Olusturma tarihini otomatik olarak ayarla
        this.lastUpdateDate = LocalDateTime.now();
    }

}
