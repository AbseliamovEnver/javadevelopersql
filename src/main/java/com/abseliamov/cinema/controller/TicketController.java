package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.Ticket;
import com.abseliamov.cinema.service.TicketService;

import java.util.List;

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

    public boolean getTicketByDateId(long dateId) {
        return ticketService.getTicketByDateId(dateId);
    }

    public boolean getTicketBySeatType(long seatTypeId) {
        return ticketService.getTicketBySeatType(seatTypeId);
    }

    public Ticket getById(long ticketId){
        return ticketService.getById(ticketId);
    }

    public boolean buyTicket(long ticketId) {
        return ticketService.buyTicket(ticketId);
    }

    public boolean deleteTicket(long ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    public List<Ticket> getAllTicketViewer() {
        return ticketService.getAllTicketViewer();
    }

    public boolean returnTicket(long ticketId) {
        return ticketService.returnTicket(ticketId);
    }
}
