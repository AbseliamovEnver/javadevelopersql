package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.SeatTypesDao;
import com.abseliamov.cinema.model.SeatTypes;

import java.util.List;

public class SeatTypesService {
    private SeatTypesDao seatTypesDao;

    public SeatTypesService(SeatTypesDao seatTypesDao) {
        this.seatTypesDao = seatTypesDao;
    }

    public List<SeatTypes> getAllSeatType() {
        return seatTypesDao.getAll();
    }
}
