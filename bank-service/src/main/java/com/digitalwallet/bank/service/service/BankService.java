package com.digitalwallet.bank.service.service;

import com.digitalwallet.bank.service.dto.request.BankRequestDTO;
import com.digitalwallet.bank.service.dto.response.BankResponseDTO;

import java.util.List;

public interface BankService {

    BankResponseDTO createBank(BankRequestDTO bankRequestDTO);

    List<BankResponseDTO> getAllBanks();

    BankResponseDTO getBankById(String id);

    BankResponseDTO updateBank(String id, BankRequestDTO bankRequestDTO);

    void deleteBankById(String id);
}
