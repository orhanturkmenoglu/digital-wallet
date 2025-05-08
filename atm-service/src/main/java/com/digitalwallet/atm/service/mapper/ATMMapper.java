package com.digitalwallet.atm.service.mapper;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.model.ATM;

import java.util.List;

public class ATMMapper {

    public static ATM mapToATM(ATMRequestDTO dto) {
        return ATM.builder()
                .bankId(dto.getBankId())
                .type(dto.getType())
                .isAccessible(dto.isAccessible())
                .hasDepositCapability(dto.isHasDepositCapability())
                .balanceInquiryFee(dto.getBalanceInquiryFee())
                .cashWithdrawalNationalFee(dto.getCashWithdrawalNationalFee())
                .cashWithdrawalInternationalFee(dto.getCashWithdrawalInternationalFee())
                .supportedCurrencies(dto.getSupportedCurrencies())
                .supportedLanguages(dto.getSupportedLanguages())
                .address(AddressMapper.mapToAddress(dto.getAddresses()))
                .services(ATMServiceCodeMapper.mapToATMServiceList(dto.getServices()))
                .location(LocationMapper.mapToLocation(dto.getLocation()))
                .build();
    }


    public static ATMResponseDTO mapToResponseDTO(ATM atm) {
        return ATMResponseDTO.builder()
                .id(atm.getId())
                .bankId(atm.getBankId())
                .type(atm.getType())
                .isAccessible(atm.isAccessible())
                .hasDepositCapability(atm.isHasDepositCapability())
                .balanceInquiryFee(atm.getBalanceInquiryFee())
                .cashWithdrawalNationalFee(atm.getCashWithdrawalNationalFee())
                .cashWithdrawalInternationalFee(atm.getCashWithdrawalInternationalFee())
                .supportedCurrencies(atm.getSupportedCurrencies())
                .supportedLanguages(atm.getSupportedLanguages())
                // ATM'ye özgü alanları atıyoruz
                .addresses(AddressMapper.mapToResponse(atm.getAddress()))
                .services(ATMServiceCodeMapper.mapToResponseDtoList(atm.getServices()))
                .location(LocationMapper.mapToResponseDTO(atm.getLocation()))
                .createDate(atm.getCreateDate())
                .lastUpdateDate(atm.getLastUpdateDate())
                .build();
    }

    public static List<ATMResponseDTO> mapToResponseDTOList(List<ATM> atmList) {
        return atmList.stream().map(ATMMapper::mapToResponseDTO).toList();
    }
}
