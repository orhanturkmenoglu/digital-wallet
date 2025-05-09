package com.digitalwallet.bank.service.mapper;

import com.digitalwallet.bank.service.dto.request.AddressRequestDTO;
import com.digitalwallet.bank.service.dto.response.AddressResponseDTO;
import com.digitalwallet.bank.service.model.Address;

import java.util.List;

public class AddressMapper {

    public static Address mapToAddress(AddressRequestDTO addressRequestDTO) {
        return Address.builder()
                .city(addressRequestDTO.getCity())
                .state(addressRequestDTO.getState())
                .street(addressRequestDTO.getStreet())
                .country(addressRequestDTO.getCountry())
                .zipCode(addressRequestDTO.getZipCode())
                .build();
    }

    public static AddressResponseDTO mapAddressResponseDTO(Address address) {
        return AddressResponseDTO.builder()
                .id(address.getId())
                .bankId(address.getBank().getId())
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt())
                .build();
    }

    public static List<Address> mapToAddressList(List<AddressRequestDTO> addressList) {
        return addressList.stream().map(AddressMapper::mapToAddress).toList();
    }

    public static List<AddressResponseDTO> mapToAddressResponseDTOList(List<Address> addressList) {
        return addressList.stream().map(AddressMapper::mapAddressResponseDTO).toList();
    }
}