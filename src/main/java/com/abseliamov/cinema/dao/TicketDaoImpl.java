package com.abseliamov.cinema.dao;

import com.abseliamov.cinema.exceptions.ConnectionException;
import com.abseliamov.cinema.model.Ticket;
import com.abseliamov.cinema.utils.ConnectionUtil;
import com.abseliamov.cinema.utils.CurrentViewer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl extends AbstractDao<Ticket> {
    private Connection connection = ConnectionUtil.getConnection();
    private CurrentViewer currentViewer;
    private MovieDaoImpl movieDao;
    private SeatDaoImpl seatDao;
    private DateTicketDaoImpl dateTicketDao;
    private TimeTicketDaoImpl timeTicketDao;

    public TicketDaoImpl(Connection connection, CurrentViewer currentViewer, MovieDaoImpl movieDao, SeatDaoImpl seatDao,
                         DateTicketDaoImpl dateTicketDao, TimeTicketDaoImpl timeTicketDao, String tableName) {
        super(connection, tableName);
        this.currentViewer = currentViewer;
        this.movieDao = movieDao;
        this.seatDao = seatDao;
        this.dateTicketDao = dateTicketDao;
        this.timeTicketDao = timeTicketDao;
    }

    @Override
    public Ticket createEntity(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getLong("id"),
                movieDao.getById(resultSet.getLong("movie_id")),
                dateTicketDao.getById(resultSet.getLong("date_id")),
                timeTicketDao.getById(resultSet.getLong("time_id")),
                seatDao.getById(resultSet.getLong("seat_id")),
                resultSet.getDouble("price"));
    }

    @Override
    public boolean update(long id, Ticket item) {
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
            while (resultSet.next()) {
                ticketList.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new ConnectionException(e);
        }
        return ticketList;
    }

    public List<Ticket> getTicketByDateId(long dateId) {
        List<Ticket> ticketList = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM tickets WHERE date_id = ?")) {
            statement.setLong(1, dateId);
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

    public List<Ticket> getTicketBySeatType(long seatTypeId) {
        List<Ticket> ticketList = new ArrayList<>();
        try (PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM tickets WHERE seat_id IN(" +
                        "SELECT id FROM seats WHERE seats.seat_type_id = ?)")) {
            statement.setLong(1, seatTypeId);
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

    public boolean byTicket(Ticket ticket) {
        boolean exist = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO purchased_tickets(ID, TICKET_ID, VIEWER_ID, MOVIE_ID, DATE_ID, TIME_ID, SEAT_ID, PRICE) " +
                        "VALUES (DEFAULT,?,?,?,?,?,?,?)")) {
            statement.setLong(1, ticket.getId());
            statement.setLong(2, currentViewer.getViewer().getId());
            statement.setLong(3, ticket.getMovie().getId());
            statement.setLong(4, ticket.getDate().getId());
            statement.setLong(5, ticket.getTime().getId());
            statement.setLong(6, ticket.getSeat().getId());
            statement.setDouble(7, ticket.getPrice());
            statement.executeUpdate();
            exist = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }
}
