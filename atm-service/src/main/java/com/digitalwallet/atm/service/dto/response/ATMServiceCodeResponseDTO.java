package com.digitalwallet.atm.service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATMServiceCodeResponseDTO implements Serializable {
    @JsonProperty("service_id")
    private String id; // AtmService tablosundaki ID

    @JsonProperty("service_code")
    private String serviceCode;

    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @JsonProperty("last_update_date")
    private LocalDateTime lastUpdateDate;
}
