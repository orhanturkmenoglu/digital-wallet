package com.digitalwallet.atm.service.repository;

import com.digitalwallet.atm.service.model.ATMServiceCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ATMServiceCodeRepository extends JpaRepository<ATMServiceCode, String> {


    Optional<ATMServiceCode> findByServiceCode(String serviceCode);
}