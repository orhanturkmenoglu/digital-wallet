package com.digitalwallet.atm.service.mapper;

import com.digitalwallet.atm.service.dto.request.LocationRequestDTO;
import com.digitalwallet.atm.service.dto.response.LocationResponseDTO;
import com.digitalwallet.atm.service.model.Location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationMapper {

    public static Location mapToLocation (LocationRequestDTO locationRequestDTO){
        return Location.builder()
                .latitude(locationRequestDTO.getLatitude())
                .longitude(locationRequestDTO.getLongitude())
                .build();
    }

    public static LocationResponseDTO mapToResponseDTO(Location location) {
        return LocationResponseDTO.builder()
                .id(location.getId())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .createDate(location.getCreateDate())
                .lastUpdateDate(location.getLastUpdateDate())
                .build();
    }

    public static List<LocationResponseDTO> mapToResponseDTOList(List<Location> locations) {
        return locations.stream()
                .map(LocationMapper::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public static List<Location> mapToLocationList(List<LocationRequestDTO> locationRequestDTOList) {
        return locationRequestDTOList.stream()
                .map(LocationMapper::mapToLocation)
                .collect(Collectors.toList());
    }

}
