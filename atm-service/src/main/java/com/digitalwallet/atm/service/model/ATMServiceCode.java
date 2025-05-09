package com.digitalwallet.atm.service.model;

import com.digitalwallet.atm.service.utils.Prefix;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;

import java.util.List;

@Prefix(value = "atm-code")
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
