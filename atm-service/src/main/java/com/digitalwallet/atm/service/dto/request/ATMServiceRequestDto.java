package com.digitalwallet.atm.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATMServiceRequestDto {
    @JsonProperty("atm_id")
    private String atmId; // ATM ID’si (ilişkilendirme için)

    @JsonProperty("service_code")
    private String serviceCode; // Hizmet kodu
}
