package com.digitalwallet.atm.service.dto.response;

import com.digitalwallet.atm.service.enums.ATMType;
import com.digitalwallet.atm.service.model.ATMServiceCode;
import com.digitalwallet.atm.service.model.Address;
import com.digitalwallet.atm.service.model.WeeklyHours;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATMResponseDTO {
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

    @JsonProperty("services")
    private List<ATMServiceCode> services; // Hizmetler için daha ayrıntılı sınıflar oluşturulabilir.

    @JsonProperty("weekly_hours")
    private List<WeeklyHours> weeklyHours;  // Haftalık saatler için benzer şekilde DTO oluşturulabilir.

    @JsonProperty("addresses")
    private List<Address> addresses;  // Adresler için uygun DTO'lar oluşturulabilir.

    @JsonProperty("location")
    private String location;  // Konum detayları için LocationDTO dönebiliriz.

    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @JsonProperty("last_update_date")
    private LocalDateTime lastUpdateDate;
}
