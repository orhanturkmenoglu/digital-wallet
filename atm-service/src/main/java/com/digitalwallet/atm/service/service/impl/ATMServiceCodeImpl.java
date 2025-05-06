package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.response.ATMServiceCodeResponseDTO;
import com.digitalwallet.atm.service.exception.ATMServiceCodeInvalidParameterException;
import com.digitalwallet.atm.service.exception.ATMServiceCodeNotFoundException;
import com.digitalwallet.atm.service.mapper.ATMServiceCodeMapper;
import com.digitalwallet.atm.service.repository.ATMServiceCodeRepository;
import com.digitalwallet.atm.service.service.ATMServiceCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ATMServiceCodeImpl implements ATMServiceCode {

    private final ATMServiceCodeRepository atmServiceCodeRepository;

    @Override
    public List<ATMServiceCodeResponseDTO> getAllATMServiceCodes() {

        List<ATMServiceCodeResponseDTO> serviceCodeResponseDTOList = atmServiceCodeRepository.findAll()
                .stream()
                .map(ATMServiceCodeMapper::mapToResponseDto)
                .sorted(Comparator.comparing(ATMServiceCodeResponseDTO::getServiceCode))
                .toList();

        log.info("Returning {} service codes", serviceCodeResponseDTOList.size());

        if (serviceCodeResponseDTOList.isEmpty()) {
            log.error("No service codes found in the system");
            throw new ATMServiceCodeNotFoundException("No service codes found in the system");
        }

        return serviceCodeResponseDTOList;
    }

    @Override
    public Optional<ATMServiceCodeResponseDTO> findATMServiceCodeById(String id) {
        if (id == null || id.trim().isEmpty()) {
            log.error("ATM Service Code ID cannot be null or empty");
            throw new ATMServiceCodeInvalidParameterException("ATM Service Code ID cannot be null or empty");
        }

        com.digitalwallet.atm.service.model.ATMServiceCode atmServiceCode = atmServiceCodeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("ATM Service Code not found for ID: {}", id);
                    return new ATMServiceCodeNotFoundException("ATM Service Code not found for ID: " + id);
                });

        ATMServiceCodeResponseDTO dto = ATMServiceCodeMapper.mapToResponseDto(atmServiceCode);
        log.info("Retrieved ATM service code by ID: {}", dto);
        return Optional.of(dto);
    }

    @Override
    public Optional<ATMServiceCodeResponseDTO> findByServiceCode (String serviceCode) {
        if (serviceCode == null || serviceCode.trim().isEmpty()) {
            log.error("Service code cannot be null or empty");
            throw new ATMServiceCodeInvalidParameterException("Service code cannot be null or empty");
        }

        com.digitalwallet.atm.service.model.ATMServiceCode atmServiceCode = atmServiceCodeRepository.findByServiceCode(serviceCode)
                .orElseThrow(() -> {
                    log.error("ATM Service Code not found for serviceCode: {}", serviceCode);
                    return new ATMServiceCodeNotFoundException("ATM Service Code not found for serviceCode: " + serviceCode);
                });

        ATMServiceCodeResponseDTO dto = ATMServiceCodeMapper.mapToResponseDto(atmServiceCode);
        log.info("Retrieved ATM service code by serviceCode: {}", dto);
        return Optional.of(dto);
    }
}
