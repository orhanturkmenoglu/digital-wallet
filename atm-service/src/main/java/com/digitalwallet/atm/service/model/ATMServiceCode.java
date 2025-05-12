package com.digitalwallet.atm.service.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;
import org.digitalwallet.common.utils.Prefix;

import java.util.List;

@Prefix("ATM-SERVICE-CODE")
@Entity
@Table(name = "atm_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATMServiceCode extends BaseEntity {

    private String serviceCode;

    @ManyToMany(mappedBy = "services", cascade = CascadeType.ALL)
    private List<ATM> atms;
}
