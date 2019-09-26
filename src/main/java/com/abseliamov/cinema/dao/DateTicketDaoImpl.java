package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.DateTicket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateTicketDaoImpl extends AbstractDao<DateTicket> {

    public DateTicketDaoImpl(Connection connection, String tableName) {
        super(connection, tableName);
    }

    @Override
    public DateTicket createEntity(ResultSet resultSet) throws SQLException {
        return new DateTicket(
                resultSet.getLong("id"),
                resultSet.getDate("date_ticket").toLocalDate());
    }

    @Override
    public boolean update(long id, DateTicket item) {
        return false;
    }
}
