package com.digitalwallet.atm.service.mapper;

import com.digitalwallet.atm.service.dto.request.ATMServiceCodeRequestDto;
import com.digitalwallet.atm.service.dto.response.ATMServiceCodeResponseDTO;
import com.digitalwallet.atm.service.model.ATMServiceCode;

import java.util.List;
import java.util.stream.Collectors;


public class ATMServiceCodeMapper {

    public static ATMServiceCode mapToATMService(ATMServiceCodeRequestDto atmServiceCodeRequestDto) {
        return ATMServiceCode.builder()
                .serviceCode(atmServiceCodeRequestDto.getServiceCode())
                .build();
    }

    public static ATMServiceCodeResponseDTO mapToResponseDto(ATMServiceCode atmServiceCode) {
        return ATMServiceCodeResponseDTO.builder()
                .id(atmServiceCode.getId())
                .serviceCode(atmServiceCode.getServiceCode())
                .createDate(atmServiceCode.getCreateDate())
                .lastUpdateDate(atmServiceCode.getLastUpdateDate())
                .build();
    }

    public static List<ATMServiceCodeResponseDTO> mapToResponseDtoList(List<ATMServiceCode> entities) {
        return entities.stream()
                .map(ATMServiceCodeMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public static List<ATMServiceCode> mapToATMServiceList(List<ATMServiceCodeRequestDto> dtos) {
        return dtos.stream()
                .map(ATMServiceCodeMapper::mapToATMService)
                .collect(Collectors.toList());
    }
}
