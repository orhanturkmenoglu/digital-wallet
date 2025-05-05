package com.digitalwallet.atm.service.service;


import com.digitalwallet.atm.service.dto.response.AddressResponseDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Optional<AddressResponseDTO> findAddressesById(String addressId);

    List<AddressResponseDTO> getAllAddressesOrderByLine1();

    List<AddressResponseDTO> findAddressesByCity(String city);

    List<AddressResponseDTO> findAddressesByPostCode(String postCode);

    List<AddressResponseDTO> findAddressesByCountryCode(String countryCode);

    List<AddressResponseDTO> findAddressesByState(String state);

    List<AddressResponseDTO> findAddressesByLine1(String line1);

    List<AddressResponseDTO> findAddressesByLine2(String line2);
}
