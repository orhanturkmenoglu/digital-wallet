package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.service.ATMServiceCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/atm-service-codes")
@RequiredArgsConstructor
public class ATMServiceCodeController {

    private final ATMServiceCode atmServiceCodeService;
}
