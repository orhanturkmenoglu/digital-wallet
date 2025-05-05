package com.digitalwallet.atm.service.repository;

import com.digitalwallet.atm.service.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findAllByOrderByLine1();

    List<Address> findByPostCode(String postCode);

    List<Address> findByCountryCode(String countryCode);

    List<Address> findByState(String state);

    List<Address> findByLine1(String line1);

    List<Address> findByLine2(String line2);

}