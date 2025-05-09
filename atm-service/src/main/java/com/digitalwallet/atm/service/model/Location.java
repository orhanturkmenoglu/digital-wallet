package com.digitalwallet.atm.service.model;

import com.digitalwallet.atm.service.utils.Prefix;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.digitalwallet.common.entity.BaseEntity;

@Prefix("loc")
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
