package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.request.ATMUpdateRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.exception.ATMNotFoundException;
import com.digitalwallet.atm.service.exception.ApiSuccessResponse;
import com.digitalwallet.atm.service.exception.InvalidATMParametersException;
import com.digitalwallet.atm.service.mapper.ATMMapper;
import com.digitalwallet.atm.service.mapper.ATMServiceCodeMapper;
import com.digitalwallet.atm.service.mapper.AddressMapper;
import com.digitalwallet.atm.service.mapper.LocationMapper;
import com.digitalwallet.atm.service.model.ATM;
import com.digitalwallet.atm.service.model.ATMServiceCode;
import com.digitalwallet.atm.service.model.Address;
import com.digitalwallet.atm.service.model.Location;
import com.digitalwallet.atm.service.repository.ATMRepository;
import com.digitalwallet.atm.service.service.ATMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;

    @Transactional
    @Override
    public ATMResponseDTO createATM(ATMRequestDTO atmRequestDTO) {
        log.info("Creating ATM with data: {}", atmRequestDTO);

        ATM atm = ATMMapper.mapToATM(atmRequestDTO);
        ATM savedATM = atmRepository.save(atm);

        log.info("Saved ATM: {}", savedATM);

        return ATMMapper.mapToResponseDTO(savedATM);
    }

    @Override
    public ApiSuccessResponse<Void> deleteByBankIdAndAtmId(String bankId, String atmId) {
        validateBankAndAtmIds(bankId, atmId);

        atmRepository.deleteByAtmIdAndBankId(atmId, bankId);

        log.info("Deleted ATM with ID: {} and Bank ID: {}", atmId, bankId);

        return ApiSuccessResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("ATM with ID " + atmId + " and Bank ID " + bankId + " deleted successfully")
                .build();
    }

    @Override
    public ATMResponseDTO getATMbyID(String atmId) {
        validateAtmId(atmId);

        ATM existingATM = findATMById(atmId);

        log.info("Retrieved ATM: {}", existingATM);

        return ATMMapper.mapToResponseDTO(existingATM);
    }

    @Transactional
    @Override
    public ATMResponseDTO updateATM(String atmId, ATMUpdateRequestDTO atmUpdateRequestDTO) {
        validateAtmId(atmId);

        ATM existingATM = findATMById(atmId);
        updateATMDetails(existingATM, atmUpdateRequestDTO);

        ATM updatedAtm = atmRepository.save(existingATM);

        log.info("Updated ATM: {}", updatedAtm);

        return ATMMapper.mapToResponseDTO(updatedAtm);
    }

    @Override
    public List<ATMResponseDTO> getAllATMs() {
        List<ATM> atmList = atmRepository.findAll();

        if (atmList.isEmpty()) {
            log.error("No ATMs found in the system");
            throw new ATMNotFoundException("No ATMs found in the system");
        }

        return ATMMapper.mapToResponseDTOList(atmList);
    }

    @Override
    public List<ATMResponseDTO> findATMsByCity(String city) {
        validateCity(city);

        List<ATM> atmList = atmRepository.findATMSByCity(city);

        if (atmList.isEmpty()) {
            log.error("No ATMs found in the city: {}", city);
            throw new ATMNotFoundException("No ATMs found in the city: " + city);
        }

        return ATMMapper.mapToResponseDTOList(atmList);
    }

    private void validateBankAndAtmIds(String bankId, String atmId) {
        if (!StringUtils.hasText(bankId) || !StringUtils.hasText(atmId)) {
            log.error("Bank ID and ATM ID cannot be null");
            throw new InvalidATMParametersException("Bank ID and ATM ID cannot be null");
        }
    }

    private void validateAtmId(String atmId) {
        if (!StringUtils.hasText(atmId)) {
            log.error("ATM ID cannot be null");
            throw new InvalidATMParametersException("ATM ID cannot be null");
        }
    }

    private void validateCity(String city) {
        if (!StringUtils.hasText(city)) {
            log.error("City cannot be null");
            throw new InvalidATMParametersException("City cannot be null");
        }
    }

    private ATM findATMById(String atmId) {
        return atmRepository.findById(atmId)
                .orElseThrow(() -> new InvalidATMParametersException("ATM with ID " + atmId + " not found"));
    }

    private void updateATMDetails(ATM existingATM, ATMUpdateRequestDTO atmUpdateRequestDTO) {
        existingATM.setType(atmUpdateRequestDTO.getType());
        existingATM.setAccessible(atmUpdateRequestDTO.isAccessible());
        existingATM.setHasDepositCapability(atmUpdateRequestDTO.isHasDepositCapability());
        existingATM.setBalanceInquiryFee(atmUpdateRequestDTO.getBalanceInquiryFee());
        existingATM.setCashWithdrawalNationalFee(atmUpdateRequestDTO.getCashWithdrawalNationalFee());
        existingATM.setCashWithdrawalInternationalFee(atmUpdateRequestDTO.getCashWithdrawalInternationalFee());
        existingATM.setSupportedCurrencies(atmUpdateRequestDTO.getSupportedCurrencies());
        existingATM.setSupportedLanguages(atmUpdateRequestDTO.getSupportedLanguages());

        List<ATMServiceCode> serviceCodeList = atmUpdateRequestDTO.getServices().stream()
                .map(ATMServiceCodeMapper::mapToATMService)
                .toList();
        existingATM.setServices(serviceCodeList);

        Address updatedAddress = AddressMapper.mapToAddress(atmUpdateRequestDTO.getAddresses());
        existingATM.setAddress(updatedAddress);

        Location updatedLocation = LocationMapper.mapToLocation(atmUpdateRequestDTO.getLocation());
        existingATM.setLocation(updatedLocation);
    }
}
