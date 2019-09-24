package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.Movie;

import java.sql.*;

public class MovieDaoImpl extends AbstractDao<Movie> {
    private static final String ERROR_MESSAGE = "Cannot connect to database: ";
    private GenreDaoImpl genreDao;

    public MovieDaoImpl(Connection connection, GenreDaoImpl genreDao, String tableName) {
        super(connection, tableName);
        this.genreDao = genreDao;
    }

    @Override
    public Movie createEntity(ResultSet resultSet) throws SQLException {
        return new Movie(resultSet.getLong("id"),
                resultSet.getString("name"),
                genreDao.getById(resultSet.getLong("genre_id")));
    }

    @Override
    public boolean update(long id, Movie item) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
