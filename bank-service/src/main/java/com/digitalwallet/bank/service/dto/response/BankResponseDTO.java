package com.digitalwallet.bank.service.dto.response;

import com.digitalwallet.bank.service.enums.BankCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankResponseDTO implements Serializable {

    private String id;

    @JsonProperty("bank_code")
    private BankCode bankCode;

    @JsonProperty("full_name")
    private String fullName;

    private String logo;

    @JsonProperty("web_site")
    private String webSite;

    private List<AddressResponseDTO> address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
