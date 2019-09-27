package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.DateTicketDaoImpl;
import com.abseliamov.cinema.model.DateTicket;
import com.abseliamov.cinema.model.GenericModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateTicketSetvice {
    private DateTicketDaoImpl dateTicketDao;

    public DateTicketSetvice(DateTicketDaoImpl dateTicketDao) {
        this.dateTicketDao = dateTicketDao;
    }

    public List<DateTicket> getAllDate(){
        List<DateTicket> dates = dateTicketDao.getAll();
        if (!dates.isEmpty()) {
            System.out.println("\n|------------------------------------|");
            System.out.printf("%-13s%-1s\n", " ", "LIST OF DATE");
            System.out.println("|------------------------------------|");
            System.out.printf("%-3s%-11s%-12s%-1s\n", " ", "ID", "DATE", "WEEKDAY");
            System.out.println("|-------|-------------|--------------|");
            dates.stream()
                    .sorted(Comparator.comparing(GenericModel::getId))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        } else {
            System.out.println("Date list is empty.");
        }
        return dates;
    }
}
