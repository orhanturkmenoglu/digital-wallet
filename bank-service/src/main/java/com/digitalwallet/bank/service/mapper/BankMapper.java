package com.digitalwallet.bank.service.mapper;

import com.digitalwallet.bank.service.dto.request.BankRequestDTO;
import com.digitalwallet.bank.service.dto.response.BankResponseDTO;
import com.digitalwallet.bank.service.model.Address;
import com.digitalwallet.bank.service.model.Bank;

import java.util.List;

public class BankMapper {

    public static Bank mapToBank(BankRequestDTO bankRequestDTO) {

        Bank bank = Bank.builder()
                .bankCode(bankRequestDTO.getBankCode())
                .fullName(bankRequestDTO.getFullName())
                .logo(bankRequestDTO.getLogo())
                .webSite(bankRequestDTO.getWebSite())
                .build();

        List<Address> addressList = AddressMapper.mapToAddressList(bankRequestDTO.getAddress());

        for (Address address : addressList) {
           address.setBank(bank);
        }

        bank.setAddressList(addressList);

        return bank;
    }

    public static BankResponseDTO mapBankResponseDTO(Bank bank) {
        return BankResponseDTO.builder()
                .id(bank.getId())
                .bankCode(bank.getBankCode())
                .fullName(bank.getFullName())
                .logo(bank.getLogo())
                .webSite(bank.getWebSite())
                .address(AddressMapper.mapToAddressResponseDTOList(bank.getAddressList()))
                .createdAt(bank.getCreatedAt())
                .updatedAt(bank.getUpdatedAt())
                .build();
    }

    public static List<BankResponseDTO> mapToBankResponseDtoList(List<Bank> banks) {
        return banks.stream()
                .map(BankMapper::mapBankResponseDTO)
                .toList();
    }
}
