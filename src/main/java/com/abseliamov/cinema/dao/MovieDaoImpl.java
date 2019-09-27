package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.Movie;
import com.abseliamov.cinema.utils.ConnectionUtil;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl extends AbstractDao<Movie> {
    private static final String ERROR_MESSAGE = "Cannot connect to database: ";
    Connection connection = ConnectionUtil.getConnection();
    private GenreDaoImpl genreDao;

    public MovieDaoImpl(Connection connection, GenreDaoImpl genreDao, String tableName) {
        super(connection, tableName);
        this.genreDao = genreDao;
    }

    @Override
    public Movie createEntity(ResultSet resultSet) throws SQLException {
        return new Movie(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                genreDao.getById(resultSet.getLong("genre_id")),
                resultSet.getDouble("cost"));
    }

    @Override
    public boolean update(long id, Movie movie) {
        boolean updateExist = false;
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE movies SET cost = ? WHERE id = ?")) {
            statement.setDouble(1, movie.getCost());
            statement.setLong(2, id);
            statement.executeUpdate();
            updateExist = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return updateExist;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    public List<Movie> requestMovie() {
        List<Movie> movies = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM movies WHERE cost = (SELECT MAX(cost) FROM movies);")) {
            while (resultSet.next()) {
                movies.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
