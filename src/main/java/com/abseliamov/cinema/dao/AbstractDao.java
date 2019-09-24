package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.exceptions.ConnectionException;
import com.abseliamov.cinema.model.GenericModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends GenericModel> implements GenericDao<T> {
    private static final String ERROR_MESSAGE = "Cannot connect to database: ";
    private String tableName;
    private Connection connection;

    public AbstractDao(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    public void add(T item) {
        try (PreparedStatement statement = connection
                .prepareStatement("INSERT INTO " + tableName + " (name)VALUES (?);")) {
            statement.setString(1, item.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE + e);
            throw new ConnectionException(ERROR_MESSAGE, e);
        }
    }

    public T getById(long id) {
        T result = null;
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

    public List<T> getAll(){
        List<T> result = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName)){
            while (resultSet.next()){
                T entity = createEntity(resultSet);
                result.add(entity);
            }
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE + e);
            throw new ConnectionException(ERROR_MESSAGE, e);
        }
        return result;
    }

    public abstract T createEntity(ResultSet resultSet) throws SQLException;
}
