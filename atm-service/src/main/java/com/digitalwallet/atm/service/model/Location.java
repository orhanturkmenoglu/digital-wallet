package com.digitalwallet.atm.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;
import org.digitalwallet.common.utils.Prefix;

@Prefix("LOC")
@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location extends BaseEntity {
    private double latitude;
    private double longitude;
}
