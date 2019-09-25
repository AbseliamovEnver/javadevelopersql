package com.abseliamov.cinema.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket extends GenericModel {
    private String movieName;
    private LocalDateTime dateTime;
    private Seat seat;
    private double price;

    public Ticket(long id, String movieName, LocalDateTime dateTime, Seat seat, double price) {
        super(id);
        this.movieName = movieName;
        this.dateTime = dateTime;
        this.seat = seat;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (Double.compare(ticket.price, price) != 0) return false;
        if (movieName != null ? !movieName.equals(ticket.movieName) : ticket.movieName != null) return false;
        if (dateTime != null ? !dateTime.equals(ticket.dateTime) : ticket.dateTime != null) return false;
        return seat != null ? seat.equals(ticket.seat) : ticket.seat == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = movieName != null ? movieName.hashCode() : 0;
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format("%-2s%-8s%-31s%-22s%-16s%-11s%-1s\n%1s", " ", getId(), getMovieName(),
                getDateTime().format(formatter), getSeat().getSeatTypes(), getSeat().getNumber(), getPrice(),
                "|-------|------------------------------|---------------------|-----------|-------------|---------|");
    }
}
