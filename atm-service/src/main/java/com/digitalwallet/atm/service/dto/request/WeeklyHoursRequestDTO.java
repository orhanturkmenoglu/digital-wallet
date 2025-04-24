package com.digitalwallet.atm.service.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyHoursRequestDTO {

    // HH: Saat kısmı (00-23 arasında)
    // mm: Dakika kısmı (00-59 arasında)
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$", message = "Opening time must be in HH:mm format")
    private String openingTime;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$", message = "Closing time must be in HH:mm format")
    private String closingTime;
}
