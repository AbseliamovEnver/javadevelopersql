package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.TicketDaoImpl;
import com.abseliamov.cinema.model.Ticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TicketService {
    private TicketDaoImpl ticketDao;

    public TicketService(TicketDaoImpl ticketDao) {
        this.ticketDao = ticketDao;
    }

    public boolean getTicketByMovieTitle(String movieTitle) {
        List<Ticket> ticketList = ticketDao.getTicketByMovieTitle(movieTitle);
        return printTicket(ticketList);
    }

    public boolean getTicketByGenre(long genreId) {
        List<Ticket> ticketList = ticketDao.getTicketByGenre(genreId);
        return printTicket(ticketList);
    }

    public boolean getTicketByDateId(long dateId) {
        List<Ticket> ticketList = ticketDao.getTicketByDateId(dateId);
        return printTicket(ticketList);
    }

    public boolean getTicketBySeatType(long seatTypeId) {
        List<Ticket> ticketList = ticketDao.getTicketBySeatType(seatTypeId);
        return printTicket(ticketList);
    }

    public Ticket getById(long ticketId) {
        Ticket ticket = ticketDao.getById(ticketId);
        List<Ticket> list = Arrays.asList(ticket);
        printTicket(list);
        return ticket;
    }

    public Ticket getOrderedTicketById(long ticketId) {
        Ticket ticket = ticketDao.getOrderedTicketById(ticketId);
        List<Ticket> list = Arrays.asList(ticket);
        printTicket(list);
        return ticket;
    }

    public boolean buyTicket(long ticketId) {
        Ticket ticket = ticketDao.getById(ticketId);
        return ticketDao.buyTicket(ticket);
    }

    public boolean deleteTicket(long ticketId) {
        return ticketDao.delete(ticketId);
    }

    public List<Ticket> getAllTicketViewer() {
        List<Ticket> ticketList = ticketDao.getAllTicketViewer();
        printTicket(ticketList);
        return ticketList;
    }

    public boolean returnTicket(long ticketId) {
        Ticket ticket = ticketDao.getOrderedTicketById(ticketId);
        ticketDao.add(ticket);
        return ticketDao.returnTicket(ticket);
    }

    public List<Ticket> getAllTicketByViewerId(long viewerId) {
        List<Ticket> ticketList = ticketDao.getAllTicketByViewerId(viewerId);
        printTicket(ticketList);
        return ticketList;
    }

    public Map<LocalDate, Long> getAllDate() {
        Map<LocalDate, Long> dateMap = new TreeMap<>();
        List<Ticket> ticketList = ticketDao.getAll();
        if (ticketList != null) {
            for (Ticket ticket : ticketList) {
                dateMap.put(ticket.getDateTime().toLocalDate(), ticket.getId());
            }
            printAllDate(dateMap);
        } else {
            System.out.println("Date list is empty.");
        }
        return dateMap;
    }

    public List<Ticket> getAllTicketByDate(long ticketId) {
        List<Ticket> result = null;
        List<Ticket> ticketList = ticketDao.getAll();
        LocalDate date = ticketDao.getById(ticketId).getDateTime().toLocalDate();
        if (ticketList != null) {
            result = ticketList.stream()
                    .filter(ticket -> ticket.getDateTime().toLocalDate().equals(date))
                    .filter(ticket -> ticket.getStatus() == 0)
                    .collect(Collectors.toList());
            printTicket(result);
        }
        return result;
    }

    private void printAllDate(Map<LocalDate, Long> dateList) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter weekdayFormatter = DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ENGLISH);
        System.out.println("\n|------------------------------------|");
        System.out.printf("%-13s%-1s\n", " ", "LIST OF DATE");
        System.out.println("|------------------------------------|");
        System.out.printf("%-3s%-11s%-12s%-1s\n%-1s\n", " ", "ID", "DATE", "WEEKDAY",
                "|-------|-------------|--------------|");
        dateList.forEach((date, ticketId) -> System.out.printf("%-2s%-8s%-15s%-1s\n%-1s\n",
                " ", ticketId, date.format(dateFormatter), date.format(weekdayFormatter).toUpperCase(),
                "|-------|-------------|--------------|"));
    }

    public boolean checkTicketAvailable(long ticketId) {
        boolean ticketAvailable = false;
        Ticket ticket = ticketDao.getById(ticketId);
        if (ticket.getStatus() == 0) {
            ticketAvailable = true;
        } else {
            System.out.println("Ticket with id \'" + ticketId + "\' not available.\n" +
                    "Please try again.");
        }
        return ticketAvailable;
    }

    private boolean printTicket(List<Ticket> ticketList) {
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
