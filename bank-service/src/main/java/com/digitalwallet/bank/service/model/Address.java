package com.digitalwallet.bank.service.model;

import jakarta.persistence.*;
import lombok.*;
import org.digitalwallet.common.utils.IdGenerator;
import org.digitalwallet.common.utils.Prefix;

import java.time.LocalDateTime;

@Prefix("bank-address")
@Entity
@Table(name = "bank_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    private String id;

    private String city;
    private String country;
    private String state;
    private String street;
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersist() {
        if (id == null) {
            this.id = IdGenerator.generateId(this);
        }

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
