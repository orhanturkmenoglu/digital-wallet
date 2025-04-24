package com.digitalwallet.atm.service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATMServiceCodeRequestDto {

    @NotNull(message = "ATM ID cannot be null or empty")
    private String atmId; // ATM ID’si (ilişkilendirme için)

    @NotNull(message = "Service code cannot be null or empty")
    @Size(min = 3, max = 10, message = "Service code must be between 3 and 10 characters")
    private String serviceCode; // Hizmet kodu
}
