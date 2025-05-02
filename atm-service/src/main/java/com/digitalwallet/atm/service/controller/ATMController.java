package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.service.ATMService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ATMResponseDTO> createATM(@RequestBody ATMRequestDTO atmRequestDTO) {
        ATMResponseDTO atm = atmService.createATM(atmRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(atm);
    }
}
