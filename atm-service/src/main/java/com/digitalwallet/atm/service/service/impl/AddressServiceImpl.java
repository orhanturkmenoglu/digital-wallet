package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.response.AddressResponseDTO;
import com.digitalwallet.atm.service.exception.AddressNotFoundException;
import com.digitalwallet.atm.service.exception.AddressInvalidParameterException;
import com.digitalwallet.atm.service.mapper.AddressMapper;
import com.digitalwallet.atm.service.model.Address;
import com.digitalwallet.atm.service.repository.AddressRepository;
import com.digitalwallet.atm.service.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;


    @Override
    public Optional<AddressResponseDTO> findAddressesById(String addressId) {

        if (addressId == null) {
            log.error("Address ID cannot be null");
            throw new AddressInvalidParameterException("Address ID cannot be null");
        }

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressInvalidParameterException("Address with ID " + addressId + " not found"));

        AddressResponseDTO addressResponseDTO = AddressMapper.mapToResponse(address);
        log.info("Retrieved Address: {}", addressResponseDTO);

        return Optional.of(addressResponseDTO);
    }

    @Override
    public List<AddressResponseDTO> getAllAddressesOrderByLine1() {

        List<Address> addressList = addressRepository
                .findAll()
                .stream()
                .sorted((address1, address2) -> address1.getLine1().compareToIgnoreCase(address2.getLine1())).toList();


        if (addressList.isEmpty()) {
            log.error("No addresses found in the system");
            throw new AddressNotFoundException("No addresses found in the system");
        }

        List<AddressResponseDTO> addressResponseDTOS = AddressMapper.mapToResponseList(addressList);
        log.info("Retrieved all addresses: {}", addressResponseDTOS);

        return addressResponseDTOS;
    }

    @Override
    public List<AddressResponseDTO> findAddressesByCity(String city) {
        if (city == null) {
            log.error("City cannot be null");
            throw new AddressInvalidParameterException("City cannot be null");
        }

        List<AddressResponseDTO> addressResponseDTOList = addressRepository.findAll()
                .stream()
                .map(AddressMapper::mapToResponse)
                .filter(address -> address.getCity().equalsIgnoreCase(city))
                .toList();

        log.info("Retrieved addresses by city: {}", addressResponseDTOList);
        return addressResponseDTOList;
    }

    @Override
    public List<AddressResponseDTO> findAddressesByPostCode(String postCode) {

        if (postCode == null) {
            log.error("Postcode cannot be null");
            throw new AddressInvalidParameterException("Postcode cannot be null");
        }

        List<Address> addressList = addressRepository.findByPostCode(postCode);

        if (addressList.isEmpty()) {
            log.error("No addresses found for postcode: {}", postCode);
            throw new AddressNotFoundException("No addresses found for postcode: " + postCode);
        }

        AddressMapper.mapToResponseList(addressList);
        log.info("Retrieved addresses by postcode: {}", postCode);

        return addressList.stream().map(AddressMapper::mapToResponse).toList();
    }

    @Override
    public List<AddressResponseDTO> findAddressesByCountryCode(String countryCode) {
        if (countryCode == null) {
            log.error("Country code cannot be null");
            throw new AddressInvalidParameterException("Country code cannot be null");
        }

        List<Address> addressList = addressRepository.findByCountryCode(countryCode);

        if (addressList.isEmpty()) {
            log.error("No addresses found for country code: {}", countryCode);
            throw new AddressNotFoundException("No addresses found for country code: " + countryCode);
        }

        List<AddressResponseDTO> addressResponseDTOList = AddressMapper.mapToResponseList(addressList);
        log.info("Retrieved addresses by country code: {}", countryCode);

        return addressResponseDTOList;
    }

    @Override
    public List<AddressResponseDTO> findAddressesByState(String state) {
        if (state == null) {
            log.error("State cannot be null");
            throw new AddressInvalidParameterException("State cannot be null");
        }

        List<Address> addressList = addressRepository.findByState(state);

        if (addressList.isEmpty()) {
            log.error("No addresses found for state: {}", state);
            throw new AddressNotFoundException("No addresses found for state: " + state);
        }

        List<AddressResponseDTO> addressResponseDTOList = AddressMapper.mapToResponseList(addressList);
        log.info("Retrieved addresses by state: {}", state);

        return addressResponseDTOList;
    }

    @Override
    public List<AddressResponseDTO> findAddressesByLine1(String line1) {
        if (line1 == null) {
            log.error("Line1 cannot be null");
            throw new AddressInvalidParameterException("Line1 cannot be null");
        }

        List<Address> addressList = addressRepository.findByLine1(line1);

        if (addressList.isEmpty()) {
            log.error("No addresses found for line1: {}", line1);
            throw new AddressNotFoundException("No addresses found for line1: " + line1);
        }

        List<AddressResponseDTO> addressResponseDTOList = AddressMapper.mapToResponseList(addressList);
        log.info("Retrieved addresses by line1: {}", line1);

        return addressResponseDTOList;
    }

    @Override
    public List<AddressResponseDTO> findAddressesByLine2(String line2) {
        if (line2 == null) {
            log.error("Line2 cannot be null");
            throw new AddressInvalidParameterException("Line2 cannot be null");
        }

        List<Address> addressList = addressRepository.findByLine2(line2);

        if (addressList.isEmpty()) {
            log.error("No addresses found for line2: {}", line2);
            throw new AddressNotFoundException("No addresses found for line2: " + line2);
        }

        List<AddressResponseDTO> addressResponseDTOList = AddressMapper.mapToResponseList(addressList);
        log.info("Retrieved addresses by line2: {}", line2);

        return addressResponseDTOList;
    }
}
