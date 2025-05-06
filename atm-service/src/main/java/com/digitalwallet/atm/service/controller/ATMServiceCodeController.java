package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.dto.response.ATMServiceCodeResponseDTO;
import com.digitalwallet.atm.service.service.ATMServiceCode;
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
@RequestMapping("/api/v1/atm-service-codes")
@RequiredArgsConstructor
public class ATMServiceCodeController {

    private final ATMServiceCode atmServiceCodeService;

    @Operation(summary = "Get all ATM service codes", description = "Retrieve all ATM service codes sorted alphabetically by service code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of ATM service codes retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No ATM service codes found")
    })
    @GetMapping("/all")
    public ResponseEntity<List<ATMServiceCodeResponseDTO>> getAllATMServiceCodes() {
        List<ATMServiceCodeResponseDTO> serviceCodes = atmServiceCodeService.getAllATMServiceCodes();

        if (serviceCodes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(serviceCodes, HttpStatus.OK);
    }

    @Operation(summary = "Get ATM service code by ID", description = "Retrieve a specific ATM service code by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ATM service code found"),
            @ApiResponse(responseCode = "404", description = "ATM service code not found for the given ID"),
            @ApiResponse(responseCode = "400", description = "Invalid ATM service code ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ATMServiceCodeResponseDTO> getATMServiceCodeById(@Parameter(description = "ID of the ATM service code")
                                                                           @PathVariable String id) {
        Optional<ATMServiceCodeResponseDTO> atmServiceCode = atmServiceCodeService.findATMServiceCodeById(id);

        return atmServiceCode
                .map(serviceCode -> new ResponseEntity<>(serviceCode, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Get ATM service code by service code", description = "Retrieve a specific ATM service code by its service code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ATM service code found for the given service code"),
            @ApiResponse(responseCode = "404", description = "ATM service code not found for the given service code"),
            @ApiResponse(responseCode = "400", description = "Invalid service code")
    })
    @GetMapping("/service-code/{serviceCode}")
    public ResponseEntity<ATMServiceCodeResponseDTO> getATMServiceCodeByServiceCode(
            @Parameter(description = "Service code of the ATM") @PathVariable String serviceCode) {

        Optional<ATMServiceCodeResponseDTO> atmServiceCode = atmServiceCodeService.findByServiceCode(serviceCode);

        return atmServiceCode
                .map(serviceCodeResponse -> new ResponseEntity<>(serviceCodeResponse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
