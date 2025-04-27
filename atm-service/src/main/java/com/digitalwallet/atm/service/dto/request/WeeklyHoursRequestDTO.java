package com.digitalwallet.atm.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representing weekly operating hours of the ATM.")
public class WeeklyHoursRequestDTO {

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$", message = "Opening time must be in HH:mm format")
    @Schema(description = "The opening time in HH:mm format (24-hour clock). Example: '09:00'", example = "09:00")
    private String openingTime;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$", message = "Closing time must be in HH:mm format")
    @Schema(description = "The closing time in HH:mm format (24-hour clock). Example: '18:00'", example = "18:00")
    private String closingTime;
}
