package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.request.ATMUpdateRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.exception.ATMInvalidParametersException;
import com.digitalwallet.atm.service.exception.ATMNotFoundException;
import com.digitalwallet.atm.service.exception.ApiSuccessResponse;
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
import org.digitalwallet.common.exception.BankNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;
    private final ATMMapper atmMapper;
    private final RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8082/api/v1/banks/";

    @Transactional
    @Override
    public ATMResponseDTO createATM(ATMRequestDTO atmRequestDTO) {
        log.info("Creating ATM with data: {}", atmRequestDTO);

        if (Objects.isNull(atmRequestDTO)) {
            log.error("ATMRequestDTO cannot be null");
            throw new ATMInvalidParametersException("ATMRequestDTO cannot be null");
        }

        try {
            String url = BASE_URL + atmRequestDTO.getBankId();
            ResponseEntity<Void> response = restTemplate.exchange(url,
                    HttpMethod.GET,
                    null, Void.class);

            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new BankNotFoundException("Bank with id " + atmRequestDTO.getBankId() + " not found");
            }
        } catch (HttpClientErrorException.NotFound e) {
            throw new BankNotFoundException("Bank with id " + atmRequestDTO.getBankId() + " not found");
        } catch (Exception e) {
            throw new RuntimeException();
        }


        ATM atm = atmMapper.toEntity(atmRequestDTO);
        ATM savedATM = atmRepository.save(atm);

        log.info("Saved ATM: {}", savedATM);

        return atmMapper.toResponseDTO(savedATM);
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

        return atmMapper.toResponseDTO(existingATM);
    }

    @Transactional
    @Override
    public ATMResponseDTO updateATM(String atmId, ATMUpdateRequestDTO atmUpdateRequestDTO) {
        validateAtmId(atmId);

        ATM existingATM = findATMById(atmId);
        updateATMDetails(existingATM, atmUpdateRequestDTO);

        ATM updatedAtm = atmRepository.save(existingATM);

        log.info("Updated ATM: {}", updatedAtm);

        return atmMapper.toResponseDTO(updatedAtm);
    }

    @Override
    public List<ATMResponseDTO> getAllATMs() {
        List<ATM> atmList = atmRepository.findAll();

        if (atmList.isEmpty()) {
            log.error("No ATMs found in the system");
            throw new ATMNotFoundException("No ATMs found in the system");
        }

        return atmMapper.toResponseDTOList(atmList);
    }

    @Override
    public List<ATMResponseDTO> findATMsByCity(String city) {
        validateCity(city);

        List<ATM> atmList = atmRepository.findATMSByCity(city);

        if (atmList.isEmpty()) {
            log.error("No ATMs found in the city: {}", city);
            throw new ATMNotFoundException("No ATMs found in the city: " + city);
        }

        return atmMapper.toResponseDTOList(atmList);
    }

    private void validateBankAndAtmIds(String bankId, String atmId) {
        if (!StringUtils.hasText(bankId) || !StringUtils.hasText(atmId)) {
            log.error("Bank ID and ATM ID cannot be null");
            throw new ATMInvalidParametersException("Bank ID and ATM ID cannot be null");
        }
    }

    private void validateAtmId(String atmId) {
        if (!StringUtils.hasText(atmId)) {
            log.error("ATM ID cannot be null");
            throw new ATMInvalidParametersException("ATM ID cannot be null");
        }
    }

    private void validateCity(String city) {
        if (!StringUtils.hasText(city)) {
            log.error("City cannot be null");
            throw new ATMInvalidParametersException("City cannot be null");
        }
    }

    private ATM findATMById(String atmId) {
        return atmRepository.findById(atmId)
                .orElseThrow(() -> new ATMInvalidParametersException("ATM with ID " + atmId + " not found"));
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
