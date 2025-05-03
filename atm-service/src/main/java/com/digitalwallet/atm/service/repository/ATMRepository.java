package com.digitalwallet.atm.service.repository;

import com.digitalwallet.atm.service.model.ATM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ATMRepository extends JpaRepository<ATM, String> {

    Optional<ATM> findByIdAndBankId(String atmId, String bankId);

    @Transactional
    @Modifying
    @Query("delete from ATM a where a.id = :atmId and a.bankId = :bankId")
    void deleteByAtmIdAndBankId(String atmId, String bankId);


    @Query("""
             SELECT a from ATM a where a.address.city = :city
            """)
    List<ATM> findATMSByCity(String city);
}