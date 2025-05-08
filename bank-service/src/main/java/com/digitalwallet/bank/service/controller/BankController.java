package com.digitalwallet.bank.service.controller;

import com.digitalwallet.bank.service.dto.request.BankRequestDTO;
import com.digitalwallet.bank.service.dto.response.BankResponseDTO;
import com.digitalwallet.bank.service.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @PostMapping
    public ResponseEntity<BankResponseDTO> createBank(@RequestBody BankRequestDTO bankRequestDTO) {
        BankResponseDTO response = bankService.createBank(bankRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BankResponseDTO>> getAllBanks() {
        List<BankResponseDTO> responseList = bankService.getAllBanks();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankResponseDTO> getBankById(@PathVariable String id) {
        BankResponseDTO response = bankService.getBankById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankResponseDTO> updateBank(
            @PathVariable String id,
            @RequestBody BankRequestDTO bankRequestDTO) {
        BankResponseDTO response = bankService.updateBank(id, bankRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankById(@PathVariable String id) {
        bankService.deleteBankById(id);
        return ResponseEntity.noContent().build();
    }
}
