package com.digitalwallet.atm.service.dto.request;

import com.digitalwallet.atm.service.enums.ATMType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATMRequestDto {
    private String id;
    private String bankId;
    private ATMType type;
    private boolean isAccessible;


    private boolean hasDepositCapability;


    private double balanceInquiryFee;

    private double cashWithdrawalNationalFee;

    private double cashWithdrawalInternationalFee;

    private List<String> supportedCurrencies;

    private List<String> supportedLanguages;

    private List<String> services; // Hizmetler için daha ayrıntılı sınıflar oluşturulabilir.

    private List<String> weeklyHours;  // Haftalık saatler için benzer şekilde DTO oluşturulabilir.

    private List<String> addresses;  // Adresler için uygun DTO'lar oluşturulabilir.

    private String locationId;  // Konum için location_id ya da LocationDTO
}
