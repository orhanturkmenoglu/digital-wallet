package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.model.ATM;
import com.digitalwallet.atm.service.repository.ATMRepository;
import com.digitalwallet.atm.service.service.ATMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;

    @Override
    public ATMResponseDTO createATM(ATMRequestDTO atmRequestDTO) {

        ATM atm = new ATM();
        atm.setId(atmRequestDTO.getId());
        atm.setBankId(atmRequestDTO.getBankId());
        atm.setType(atmRequestDTO.getType());
        atm.setAccessible(atmRequestDTO.isAccessible());
        atm.setHasDepositCapability(atmRequestDTO.isHasDepositCapability());
        atm.setBalanceInquiryFee(atmRequestDTO.getBalanceInquiryFee());
        atm.setCashWithdrawalNationalFee(atmRequestDTO.getCashWithdrawalNationalFee());
        atm.setCashWithdrawalInternationalFee(atmRequestDTO.getCashWithdrawalInternationalFee());
        atm.setSupportedCurrencies(atmRequestDTO.getSupportedCurrencies());
        atm.setSupportedLanguages(atmRequestDTO.getSupportedLanguages());
        atm.setServices(atmRequestDTO.getServices());
        atm.setWeeklyHours(atmRequestDTO.getWeeklyHours());
        atm.setAddresses(atmRequestDTO.getAddresses());


        var savedATM = atmRepository.save(atm);
        log.info("Saving ATM: {}", atm);

        ATMResponseDTO atmResponseDTO = new ATMResponseDTO();
        atmResponseDTO.setId(savedATM.getId());
        atmResponseDTO.setBankId(savedATM.getBankId());
        atmResponseDTO.setType(savedATM.getType());
        atmResponseDTO.setAccessible(savedATM.isAccessible());
        atmResponseDTO.setHasDepositCapability(savedATM.isHasDepositCapability());
        atmResponseDTO.setBalanceInquiryFee(savedATM.getBalanceInquiryFee());
        atmResponseDTO.setCashWithdrawalNationalFee(savedATM.getCashWithdrawalNationalFee());
        atmResponseDTO.setCashWithdrawalInternationalFee(savedATM.getCashWithdrawalInternationalFee());
        atmResponseDTO.setSupportedCurrencies(savedATM.getSupportedCurrencies());
        atmResponseDTO.setSupportedLanguages(savedATM.getSupportedLanguages());
        atmResponseDTO.setServices(savedATM.getServices());
        atmResponseDTO.setWeeklyHours(savedATM.getWeeklyHours());
        atmResponseDTO.setAddresses(savedATM.getAddresses());

        log.info("Saved ATM: {}", atmResponseDTO);

        return atmResponseDTO;
    }

    @Override
    public ATMResponseDTO deleteATMID(String atmId) {
        return null;
    }

    @Override
    public ATMResponseDTO getATMbyID(String atmId) {
        return null;
    }

    @Override
    public ATMResponseDTO updateATM(String atmId) {
        return null;
    }

    @Override
    public List<ATMResponseDTO> getAllATMs() {
        return List.of();
    }
}
