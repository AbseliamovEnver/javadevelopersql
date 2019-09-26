package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.Seat;
import com.abseliamov.cinema.service.SeatService;

import java.util.List;

public class SeatController {
    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    public List<Seat> getAllSeatType() {
        return seatService.getAllSeatType();
    }
}
