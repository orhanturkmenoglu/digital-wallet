package com.digitalwallet.atm.service.service.impl;

import com.digitalwallet.atm.service.dto.request.ATMRequestDTO;
import com.digitalwallet.atm.service.dto.response.ATMResponseDTO;
import com.digitalwallet.atm.service.mapper.ATMMapper;
import com.digitalwallet.atm.service.model.ATM;
import com.digitalwallet.atm.service.repository.ATMRepository;
import com.digitalwallet.atm.service.service.ATMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;

    @Transactional
    @Override
    public ATMResponseDTO createATM(ATMRequestDTO atmRequestDTO) {

        ATM atm = ATMMapper.mapToATM(atmRequestDTO);
        log.info("ATMRequestDTO: {}", atmRequestDTO);

        ATM savedATM = atmRepository.save(atm);
        log.info("Saving ATM: {}", atm);

        ATMResponseDTO atmResponseDTO = ATMMapper.mapToResponseDTO(savedATM);
        log.info("ATMResponseDTO: {}", atmResponseDTO);
        log.info("Saved ATM: {}", atmResponseDTO);

        return atmResponseDTO;
    }

    @Transactional
    @Override
    public ATMResponseDTO deleteATMID(String atmId) {
        return null;
    }

    @Override
    public ATMResponseDTO getATMbyID(String atmId) {
        return null;
    }

    @Transactional
    @Override
    public ATMResponseDTO updateATM(String atmId) {
        return null;
    }

    @Override
    public List<ATMResponseDTO> getAllATMs() {
        return List.of();
    }
}
