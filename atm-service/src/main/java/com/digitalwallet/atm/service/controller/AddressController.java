package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.dto.response.AddressResponseDTO;
import com.digitalwallet.atm.service.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "Get address by ID", description = "Retrieve address details by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address found"),
            @ApiResponse(responseCode = "404", description = "Address not found")
    })
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressResponseDTO> getAddressById(@Parameter(description = "ID of the address")
                                                             @PathVariable String addressId) {
        Optional<AddressResponseDTO> addressResponseDTO = addressService.findAddressesById(addressId);

        return addressResponseDTO
                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Get all addresses ordered by Line1", description = "Retrieve all addresses sorted by Line1 field")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of addresses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No addresses found")
    })
    @GetMapping("/all")
    public ResponseEntity<List<AddressResponseDTO>> getAllAddressesOrderedByLine1() {
        List<AddressResponseDTO> addressList = addressService.getAllAddressesOrderByLine1();
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @Operation(summary = "Get addresses by city", description = "Retrieve all addresses located in the specified city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of addresses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No addresses found for the given city")
    })
    @GetMapping("/city/{city}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByCity(@Parameter(description = "City name to filter addresses") @PathVariable String city) {
        List<AddressResponseDTO> addressList = addressService.findAddressesByCity(city);
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @Operation(summary = "Get addresses by postcode", description = "Retrieve all addresses by the specified postcode")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of addresses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No addresses found for the given postcode")
    })
    @GetMapping("/postcode/{postCode}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByPostCode(@Parameter(description = "Postcode to filter addresses") @PathVariable String postCode) {
        List<AddressResponseDTO> addressList = addressService.findAddressesByPostCode(postCode);
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @Operation(summary = "Get addresses by country code", description = "Retrieve all addresses by the specified country code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of addresses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No addresses found for the given country code")
    })
    @GetMapping("/country-code/{countryCode}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByCountryCode(@Parameter(description = "Country code to filter addresses") @PathVariable String countryCode) {
        List<AddressResponseDTO> addressList = addressService.findAddressesByCountryCode(countryCode);
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @Operation(summary = "Get addresses by state", description = "Retrieve all addresses located in the specified state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of addresses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No addresses found for the given state")
    })
    @GetMapping("/state/{state}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByState(@Parameter(description = "State name to filter addresses") @PathVariable String state) {
        List<AddressResponseDTO> addressList = addressService.findAddressesByState(state);
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @Operation(summary = "Get addresses by Line1", description = "Retrieve all addresses with the specified Line1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of addresses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No addresses found for the given Line1")
    })
    @GetMapping("/line1/{line1}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByLine1(@Parameter(description = "Line1 address field to filter addresses") @PathVariable String line1) {
        List<AddressResponseDTO> addressList = addressService.findAddressesByLine1(line1);
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @Operation(summary = "Get addresses by Line2", description = "Retrieve all addresses with the specified Line2")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of addresses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No addresses found for the given Line2")
    })
    @GetMapping("/line2/{line2}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByLine2(@Parameter(description = "Line2 address field to filter addresses") @PathVariable String line2) {
        List<AddressResponseDTO> addressList = addressService.findAddressesByLine2(line2);
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }
}
