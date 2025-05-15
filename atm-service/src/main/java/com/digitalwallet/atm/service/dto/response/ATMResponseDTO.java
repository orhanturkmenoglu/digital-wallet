package com.digitalwallet.atm.service.dto.response;

import com.digitalwallet.atm.service.enums.ATMType;
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
public class ATMResponseDTO implements Serializable {
    @JsonProperty("atm_id")
    private String id;

    @JsonProperty("bank_id")
    private String bankId;

    @JsonProperty("atm_type")
    private ATMType type;

    @JsonProperty("is_accessible")
    private boolean isAccessible;

    @JsonProperty("has_deposit_capability")
    private boolean hasDepositCapability;

    @JsonProperty("balance_inquiry_fee")
    private double balanceInquiryFee;

    @JsonProperty("cash_withdrawal_national_fee")
    private double cashWithdrawalNationalFee;

    @JsonProperty("cash_withdrawal_international_fee")
    private double cashWithdrawalInternationalFee;

    @JsonProperty("supported_currencies")
    private List<String> supportedCurrencies;

    @JsonProperty("supported_languages")
    private List<String> supportedLanguages;

    @JsonProperty("atm_code_services")
    private List<ATMServiceCodeResponseDTO> services; // Hizmetler için daha ayrıntılı sınıflar oluşturulabilir.*/

    @JsonProperty("addresses")
    private AddressResponseDTO addresses;  // Adresler için uygun DTO'lar oluşturulabilir.

    @JsonProperty("location")
    private LocationResponseDTO location;  // Konum detayları için LocationDTO dönebiliriz.

    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @JsonProperty("last_update_date")
    private LocalDateTime lastUpdateDate;
}
