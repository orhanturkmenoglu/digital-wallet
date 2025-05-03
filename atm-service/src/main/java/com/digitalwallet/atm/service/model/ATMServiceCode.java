package com.digitalwallet.atm.service.model;

import com.digitalwallet.atm.service.utils.IdGenerator;
import com.digitalwallet.atm.service.utils.Prefix;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Prefix(value = "atm-code")
@Entity
@Table(name = "atm_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATMServiceCode {

    @Id
    private String id;
    private String serviceCode;

    @ManyToMany(mappedBy = "services", cascade = CascadeType.ALL)
    private List<ATM> atms;

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
