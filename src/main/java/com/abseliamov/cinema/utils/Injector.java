package com.abseliamov.cinema.utils;

import com.abseliamov.cinema.controller.*;
import com.abseliamov.cinema.dao.*;
import com.abseliamov.cinema.service.*;
import com.abseliamov.cinema.view.ViewerMenu;

import java.sql.Connection;

public class Injector {

    private static Connection connection = ConnectionUtil.getConnection();

    public static final String GENRES_TABLE = "genres";
    public static final String MOVIES_TABLE = "movies";
    public static final String SEAT_TYPES_TABLE = "seat_types";
    public static final String SEATS_TABLE = "seats";
    public static final String ROLES_TABLE = "roles";
    public static final String VIEWERS_TABLE = "viewers";
    public static final String DATE_TIMES_TABLE = "date_times";
    public static final String TICKETS_TABLE = "tickets";

    private static ViewerDaoImpl userDao = new ViewerDaoImpl(connection, VIEWERS_TABLE);
    private static ViewerService viewerService = new ViewerService(userDao);
    private static ViewerController viewerController = new ViewerController(viewerService);

    private static GenreDaoImpl genreDao = new GenreDaoImpl(connection, GENRES_TABLE);
    private static GenreService genreService = new GenreService(genreDao);
    private static GenreController genreController = new GenreController(genreService);

    private static MovieDaoImpl movieDao = new MovieDaoImpl(connection, genreDao, MOVIES_TABLE);
    private static MovieService movieService = new MovieService(movieDao);
    private static MovieController movieController = new MovieController(movieService);

    private static SeatTypesDao seatTypesDao = new SeatTypesDao(connection, SEAT_TYPES_TABLE);
    private static SeatTypesService seatTypesService = new SeatTypesService(seatTypesDao);
    private static SeatTypesController seatTypesController = new SeatTypesController(seatTypesService);

    private static DateTimeDaoImpl timeDao = new DateTimeDaoImpl(connection, DATE_TIMES_TABLE);

    private static SeatDaoImpl seatDao = new SeatDaoImpl(connection, seatTypesDao, SEATS_TABLE);
    private static SeatService seatService = new SeatService(seatDao);
    private static SeatController seatController = new SeatController(seatService);

    private static DateTimeDaoImpl dateTimeDao = new DateTimeDaoImpl(connection, DATE_TIMES_TABLE);
    private static DateTimeService dateTimeService = new DateTimeService(dateTimeDao);
    private static DateTimeController dateTimeController = new DateTimeController(dateTimeService);

    private static TicketDaoImpl ticketDao = new TicketDaoImpl(connection, movieDao, seatDao, timeDao, TICKETS_TABLE);
    private static TicketService ticketService = new TicketService(ticketDao, dateTimeService);
    private static TicketController ticketController = new TicketController(ticketService);

    private static ViewerMenu viewerMenu = new ViewerMenu(viewerController, ticketController, genreController,
            dateTimeController, seatController, seatTypesController);

    private Injector() {
    }

    public static ViewerMenu getViewerMenu() {
        return viewerMenu;
    }
}
