package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.exceptions.ConnectionException;
import com.abseliamov.cinema.model.Ticket;
import com.abseliamov.cinema.utils.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl extends AbstractDao<Ticket> {
    private Connection connection = ConnectionUtil.getConnection();
    private MovieDaoImpl movieDao;
    private SeatDaoImpl seatDao;
    private DateTimeDaoImpl timeDao;

    public TicketDaoImpl(Connection connection, MovieDaoImpl movieDao,
                         SeatDaoImpl seatDao, DateTimeDaoImpl timeDao, String tableName) {
        super(connection, tableName);
        this.movieDao = movieDao;
        this.seatDao = seatDao;
        this.timeDao = timeDao;
    }

    @Override
    public Ticket createEntity(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getLong("id"),
                movieDao.getById(resultSet.getLong("movie_id")),
                timeDao.getById(resultSet.getLong("date_time_id")).getDate(),
                timeDao.getById(resultSet.getLong("date_time_id")).getTime(),
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

    public List<Ticket> getTicketByMovieTitle(String movieTitle) {
        List<Ticket> ticketList = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM tickets WHERE movie_id IN (" +
                        "SELECT id FROM movies WHERE movies.name = ?)")) {
            statement.setString(1, movieTitle);
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

    public List<Ticket> getTicketByGenre(long genreId) {
        List<Ticket> ticketList = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM tickets WHERE movie_id IN(" +
                        "SELECT id FROM movies WHERE movies.genre_id = ?)")) {
            statement.setLong(1, genreId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                ticketList.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new ConnectionException(e);
        }
        return ticketList;
    }

    public List<Ticket> getTicketByDate(LocalDate date) {
        List<Ticket> ticketList = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM tickets WHERE date_time_id IN(" +
                        "SELECT id FROM date_times WHERE date = ?)")) {
            statement.setDate(1, Date.valueOf(date));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                ticketList.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new ConnectionException(e);
        }
        return ticketList;
    }

    public List<Ticket> getTicketBySeatType(long seatTypeId) {
        List<Ticket> ticketList = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM tickets WHERE seat_id IN(" +
                        "SELECT id FROM seats WHERE seats.seat_type_id = ?)")) {
            statement.setLong(1, seatTypeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                ticketList.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new ConnectionException(e);
        }
        return ticketList;
    }
}
