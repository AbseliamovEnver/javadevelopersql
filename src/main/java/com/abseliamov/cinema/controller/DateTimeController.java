package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.service.DateTimeService;

import java.time.LocalDate;
import java.util.Map;

public class DateTimeController {
    private DateTimeService dateTimeService;

    public DateTimeController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    public Map<LocalDate, Long> getAllDate(){
        return dateTimeService.getAllDate();
    }
}
