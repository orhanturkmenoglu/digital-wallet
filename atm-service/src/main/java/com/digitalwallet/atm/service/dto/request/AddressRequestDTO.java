package com.digitalwallet.atm.service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

    @NotNull(message = "ATM ID cannot be null or empty")
    private String atmId;

    @NotNull(message = "Line 1 cannot be null or empty")
    @Size(min = 3, max = 100, message = "Line 1 must be between 3 and 100 characters")
    private String line1;

    @Size(max = 100, message = "Line 2 can be at most 100 characters")
    private String line2;

    @NotNull(message = "City cannot be null") // City null olamaz
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;

    @NotNull(message = "State cannot be null") // State null olamaz
    @Size(min = 2, max = 50, message = "State must be between 2 and 50 characters")
    private String state;

    @NotNull(message = "Country code cannot be null") // Country code null olamaz
    @Size(min = 2, max = 3, message = "Country code must be between 2 and 3 characters")
    private String countryCode;

    @NotNull(message = "Postcode cannot be null") // Postcode null olamaz
    @Pattern(regexp = "^[0-9]{5}$", message = "Postcode must be a 5-digit number")
    private String postcode;
}
