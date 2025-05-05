package com.digitalwallet.atm.service.service;

import com.digitalwallet.atm.service.dto.response.LocationResponseDTO;

import java.util.Optional;

public interface LocationService {

    Optional<LocationResponseDTO> findLocationById(String locationId);

    Optional<LocationResponseDTO> findLocationByLatitudeAndLongitude(double latitude, double longitude);
}
