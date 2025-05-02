package com.digitalwallet.atm.service.mapper;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.model.ATM;
import org.springframework.stereotype.Component;

@Component
public class ATMMapper {


    public static ATM toATM(ATMRequestDTO atmRequestDTO) {
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

        return atm;

    }

    public static ATMResponseDTO toAtmResponseDTO(ATM atm) {
        ATMResponseDTO atmResponseDTO = new ATMResponseDTO();
        atmResponseDTO.setId(atm.getId());
        atmResponseDTO.setBankId(atm.getBankId());
        atmResponseDTO.setType(atm.getType());
        atmResponseDTO.setAccessible(atm.isAccessible());
        atmResponseDTO.setHasDepositCapability(atm.isHasDepositCapability());
        atmResponseDTO.setBalanceInquiryFee(atm.getBalanceInquiryFee());
        atmResponseDTO.setCashWithdrawalNationalFee(atm.getCashWithdrawalNationalFee());
        atmResponseDTO.setCashWithdrawalInternationalFee(atm.getCashWithdrawalInternationalFee());
        atmResponseDTO.setSupportedCurrencies(atm.getSupportedCurrencies());
        atmResponseDTO.setSupportedLanguages(atm.getSupportedLanguages());
        atmResponseDTO.setServices(atm.getServices());
        atmResponseDTO.setWeeklyHours(atm.getWeeklyHours());
        atmResponseDTO.setAddresses(atm.getAddresses());
        atmResponseDTO.setLocation(atm.getLocation());
        return atmResponseDTO;
    }

}
