package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.service.SeatService;

public class SeatController {
    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }
}
