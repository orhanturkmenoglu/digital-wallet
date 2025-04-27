package com.digitalwallet.atm.service.controller;

import com.digitalwallet.atm.service.service.WeeklyHoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weekly-hours")
@RequiredArgsConstructor
public class WeeklyHoursController {

    private final WeeklyHoursService weeklyHoursService;
}
