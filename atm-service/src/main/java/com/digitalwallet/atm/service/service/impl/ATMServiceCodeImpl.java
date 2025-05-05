package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.response.ATMServiceCodeResponseDTO;
import com.digitalwallet.atm.service.service.ATMServiceCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ATMServiceCodeImpl implements ATMServiceCode {
    @Override
    public Optional<ATMServiceCodeResponseDTO> findATMServiceCodeById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<ATMServiceCodeResponseDTO> findATMServiceCodeByServiceCode(String serviceCode) {
        return Optional.empty();
    }
}
