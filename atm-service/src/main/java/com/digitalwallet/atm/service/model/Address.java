package com.digitalwallet.atm.service.model;

import com.digitalwallet.atm.service.utils.IdGenerator;
import com.digitalwallet.atm.service.utils.Prefix;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Prefix("address")
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    private String id;

    @OneToMany(mappedBy = "address")
    private List<ATM> atms;

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

    @Column(name = "post_code")
    private String postCode;


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


    @PreUpdate
    public void updateLastUpdateDate() {
        this.lastUpdateDate = LocalDateTime.now();
    }

}
