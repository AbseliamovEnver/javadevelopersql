package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.SeatDaoImpl;
import com.abseliamov.cinema.model.Seat;

import java.util.List;

public class SeatService {
    private SeatDaoImpl seatDao;

    public SeatService(SeatDaoImpl seatDao) {
        this.seatDao = seatDao;
    }

    public List<Seat> getAllSeatType() {
        List<Seat> seatTypes = seatDao.getAll();
        printSeatTypes(seatTypes);
        return seatTypes;
    }

    private void printSeatTypes(List<Seat> seats){

    }
}
