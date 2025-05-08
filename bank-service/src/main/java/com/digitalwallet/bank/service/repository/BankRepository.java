package com.digitalwallet.bank.service.repository;

import com.digitalwallet.bank.service.enums.BankCode;
import com.digitalwallet.bank.service.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
    boolean existsByBankCode(BankCode bankCode);
}