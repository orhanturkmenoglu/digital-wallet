package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.exception.ApiSuccessResponse;
import com.digitalwallet.atm.service.service.ATMService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atm")
@RequiredArgsConstructor
public class ATMController {

    private final ATMService atmService;

    @Operation(
            summary = "Create a new ATM",
            description = "Creates a new ATM entry with the provided details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ATM successfully created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ATMResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<ATMResponseDTO> createATM(@Valid @RequestBody ATMRequestDTO atmRequestDTO) {
        ATMResponseDTO atm = atmService.createATM(atmRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(atm);
    }


    @Operation(
            summary = "Get all ATMs",
            description = "Retrieves a list of all ATMs."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ATMs successfully retrieved",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ATMResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<ATMResponseDTO>> getAllATMs() {
        List<ATMResponseDTO> atms = atmService.getAllATMs();
        return ResponseEntity.ok(atms);
    }

    @Operation(
            summary = "Get ATMs by city",
            description = "Retrieves a list of ATMs by city."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ATMs successfully retrieved",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ATMResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @GetMapping("/by-city")
    public ResponseEntity<List<ATMResponseDTO>> getATMsByCity(@RequestParam("city") String city) {
        List<ATMResponseDTO> atms = atmService.findATMsByCity(city);
        return ResponseEntity.ok(atms);
    }


    @Operation(
            summary = "Delete an ATM",
            description = "Deletes an ATM using the provided Bank ID and ATM ID. This will also delete all its attributes."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ATM successfully deleted",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiSuccessResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ATM or Bank ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "ATM not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @DeleteMapping("/banks/{bankId}/atms/{atmId}")
    public ResponseEntity<ApiSuccessResponse<Void>> deleteByBankIdAndAtmId(@PathVariable
                                                                           String bankId,
                                                                           @PathVariable String atmId) {
        ApiSuccessResponse<Void> response = atmService.deleteByBankIdAndAtmId(bankId, atmId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
