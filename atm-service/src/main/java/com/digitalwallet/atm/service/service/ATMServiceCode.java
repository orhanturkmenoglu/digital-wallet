package com.digitalwallet.atm.service.service;

import com.digitalwallet.atm.service.dto.response.ATMServiceCodeResponseDTO;

import java.util.Optional;

public interface ATMServiceCode {

    Optional<ATMServiceCodeResponseDTO> findATMServiceCodeById(String id);
    Optional<ATMServiceCodeResponseDTO> findATMServiceCodeByServiceCode(String serviceCode);
}
