package com.digitalwallet.atm.service.dto.request;

import com.digitalwallet.atm.service.enums.ATMType;
import com.digitalwallet.atm.service.model.ATMServiceCode;
import com.digitalwallet.atm.service.model.Address;
import com.digitalwallet.atm.service.model.Location;
import com.digitalwallet.atm.service.model.WeeklyHours;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "DTO representing ATM request details for creating or updating an ATM.")
public class ATMRequestDTO {

    @NotNull(message = "ATM ID cannot be null")
    @Size(min = 3, max = 50, message = "ATM ID must be between 3 and 50 characters")
    @Schema(description = "Unique identifier for the ATM", example = "ATM12345")
    private String id;

    @NotNull(message = "Bank ID cannot be null")
    @Size(min = 3, max = 50, message = "Bank ID must be between 3 and 50 characters")
    @Schema(description = "Unique identifier for the bank owning the ATM", example = "BANK001")
    private String bankId;

    @NotNull(message = "ATM type cannot be null")
    @Schema(description = "Type of the ATM (e.g., Self-service, Full-service)", example = "SELF_SERVICE")
    private ATMType type;

    @Schema(description = "Indicates whether the ATM is accessible", example = "true")
    private boolean isAccessible;

    @Schema(description = "Indicates whether the ATM has deposit capability", example = "true")
    private boolean hasDepositCapability;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance inquiry fee must be greater than or equal to 0")
    @Schema(description = "Fee for balance inquiry", example = "1.50")
    private double balanceInquiryFee;

    @DecimalMin(value = "0.0", inclusive = true, message = "Cash withdrawal national fee must be greater than or equal to 0")
    @Schema(description = "National fee for cash withdrawal", example = "2.00")
    private double cashWithdrawalNationalFee;

    @DecimalMin(value = "0.0", inclusive = true, message = "Cash withdrawal international fee must be greater than or equal to 0")
    @Schema(description = "International fee for cash withdrawal", example = "5.00")
    private double cashWithdrawalInternationalFee;

    @NotNull(message = "Supported currencies cannot be null")
    @Size(min = 1, message = "At least one supported currency is required")
    @Schema(description = "List of supported currencies for this ATM", example = "[\"USD\", \"EUR\"]")
    private List<@NotNull(message = "Currency cannot be null") String> supportedCurrencies;

    @NotNull(message = "Supported languages cannot be null")
    @Size(min = 1, message = "At least one supported language is required")
    @Schema(description = "List of supported languages for this ATM", example = "[\"English\", \"Spanish\"]")
    private List<@NotNull(message = "Language cannot be null") String> supportedLanguages;

    @NotNull(message = "Services cannot be null")
    @Size(min = 1, message = "At least one service is required")
    @Schema(description = "List of ATM services offered (e.g., Cash Withdrawal, Balance Inquiry)", example = "[\"CASH_WITHDRAWAL\", \"BALANCE_INQUIRY\"]")
    private List<ATMServiceCode> services;

    @NotNull(message = "Weekly hours cannot be null")
    @Size(min = 1, message = "At least one weekly hour is required")
    @Schema(description = "Weekly operational hours for the ATM", example = "[\"Mon-Fri: 9 AM - 5 PM\"]")
    private List<WeeklyHours> weeklyHours;

    @NotNull(message = "Addresses cannot be null")
    @Size(min = 1, message = "At least one address is required")
    @Schema(description = "List of addresses where the ATM is located", example = "[{\"line1\": \"123 Main St\", \"city\": \"New York\", \"postcode\": \"10001\"}]")
    private List<Address> addresses;

    @NotNull(message = "Location ID cannot be null")
    @Size(min = 1, max = 50, message = "Location ID must be between 1 and 50 characters")
    @Schema(description = "Unique identifier for the ATM's location", example = "LOC12345")
    private Location location;
}
