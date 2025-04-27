package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.service.ATMService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/atm")
@RequiredArgsConstructor
public class ATMController {

    private final ATMService atmService;
}
