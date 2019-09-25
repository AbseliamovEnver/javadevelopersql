package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.TicketDaoImpl;
import com.abseliamov.cinema.model.Ticket;

import java.util.List;

public class TicketService {
    private TicketDaoImpl ticketDao;

    public TicketService(TicketDaoImpl ticketDao) {
        this.ticketDao = ticketDao;
    }

    public boolean getTicketByMovieTitle(String movieTitle) {
        List<Ticket> ticketList = ticketDao.getTicketByMovieTitle(movieTitle);
        return printTicketHeader(ticketList);
    }

    public boolean getTicketByGenre(long genreId) {
        List<Ticket> ticketList = ticketDao.getTicketByGenre(genreId);
        return printTicketHeader(ticketList);
    }

    private boolean printTicketHeader(List<Ticket> ticketList) {
        boolean ticketExist = false;
        if (!ticketList.isEmpty()) {
            System.out.println("\n|--------------------------------------------------------------------" +
                    "------------------------------------------------|");
            System.out.printf("%-50s%-1s\n", " ", "LIST OF TICKETS");
            System.out.println("|----------------------------------------------------------------------" +
                    "----------------------------------------------|");
            System.out.printf("%-3s%-15s%-29s%-22s%-14s%-12s%-15s%-1s\n",
                    " ", "ID", "MOVIE TITLE", "GENRE", "DATE", "SEAT TYPE", "SEAT NUMBER", "PRICE");
            System.out.println("|-------|------------------------------|-------------------|---------------------" +
                    "|-----------|-------------|---------|");
            ticketList.forEach(System.out::println);
            ticketExist = true;
        } else {
            System.out.println("At your request tickets available is not found");
        }
        return ticketExist;
    }
}
