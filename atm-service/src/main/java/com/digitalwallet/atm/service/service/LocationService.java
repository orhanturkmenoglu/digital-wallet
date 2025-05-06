package com.digitalwallet.atm.service.service;

import com.digitalwallet.atm.service.dto.response.LocationResponseDTO;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<LocationResponseDTO> findAllLocations();

    Optional<LocationResponseDTO> findLocationById(String locationId);

    Optional<LocationResponseDTO> findLocationByLatitudeAndLongitude(double latitude, double longitude);
}
