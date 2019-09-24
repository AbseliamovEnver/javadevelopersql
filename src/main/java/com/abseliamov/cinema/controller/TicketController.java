package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void getTicketByMovieTitle(String movieTitle) {
        ticketService.getTicketByMovieTitle(movieTitle);
    }
}
