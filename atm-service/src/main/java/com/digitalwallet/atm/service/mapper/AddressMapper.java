package com.digitalwallet.atm.service.mapper;

import com.digitalwallet.atm.service.dto.request.AddressRequestDTO;
import com.digitalwallet.atm.service.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public static Address toAddress(AddressRequestDTO addressRequestDTO) {
        Address address = new Address();

        return address;
    }
}
