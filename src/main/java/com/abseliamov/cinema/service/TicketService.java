package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.TicketDaoImpl;
import com.abseliamov.cinema.model.Ticket;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private TicketDaoImpl ticketDao;
    private DateTimeService dateTimeService;

    public TicketService(TicketDaoImpl ticketDao, DateTimeService dateTimeService) {
        this.ticketDao = ticketDao;
        this.dateTimeService = dateTimeService;
    }

    public boolean getTicketByMovieTitle(String movieTitle) {
        List<Ticket> ticketList = ticketDao.getTicketByMovieTitle(movieTitle);
        return printTicketHeader(ticketList);
    }

    public boolean getTicketByGenre(long genreId) {
        List<Ticket> ticketList = ticketDao.getTicketByGenre(genreId);
        return printTicketHeader(ticketList);
    }

    public boolean getTicketByDate(long dateId) {
        LocalDate date = dateTimeService.getDateByDateId(dateId);
        List<Ticket> ticketList = ticketDao.getTicketByDate(date);
        return printTicketHeader(ticketList);
    }

    public boolean getTicketBySeatType(long seatTypeId) {
        List<Ticket> ticketList = ticketDao.getTicketBySeatType(seatTypeId);
        return printTicketHeader(ticketList);
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
