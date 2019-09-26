package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.SeatTypes;
import com.abseliamov.cinema.service.SeatTypesService;

import java.util.List;

public class SeatTypesController {
    private SeatTypesService seatTypesService;

    public SeatTypesController(SeatTypesService seatTypesService) {
        this.seatTypesService = seatTypesService;
    }

    public List<SeatTypes> getAllSeatType() {
        return seatTypesService.getAllSeatType();
    }
}
