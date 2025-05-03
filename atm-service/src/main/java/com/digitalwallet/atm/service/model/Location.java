package com.digitalwallet.atm.service.model;

import com.digitalwallet.atm.service.utils.IdGenerator;
import com.digitalwallet.atm.service.utils.Prefix;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Prefix("loc")
@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Id
    private String id;

    private double latitude;
    private double longitude;

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
