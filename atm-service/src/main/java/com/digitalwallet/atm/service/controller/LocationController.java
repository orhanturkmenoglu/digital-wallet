package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.dto.response.LocationResponseDTO;
import com.digitalwallet.atm.service.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @Operation(summary = "Get all locations", description = "Retrieve all locations from the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of locations retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No locations found in the system")
    })
    @GetMapping("/all")
    public ResponseEntity<List<LocationResponseDTO>> getAllLocations() {
        List<LocationResponseDTO> locationList = locationService.findAllLocations();
        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @Operation(summary = "Get location by ID", description = "Retrieve a specific location by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location found"),
            @ApiResponse(responseCode = "404", description = "Location not found with the given ID"),
            @ApiResponse(responseCode = "400", description = "Invalid location ID")
    })
    @GetMapping("/{locationId}")
    public ResponseEntity<LocationResponseDTO> getLocationById(@Parameter(description = "ID of the location")
                                                               @PathVariable String locationId) {
        Optional<LocationResponseDTO> locationResponseDTO = locationService.findLocationById(locationId);

        return locationResponseDTO
                .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Get location by coordinates", description = "Retrieve a location using latitude and longitude")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location found at the provided coordinates"),
            @ApiResponse(responseCode = "404", description = "Location not found at the provided coordinates"),
            @ApiResponse(responseCode = "400", description = "Invalid latitude or longitude")
    })
    @GetMapping("/coordinates")
    public ResponseEntity<LocationResponseDTO> getLocationByCoordinates(
            @Parameter(description = "Latitude of the location") @RequestParam double latitude,
            @Parameter(description = "Longitude of the location") @RequestParam double longitude) {

        Optional<LocationResponseDTO> locationResponseDTO = locationService.findLocationByLatitudeAndLongitude(latitude, longitude);

        return locationResponseDTO
                .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
