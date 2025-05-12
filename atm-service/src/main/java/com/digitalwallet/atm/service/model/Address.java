package com.digitalwallet.atm.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;
import org.digitalwallet.common.utils.Prefix;

import java.util.List;

@Prefix("ADDR")
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends BaseEntity {

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

}
