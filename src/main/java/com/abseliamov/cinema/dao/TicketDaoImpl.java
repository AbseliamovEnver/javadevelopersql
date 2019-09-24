package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.exceptions.ConnectionException;
import com.abseliamov.cinema.model.Ticket;
import com.abseliamov.cinema.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.abseliamov.cinema.utils.Injector.MOVIES_TABLE;
import static com.abseliamov.cinema.utils.Injector.TICKETS_TABLE;

public class TicketDaoImpl extends AbstractDao<Ticket> {
    private Connection connection = ConnectionUtil.getConnection();
    private MovieDaoImpl movieDao;
    private SeatDaoImpl seatDao;
    private DateTimeDao timeDao;

    public TicketDaoImpl(Connection connection, MovieDaoImpl movieDao,
                         SeatDaoImpl seatDao, DateTimeDao timeDao, String tableName) {
        super(connection, tableName);
        this.movieDao = movieDao;
        this.seatDao = seatDao;
        this.timeDao = timeDao;
    }

    public List<Ticket> getTicketByMovieTitle(String movieTitle) {
        List<Ticket> result = new ArrayList<>();
        try (PreparedStatement statement = connection.
                prepareStatement("SELECT * FROM tickets WHERE movie_id IN (" +
                        "SELECT id FROM movies WHERE movies.name = ?)")) {
            statement.setString(1, movieTitle);
//            "SELECT * FROM " + MOVIES_TABLE + " WHERE name = ?;"
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                result = getTicketByMovieId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new ConnectionException(e);
        }
        return result;
    }

    @Override
    public Ticket createEntity(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getLong("id"),
                movieDao.getById(resultSet.getLong("movie_id")).getName(),
                timeDao.getById(resultSet.getLong("date_time_id")),
                seatDao.getById(resultSet.getLong("seat_id")),
                resultSet.getDouble("price"));
    }

    @Override
    public boolean update(long id, Ticket item) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    private List<Ticket> getTicketByMovieId(long movieId) {
        List<Ticket> ticketList = new ArrayList<>();
        try (PreparedStatement statement = connection.
                prepareStatement("SELECT * FROM " + TICKETS_TABLE + " WHERE movie_id = ?;")) {
            statement.setLong(1, movieId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketList.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new ConnectionException(e);
        }
        return ticketList;
    }
}
