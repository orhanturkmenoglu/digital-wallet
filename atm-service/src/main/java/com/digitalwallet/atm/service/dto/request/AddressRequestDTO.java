package com.digitalwallet.atm.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO representing the address details of an ATM.")
public class AddressRequestDTO {

    @NotNull(message = "Line 1 cannot be null or empty")
    @Schema(description = "First line of the address", example = "123 Main St", required = true)
    @Size(min = 3, max = 250, message = "Line 1 must be between 3 and 100 characters")
    private String line1;

    @Size(max = 250, message = "Line 2 can be at most 100 characters")
    @Schema(description = "Second line of the address", example = "Suite 101")
    private String line2;

    @NotNull(message = "City cannot be null") // City null olamaz
    @Schema(description = "City of the address", example = "New York", required = true)
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;

    @NotNull(message = "State cannot be null") // State null olamaz
    @Size(min = 2, max = 50, message = "State must be between 2 and 50 characters")
    @Schema(description = "State of the address", example = "New York", required = true)
    private String state;

    @NotNull(message = "Country code cannot be null") // Country code null olamaz
    @Size(min = 2, max = 10, message = "Country code must be between 2 and 3 characters")
    @Schema(description = "Country code for the address", example = "US", required = true)
    private String countryCode;

    @NotNull(message = "Postcode cannot be null") // Postcode null olamaz
    @Pattern(regexp = "^[0-9]{5}$", message = "Postcode must be a 5-digit number")
    @Schema(description = "Postcode for the address", example = "10001", required = true)
    private String postCode;
}
