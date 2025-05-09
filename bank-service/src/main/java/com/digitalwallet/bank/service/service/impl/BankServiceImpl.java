package com.digitalwallet.bank.service.service.impl;

import com.digitalwallet.bank.service.dto.request.BankRequestDTO;
import com.digitalwallet.bank.service.dto.response.BankResponseDTO;
import com.digitalwallet.bank.service.exception.BankCodeAlreadyExistsException;
import com.digitalwallet.bank.service.exception.BankInvalidParameterException;
import com.digitalwallet.bank.service.exception.BankNotFoundException;
import com.digitalwallet.bank.service.mapper.AddressMapper;
import com.digitalwallet.bank.service.mapper.BankMapper;
import com.digitalwallet.bank.service.model.Address;
import com.digitalwallet.bank.service.model.Bank;
import com.digitalwallet.bank.service.repository.BankRepository;
import com.digitalwallet.bank.service.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    private final BankMapper bankMapper;

    @Override
    public BankResponseDTO createBank(BankRequestDTO bankRequestDTO) {

        if (Objects.isNull(bankRequestDTO)) {
            log.error("Bank request is null");
            throw new BankInvalidParameterException("Bank request is null");
        }

        boolean existsByBankCode = bankRepository.existsByBankCode(bankRequestDTO.getBankCode());
        if (existsByBankCode) {
            log.error("Bank with code {} already exists", bankRequestDTO.getBankCode());
            throw new BankCodeAlreadyExistsException("Bank with code " + bankRequestDTO.getBankCode() + " already exists");
        }

        Bank bank = bankMapper.toEntity(bankRequestDTO);
        Bank savedBank = bankRepository.save(bank);
        log.info("Saved bank: {}", savedBank);

        return bankMapper.toResponseDTO(savedBank);
    }

    @Override
    public List<BankResponseDTO> getAllBanks() {
        List<Bank> bankList = bankRepository.findAll();
        log.info("Retrieved bank list: {}", bankList);
        return bankMapper.toResponseDTOList(bankList);
    }

    @Override
    public BankResponseDTO getBankById(String id) {
        validateParameter(id);

        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank not found"));

        log.info("Retrieved bank: {}", bank);
        return bankMapper.toResponseDTO(bank);
    }

    @Override
    public BankResponseDTO updateBank(String id, BankRequestDTO bankRequestDTO) {

        validateParameter(id);

        if (Objects.isNull(bankRequestDTO)) {
            log.error("Bank request is null");
            throw new BankInvalidParameterException("Bank request is null");
        }

        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank with id " + id + " not found"));

        bank.setBankCode(bankRequestDTO.getBankCode());

        List<Address> addressList = AddressMapper.mapToAddressList(bankRequestDTO.getAddress());
        bank.setAddressList(addressList);
        log.info("Updated address list: {}", addressList);

        bank.setLogo(bankRequestDTO.getLogo());
        bank.setFullName(bankRequestDTO.getFullName());
        bank.setWebSite(bankRequestDTO.getWebSite());

        Bank savedBank = bankRepository.save(bank);
        log.info("Updated bank: {}", savedBank);

        return bankMapper.toResponseDTO(savedBank);
    }

    @Override
    public void deleteBankById(String id) {
        validateParameter(id);

        BankResponseDTO bank = getBankById(id);
        log.info("Deleted bank: {}", bank);

        bankRepository.deleteById(bank.getId());
    }

    private void validateParameter(String object) {
        if (!StringUtils.hasText(object)) {
            log.error("{} cannot be null or empty", object);
            throw new BankInvalidParameterException(object + " cannot be null or empty");
        }
    }
}
