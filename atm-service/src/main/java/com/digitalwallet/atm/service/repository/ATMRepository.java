package com.digitalwallet.atm.service.repository;

import com.digitalwallet.atm.service.model.ATM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATMRepository extends JpaRepository<ATM, String> {
}