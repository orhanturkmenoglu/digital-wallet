package com.digitalwallet.atm.service.service;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.request.ATMUpdateRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;

import java.util.List;

public interface ATMService {
    ATMResponseDTO createATM(ATMRequestDTO atmRequestDTO);

    void deleteByBankIdAndAtmId(String bankId, String atmId);

    ATMResponseDTO getATMbyID(String atmId);

    ATMResponseDTO updateATM(String atmId, ATMUpdateRequestDTO atmUpdateRequestDTO);

    List<ATMResponseDTO> getAllATMs();

    List<ATMResponseDTO> findATMsByCity(String city);
}
