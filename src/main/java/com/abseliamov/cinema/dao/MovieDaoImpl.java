package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.model.Movie;
import com.abseliamov.cinema.utils.ConnectionUtil;

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

    public List<Movie> searchMostProfitableMovie() {
        List<Movie> movies = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("" +
                     "SELECT movies.id, movies.name, moviePrice.totalPrice FROM (" +
                     "    SELECT movie_id FROM tickets WHERE (QUARTER(date_time) = QUARTER(CURDATE()))) AS date " +
                     "RIGHT JOIN (" +
                     "    SELECT movie_id AS moviePriceId, SUM(price) AS totalPrice FROM tickets WHERE buy_status > 0 " +
                     "      GROUP BY movie_id HAVING MAX(totalPrice) LIMIT 1) AS moviePrice " +
                     "ON date.movie_id = moviePrice.moviePriceId " +
                     "INNER JOIN movies " +
                     "ON movies.id = moviePrice.moviePriceId LIMIT 1")) {
            while (resultSet.next()) {
                movies.add(createMovieByRequest(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public List<Movie> searchLeastProfitableMovie() {
        List<Movie> movies = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("" +
                     "SELECT movies.id, movies.name, moviePrice.totalPrice FROM (" +
                     "    SELECT movie_id FROM tickets WHERE (QUARTER(date_time) = QUARTER(CURDATE()))) AS date " +
                     "RIGHT JOIN (" +
                     "    SELECT movie_id AS moviePriceId, SUM(price) AS totalPrice FROM tickets WHERE buy_status > 0 " +
                     "      GROUP BY movie_id ORDER BY movie_id DESC LIMIT 1) AS moviePrice " +
                     "ON date.movie_id = moviePrice.moviePriceId " +
                     "INNER JOIN movies " +
                     "ON movies.id = moviePrice.moviePriceId LIMIT 1")) {
            while (resultSet.next()) {
                movies.add(createMovieByRequest(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    private Movie createMovieByRequest(ResultSet resultSet) throws SQLException {
        return new Movie(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getDouble("totalPrice"));
    }
}
