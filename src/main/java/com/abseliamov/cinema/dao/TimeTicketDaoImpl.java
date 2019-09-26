package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.TimeTicket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeTicketDaoImpl extends AbstractDao<TimeTicket> {

    public TimeTicketDaoImpl(Connection connection, String tableName) {
        super(connection, tableName);
    }

    @Override
    public TimeTicket createEntity(ResultSet resultSet) throws SQLException {
        return new TimeTicket(
                resultSet.getLong("id"),
                resultSet.getTime("time_ticket").toLocalTime());
    }

    @Override
    public boolean update(long id, TimeTicket item) {
        return false;
    }
}
