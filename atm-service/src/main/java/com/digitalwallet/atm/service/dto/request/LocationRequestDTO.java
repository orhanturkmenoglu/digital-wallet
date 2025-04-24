package com.digitalwallet.atm.service.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequestDTO {

    @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be between -90 and 90") // Latitude: -90.0 ile 90.0 arasında olmalıdır.
    @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    private double latitude;

    @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be between -180 and 180")// Longitude: -180.0 ile 180.0 arasında olmalıdır.
    @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    private double longitude;
}
