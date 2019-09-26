package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public boolean getTicketByMovieTitle(String movieTitle) {
        return ticketService.getTicketByMovieTitle(movieTitle);
    }

    public boolean getTicketByGenre(long genreId) {
        return ticketService.getTicketByGenre(genreId);
    }

    public boolean getTicketByDate(long dateId) {
        return ticketService.getTicketByDate(dateId);
    }

    public boolean getTicketBySeatType(long seatTypeId) {
        return ticketService.getTicketBySeatType(seatTypeId);
    }
}
