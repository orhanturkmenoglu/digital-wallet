package com.digitalwallet.atm.service.repository;

import com.digitalwallet.atm.service.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    Optional<Location> findByLatitudeAndLongitude(double latitude, double longitude);
}