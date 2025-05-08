package com.digitalwallet.bank.service.dto.request;

import com.digitalwallet.bank.service.enums.BankCode;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankRequestDTO {

    private BankCode bankCode;

    private String fullName;

    private String logo;

    private String webSite;

    private List<AddressRequestDTO> address;
}
