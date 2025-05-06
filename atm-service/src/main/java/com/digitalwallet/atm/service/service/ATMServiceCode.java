package com.digitalwallet.atm.service.service;

import com.digitalwallet.atm.service.dto.response.ATMServiceCodeResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ATMServiceCode {

    List<ATMServiceCodeResponseDTO> getAllATMServiceCodes();
    Optional<ATMServiceCodeResponseDTO> findATMServiceCodeById(String id);
    Optional<ATMServiceCodeResponseDTO> findByServiceCode(String serviceCode);
}
