package com.digitalwallet.bank.service.model;


import com.digitalwallet.bank.service.enums.BankCode;
import jakarta.persistence.*;
import lombok.*;
import org.digitalwallet.common.utils.IdGenerator;
import org.digitalwallet.common.utils.Prefix;

import java.time.LocalDateTime;
import java.util.List;

@Prefix("bank")
@Entity
@Table(name = "bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_code")
    private BankCode bankCode;

    @Column(name = "full_name")
    private String fullName;

    private String logo;

    @Column(name = "web_site")
    private String webSite;

    @OneToMany(mappedBy = "bank" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressList;

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
