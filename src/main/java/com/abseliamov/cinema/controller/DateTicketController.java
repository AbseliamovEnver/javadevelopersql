package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.DateTicket;
import com.abseliamov.cinema.service.DateTicketSetvice;

import java.util.List;

public class DateTicketController {
    private DateTicketSetvice dateTicketSetvice;

    public DateTicketController(DateTicketSetvice dateTicketSetvice) {
        this.dateTicketSetvice = dateTicketSetvice;
    }

    public List<DateTicket> getAllDate() {
        return dateTicketSetvice.getAllDate();
    }
}
