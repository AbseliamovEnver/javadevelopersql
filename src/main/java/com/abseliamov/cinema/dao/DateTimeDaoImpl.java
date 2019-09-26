package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.DateTime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateTimeDaoImpl extends AbstractDao<DateTime>{
    private static final String ERROR_MESSAGE = "Cannot connect to database: ";
    private Connection connection;
    private String tableName;

    public DateTimeDaoImpl(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public DateTime createEntity(ResultSet resultSet) throws SQLException {
        return new DateTime(
                resultSet.getLong("id"),
                resultSet.getDate("date").toLocalDate(),
                resultSet.getTime("time").toLocalTime());
    }

    @Override
    public boolean update(long id, DateTime item) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
