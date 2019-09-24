package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.SeatDaoImpl;

public class SeatService {
    private SeatDaoImpl seatDao;

    public SeatService(SeatDaoImpl seatDao) {
        this.seatDao = seatDao;
    }
}
