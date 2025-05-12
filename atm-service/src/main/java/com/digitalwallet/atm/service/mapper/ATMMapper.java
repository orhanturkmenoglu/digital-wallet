package com.digitalwallet.atm.service.mapper;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.model.ATM;
import org.digitalwallet.common.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class ATMMapper extends BaseMapper<ATM, ATMRequestDTO, ATMResponseDTO> {


    @Override
    public ATM toEntity(ATMRequestDTO dto) {
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

    @Override
    public ATMResponseDTO toResponseDTO(ATM entity) {
        return ATMResponseDTO.builder()
                .id(entity.getId())
                .bankId(entity.getBankId())
                .type(entity.getType())
                .isAccessible(entity.isAccessible())
                .hasDepositCapability(entity.isHasDepositCapability())
                .balanceInquiryFee(entity.getBalanceInquiryFee())
                .cashWithdrawalNationalFee(entity.getCashWithdrawalNationalFee())
                .cashWithdrawalInternationalFee(entity.getCashWithdrawalInternationalFee())
                .supportedCurrencies(entity.getSupportedCurrencies())
                .supportedLanguages(entity.getSupportedLanguages())
                // ATM'ye özgü alanları atıyoruz
                .addresses(AddressMapper.mapToResponse(entity.getAddress()))
                .services(ATMServiceCodeMapper.mapToResponseDtoList(entity.getServices()))
                .location(LocationMapper.mapToResponseDTO(entity.getLocation()))
                .createDate(entity.getCreatedAt())
                .lastUpdateDate(entity.getUpdatedAt())
                .build();
    }


}
