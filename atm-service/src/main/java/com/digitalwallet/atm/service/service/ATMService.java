package com.digitalwallet.atm.service.service;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;

import java.util.List;

public interface ATMService {
    ATMResponseDTO createATM(ATMRequestDTO atmRequestDTO);

    ATMResponseDTO deleteATMID(String atmId);

    ATMResponseDTO getATMbyID(String atmId);

    ATMResponseDTO updateATM(String atmId);

    List<ATMResponseDTO> getAllATMs();
}
