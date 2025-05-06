package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.response.LocationResponseDTO;
import com.digitalwallet.atm.service.exception.LocationInvalidParameterException;
import com.digitalwallet.atm.service.exception.LocationNotFoundException;
import com.digitalwallet.atm.service.mapper.LocationMapper;
import com.digitalwallet.atm.service.model.Location;
import com.digitalwallet.atm.service.repository.LocationRepository;
import com.digitalwallet.atm.service.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public List<LocationResponseDTO> findAllLocations() {
        List<Location> locations = locationRepository.findAll();

        if (locations.isEmpty()) {
            log.error("No locations found in the system");
            throw new LocationNotFoundException("No locations found in the system");
        }

        List<LocationResponseDTO> responseDTOs = LocationMapper.mapToResponseDTOList(locations);
        log.info("Found {} locations", responseDTOs.size());
        return responseDTOs;
    }

    @Override
    public Optional<LocationResponseDTO> findLocationById(String locationId) {
        if (locationId == null) {
            log.error("Location ID cannot be null");
            throw new LocationInvalidParameterException("Location ID cannot be null");
        }

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException("Location with ID " + locationId + " not found"));

        LocationResponseDTO responseDTO = LocationMapper.mapToResponseDTO(location);
        log.info("Location found with ID {}: {}", locationId, responseDTO);

        return Optional.of(responseDTO);
    }

    @Override
    public Optional<LocationResponseDTO> findLocationByLatitudeAndLongitude(double latitude, double longitude) {
        Optional<Location> location = locationRepository.findByLatitudeAndLongitude(latitude, longitude);

        if (location.isEmpty()) {
            log.error("Location not found at coordinates: {}, {}", latitude, longitude);
            throw new LocationNotFoundException("Location not found at provided coordinates.");
        }

        LocationResponseDTO responseDTO = LocationMapper.mapToResponseDTO(location.get());
        log.info("Location found at coordinates: {}, {}: {}", latitude, longitude, responseDTO);
        return Optional.of(responseDTO);
    }
}
