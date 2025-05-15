package com.digitalwallet.bank.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {
        "com.digitalwallet.bank.service",
        "org.digitalwallet.common.config"
})
@EnableCaching
public class BankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankServiceApplication.class, args);
    }

}
