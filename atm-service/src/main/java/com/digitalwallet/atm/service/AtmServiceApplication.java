package com.digitalwallet.atm.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {
		"com.digitalwallet.atm.service",
		"org.digitalwallet.common.config"
})
@EnableCaching
public class AtmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmServiceApplication.class, args);
	}

}
