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
//             ResultSet resultSet = statement.executeQuery("SELECT * FROM movies WHERE cost = (SELECT MAX(cost) FROM movies);")) {
             ResultSet resultSet = statement.executeQuery("SELECT * FROM purchased_tickets WHERE movie_id IN (" +
                     "SELECT movie_id FROM purchased_tickets WHERE date_id IN (" +
                     "        SELECT id FROM dates WHERE QUARTER(date_ticket) = QUARTER(CURDATE()))) GROUP BY movie_id;")) {
            System.out.printf("%-1s%-10s%-10s%-1s\n", " ", "movie_id", "date_id", "price");
            while (resultSet.next()) {
//                movies.add(createEntity(resultSet));
                System.out.printf("%-1s%-10s%-10s%-1s\n", " ",
                        resultSet.getLong("movie_id"),
                        resultSet.getLong("date_id"),
                        resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
