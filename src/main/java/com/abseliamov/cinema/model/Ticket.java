package com.abseliamov.cinema.model;

import java.time.format.DateTimeFormatter;

public class Ticket extends GenericModel {
    private Movie movie;
    private DateTicket date;
    private TimeTicket time;
    private Seat seat;
    private double price;

    public Ticket(long id, Movie movie, DateTicket date, TimeTicket time, Seat seat, double price) {
        super(id);
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.seat = seat;
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public DateTicket getDate() {
        return date;
    }

    public void setDate(DateTicket date) {
        this.date = date;
    }

    public TimeTicket getTime() {
        return time;
    }

    public void setTime(TimeTicket time) {
        this.time = time;
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
        if (movie != null ? !movie.equals(ticket.movie) : ticket.movie != null) return false;
        if (date != null ? !date.equals(ticket.date) : ticket.date != null) return false;
        if (time != null ? !time.equals(ticket.time) : ticket.time != null) return false;
        return seat != null ? seat.equals(ticket.seat) : ticket.seat == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = movie != null ? movie.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%-2s%-8s%-31s%-20s%-13s%-11s%-16s%-11s%-1s\n%1s",
                " ", getId(), getMovie().getName(), getMovie().getGenre().getName(),
                getDate().getDate().format(dateFormatter), getTime().getTime().format(timeFormatter),
                getSeat().getSeatTypes(), getSeat().getNumber(), getPrice(),
                "|-------|------------------------------|-------------------|------------|----------" +
                        "|-----------|-------------|---------|");
    }
}
