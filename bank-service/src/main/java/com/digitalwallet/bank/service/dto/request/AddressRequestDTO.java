package com.digitalwallet.bank.service.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequestDTO {
    private String city;
    private String country;
    private String state;
    private String street;
    private String zipCode;
}
