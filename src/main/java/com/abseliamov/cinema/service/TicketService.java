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
        boolean ticketExist = false;
        List<Ticket> ticketList = ticketDao.getTicketByMovieTitle(movieTitle);
        if (ticketList.isEmpty()) {
            System.out.println("At your request \'" + movieTitle + "\' tickets available is not found");
        } else {
            System.out.println("\n|--------------------------------------------------------------------" +
                    "----------------------------|");
            System.out.printf("%-40s%-1s\n", " ", "LIST OF TICKETS");
            System.out.println("|----------------------------------------------------------------------" +
                    "--------------------------|");
            System.out.printf("%-3s%-15s%-31s%-14s%-12s%-15s%-1s\n",
                    " ", "ID", "MOVIE TITLE", "DATE", "SEAT TYPE", "SEAT NUMBER", "PRICE");
            System.out.println("|-------|------------------------------|---------------------|---------" +
                    "--|-------------|---------|");
            ticketList.forEach(System.out::println);
            ticketExist = true;
        }
        return ticketExist;
    }
}
