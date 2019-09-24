package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.exceptions.ConnectionException;
import com.abseliamov.cinema.model.SeatTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatTypesDao {
    private static final String ERROR_MESSAGE = "Cannot connect to database: ";
    private Connection connection;
    private String tableName;

    public SeatTypesDao(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    public SeatTypes createEntity(ResultSet resultSet) throws SQLException {
        SeatTypes seatTypes = null;
        for (SeatTypes type : SeatTypes.values()) {
            if (type.getId() == resultSet.getLong("id")) {
                seatTypes = type;
            }
        }
        return seatTypes;
    }

    public SeatTypes getById(long id) {
        SeatTypes result = null;
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?;")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createEntity(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE + e);
            throw new ConnectionException(ERROR_MESSAGE, e);
        }
        return result;
    }
}
