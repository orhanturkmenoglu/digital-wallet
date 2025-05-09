package com.digitalwallet.bank.service.model;


import com.digitalwallet.bank.service.enums.BankCode;
import jakarta.persistence.*;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;
import org.digitalwallet.common.utils.Prefix;

import java.util.List;

@Prefix("bank")
@Entity
@Table(name = "bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_code")
    private BankCode bankCode;

    @Column(name = "full_name")
    private String fullName;

    private String logo;

    @Column(name = "web_site")
    private String webSite;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressList;


}
