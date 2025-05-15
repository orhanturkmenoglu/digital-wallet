package com.digitalwallet.atm.service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationResponseDTO implements Serializable {
    private String id;

    private double latitude;
    private double longitude;

    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @JsonProperty("last_update_date")
    private LocalDateTime lastUpdateDate;
}
