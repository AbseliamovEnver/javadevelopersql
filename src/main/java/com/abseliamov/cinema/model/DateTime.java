package com.abseliamov.cinema.model;

import java.time.LocalDateTime;

public class DateTime extends GenericModel{
    private LocalDateTime dateTime;

    public DateTime(long id, LocalDateTime dateTime) {
        super(id);
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateTime dateTime1 = (DateTime) o;

        return dateTime != null ? dateTime.equals(dateTime1.dateTime) : dateTime1.dateTime == null;

    }

    @Override
    public int hashCode() {
        return dateTime != null ? dateTime.hashCode() : 0;
    }
}
