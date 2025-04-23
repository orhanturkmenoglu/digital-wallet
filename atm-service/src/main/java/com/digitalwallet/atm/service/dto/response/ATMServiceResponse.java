package com.digitalwallet.atm.service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATMServiceResponse {
    @JsonProperty("service_id")
    private UUID id; // AtmService tablosundaki ID

    @JsonProperty("atm_id")
    private String atmId; // İlişkili ATM ID

    @JsonProperty("service_code")
    private String serviceCode;

    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @JsonProperty("last_update_date")
    private LocalDateTime lastUpdateDate;
}
