package com.digitalwallet.bank.service.mapper;

import com.digitalwallet.bank.service.dto.request.BankRequestDTO;
import com.digitalwallet.bank.service.dto.response.BankResponseDTO;
import com.digitalwallet.bank.service.model.Address;
import com.digitalwallet.bank.service.model.Bank;
import org.digitalwallet.common.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankMapper extends BaseMapper<Bank, BankRequestDTO, BankResponseDTO> {

    @Override
    public BankResponseDTO toResponseDTO(Bank entity) {
        return BankResponseDTO.builder()
                .id(entity.getId())
                .bankCode(entity.getBankCode())
                .fullName(entity.getFullName())
                .logo(entity.getLogo())
                .webSite(entity.getWebSite())
                .address(AddressMapper.mapToAddressResponseDTOList(entity.getAddressList()))
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    @Override
    public Bank toEntity(BankRequestDTO dto) {
        Bank bank = Bank.builder()
                .bankCode(dto.getBankCode())
                .fullName(dto.getFullName())
                .logo(dto.getLogo())
                .webSite(dto.getWebSite())
                .build();

        List<Address> addressList = AddressMapper.mapToAddressList(dto.getAddress());

        for (Address address : addressList) {
            address.setBank(bank);
        }

        bank.setAddressList(addressList);

        return bank;
    }

}
