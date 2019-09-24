package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.exceptions.ConnectionException;
import com.abseliamov.cinema.model.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DateTimeDao {
    private static final String ERROR_MESSAGE = "Cannot connect to database: ";
    private Connection connection;
    private String tableName;

    public DateTimeDao(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    public DateTime createEntity(ResultSet resultSet) throws SQLException {
        return new DateTime(
                resultSet.getLong("id"),
                resultSet.getTimestamp("date_time").toLocalDateTime());
    }

    public LocalDateTime getById(long id){
        LocalDateTime result = null;
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?;")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createEntity(resultSet).getDateTime();
            }
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE + e);
            throw new ConnectionException(ERROR_MESSAGE, e);
        }
        return result;
    }
}
