package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.TicketDaoImpl;
import com.abseliamov.cinema.model.Ticket;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean getTicketByDateId(long dateId) {
        List<Ticket> ticketList = ticketDao.getTicketByDateId(dateId);
        return printTicketHeader(ticketList);
    }

    public boolean getTicketBySeatType(long seatTypeId) {
        List<Ticket> ticketList = ticketDao.getTicketBySeatType(seatTypeId);
        return printTicketHeader(ticketList);
    }

    public Ticket getById(long ticketId) {
        Ticket ticket = ticketDao.getById(ticketId);
        List<Ticket> list = Collections.singletonList(ticket);
        if (list.isEmpty()) {
            printTicketHeader(list);
        }
        return ticket;
    }

    public boolean buyTicket(long ticketId) {
        Ticket ticket = ticketDao.getById(ticketId);
        return ticketDao.byTicket(ticket);
    }

    public boolean deleteTicket(long ticketId) {
        return ticketDao.delete(ticketId);
    }

    private boolean printTicketHeader(List<Ticket> ticketList) {
        boolean ticketExist = false;
        if (!ticketList.isEmpty()) {
            System.out.println("\n|--------------------------------------------------------------------" +
                    "--------------------------------------------------|");
            System.out.printf("%-55s%-1s\n", " ", "LIST OF TICKETS");
            System.out.println("|----------------------------------------------------------------------" +
                    "------------------------------------------------|");
            System.out.printf("%-3s%-15s%-29s%-17s%-12s%-9s%-12s%-15s%-1s\n",
                    " ", "ID", "MOVIE TITLE", "GENRE", "DATE", "TIME", "SEAT TYPE", "SEAT NUMBER", "PRICE");
            System.out.println("|-------|------------------------------|-------------------|------------|----------" +
                    "|-----------|-------------|---------|");
            ticketList.stream()
                    .sorted(Comparator.comparing(Ticket::getId))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
            ticketExist = true;
        } else {
            System.out.println("At your request tickets available is not found");
        }
        return ticketExist;
    }
}
