package com.digitalwallet.atm.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representing the service code request for a specific ATM.")
public class ATMServiceCodeRequestDto {

    @NotNull(message = "Service code cannot be null or empty")
    @Size(min = 3, max = 10, message = "Service code must be between 3 and 10 characters")
    @Schema(description = "The service code for the ATM (e.g., \"CASH_WITHDRAWAL\")", example = "CASH_WITHDRAWAL")
    private String serviceCode;
}
