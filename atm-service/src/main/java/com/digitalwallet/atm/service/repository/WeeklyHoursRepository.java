package com.digitalwallet.atm.service.repository;

import com.digitalwallet.atm.service.model.WeeklyHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeeklyHoursRepository extends JpaRepository<WeeklyHours, UUID> {
}