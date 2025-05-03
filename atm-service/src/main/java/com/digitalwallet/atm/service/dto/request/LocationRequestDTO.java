package com.digitalwallet.atm.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representing the geographic location with latitude and longitude.")
public class LocationRequestDTO {

    @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @Schema(description = "Latitude of the location. Valid range is from -90.0 to 90.0.", example = "40.7128")
    private double latitude;

    @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    @Schema(description = "Longitude of the location. Valid range is from -180.0 to 180.0.", example = "-74.0060")
    private double longitude;
}
