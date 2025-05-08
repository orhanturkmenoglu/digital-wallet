package com.digitalwallet.bank.service.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponseDTO {
    private String id;
    private String bankId;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
