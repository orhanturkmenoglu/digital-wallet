package com.digitalwallet.atm.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyHoursRequestDto {
    private String openingTime;
    private String closingTime;
}
