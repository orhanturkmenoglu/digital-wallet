package com.digitalwallet.atm.service.dto.request;

import com.digitalwallet.atm.service.enums.ATMType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATMRequestDTO {

    @NotNull(message = "ATM ID cannot be null") // ATM ID null olamaz
    @Size(min = 3, max = 50, message = "ATM ID must be between 3 and 50 characters") // ATM ID uzunluğu 3-50 arasında olmalı
    private String id;

    @NotNull(message = "Bank ID cannot be null") // Bank ID null olamaz
    @Size(min = 3, max = 50, message = "Bank ID must be between 3 and 50 characters") // Bank ID uzunluğu 3-50 arasında olmalı
    private String bankId;

    @NotNull(message = "ATM type cannot be null") // ATM Type null olamaz
    private ATMType type; // Enum doğrulama otomatik olarak yapılır.

    private boolean isAccessible;

    private boolean hasDepositCapability;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance inquiry fee must be greater than or equal to 0") // Balance inquiry fee negatif olamaz
    private double balanceInquiryFee;

    @DecimalMin(value = "0.0", inclusive = true, message = "Cash withdrawal national fee must be greater than or equal to 0") // Cash withdrawal national fee negatif olamaz
    private double cashWithdrawalNationalFee;

    @DecimalMin(value = "0.0", inclusive = true, message = "Cash withdrawal international fee must be greater than or equal to 0") // Cash withdrawal international fee negatif olamaz
    private double cashWithdrawalInternationalFee;

    @NotNull(message = "Supported currencies cannot be null") // Supported currencies null olamaz
    @Size(min = 1, message = "At least one supported currency is required") // En az bir döviz olmalı
    private List<@NotNull(message = "Currency cannot be null") String> supportedCurrencies; // Currency null olamaz

    @NotNull(message = "Supported languages cannot be null") // Supported languages null olamaz
    @Size(min = 1, message = "At least one supported language is required") // En az bir dil olmalı
    private List<@NotNull(message = "Language cannot be null") String> supportedLanguages; // Language null olamaz

    @NotNull(message = "Services cannot be null") // Services null olamaz
    @Size(min = 1, message = "At least one service is required") // En az bir hizmet olmalı
    private List<String> services; // Hizmetler için daha ayrıntılı sınıflar oluşturulabilir.

    @NotNull(message = "Weekly hours cannot be null") // Weekly hours null olamaz
    @Size(min = 1, message = "At least one weekly hour is required") // En az bir hafta saati olmalı
    private List<String> weeklyHours; // Haftalık saatler için DTO oluşturulabilir.

    @NotNull(message = "Addresses cannot be null") // Addresses null olamaz
    @Size(min = 1, message = "At least one address is required") // En az bir adres olmalı
    private List<String> addresses; // Adresler için DTO'lar oluşturulabilir.

    @NotNull(message = "Location ID cannot be null") // Location ID null olamaz
    @Size(min = 1, max = 50, message = "Location ID must be between 1 and 50 characters") // Location ID uzunluğu 1-50 arasında olmalı
    private String locationId; // Konum için location_id ya da LocationDTO
}
