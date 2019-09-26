package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.Seat;
import com.abseliamov.cinema.model.SeatTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDaoImpl extends AbstractDao<Seat> {
    private SeatTypesDao seatTypesDao;

    public SeatDaoImpl(Connection connection, SeatTypesDao seatTypesDao, String tableName) {
        super(connection, tableName);
        this.seatTypesDao = seatTypesDao;
    }

    @Override
    public Seat createEntity(ResultSet resultSet) throws SQLException {
        return new Seat(
                resultSet.getLong("id"),
                seatTypesDao.getById(resultSet.getLong("seat_type_id")),
                resultSet.getLong("number"));
    }

    @Override
    public boolean update(long id, Seat item) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
