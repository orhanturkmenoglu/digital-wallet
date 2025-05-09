package com.digitalwallet.bank.service.model;

import jakarta.persistence.*;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;
import org.digitalwallet.common.utils.Prefix;

@Prefix("bank-address")
@Entity
@Table(name = "bank_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends BaseEntity {

    private String city;
    private String country;
    private String state;
    private String street;
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;

}
