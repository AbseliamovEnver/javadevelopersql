package com.abseliamov.cinema.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTime extends GenericModel {
    private LocalDate date;
    private LocalTime time;

    public DateTime(long id, LocalDate date, LocalTime time) {
        super(id);
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateTime dateTime = (DateTime) o;

        if (date != null ? !date.equals(dateTime.date) : dateTime.date != null) return false;
        return time != null ? time.equals(dateTime.time) : dateTime.time == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("hh-mm-ss");
        return String.format("%-2s%-8s%-12s%-1s\n%1s",
                " ", getId(), getDate().format(formatterDate), getTime().format(formatterTime),
                "|-------|-------------|");
    }
}
