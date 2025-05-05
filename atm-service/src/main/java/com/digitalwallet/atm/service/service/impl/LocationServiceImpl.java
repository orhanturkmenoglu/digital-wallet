package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.response.LocationResponseDTO;
import com.digitalwallet.atm.service.service.AddressService;
import com.digitalwallet.atm.service.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {
    @Override
    public Optional<LocationResponseDTO> findLocationById(String locationId) {
        return Optional.empty();
    }

    @Override
    public Optional<LocationResponseDTO> findLocationByLatitudeAndLongitude(double latitude, double longitude) {
        return Optional.empty();
    }
}
