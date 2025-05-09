package com.digitalwallet.atm.service.mapper;

import com.digitalwallet.atm.service.dto.request.AddressRequestDTO;
import com.digitalwallet.atm.service.dto.response.AddressResponseDTO;
import com.digitalwallet.atm.service.model.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    public static Address mapToAddress(AddressRequestDTO dto) {
        return Address.builder()
                .line1(dto.getLine1())
                .line2(dto.getLine2())
                .city(dto.getCity())
                .state(dto.getState())
                .postCode(dto.getPostCode())
                .countryCode(dto.getCountryCode())
                .build();
    }

    public static AddressResponseDTO mapToResponse(Address address) {
        return AddressResponseDTO.builder()
                .id(address.getId())
                .line1(address.getLine1())
                .line2(address.getLine2())
                .city(address.getCity())
                .state(address.getState())
                .postCode(address.getPostCode())
                .countryCode(address.getCountryCode())
                .build();
    }

    public static List<Address> mapToAddressList(List<AddressRequestDTO> dtoList) {
        return dtoList.stream().map(AddressMapper::mapToAddress).collect(Collectors.toList());
    }

    public static List<AddressResponseDTO> mapToResponseList(List<Address> addresses) {
        return addresses.stream().map(AddressMapper::mapToResponse).collect(Collectors.toList());
    }
}
