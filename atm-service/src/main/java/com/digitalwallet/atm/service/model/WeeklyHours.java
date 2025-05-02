package com.digitalwallet.atm.service.model;

import com.digitalwallet.atm.service.utils.IdGenerator;
import com.digitalwallet.atm.service.utils.Prefix;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Prefix("wh")
@Entity
@Table(name = "weekly_hours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeeklyHours {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "atm_id")  // ATM'yi bağlamak için bir dış anahtar
    private ATM atm;

    private String openingTime;
    private String closingTime;

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
