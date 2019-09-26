package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.DateTimeDaoImpl;
import com.abseliamov.cinema.model.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTimeService {
    private DateTimeDaoImpl dateTimeDao;

    public DateTimeService(DateTimeDaoImpl dateTimeDao) {
        this.dateTimeDao = dateTimeDao;
    }

    public List<DateTime> getAll() {
        List<DateTime> dateTimes = dateTimeDao.getAll();
        return dateTimes;
    }

    public Map<LocalDate, Long> getAllDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter weekdayFormatter = DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ENGLISH);
        List<DateTime> timeList = dateTimeDao.getAll();
        Map<LocalDate, Long> dates = new TreeMap<>();
        for (DateTime dateTime: timeList){
            dates.put(LocalDate.from(dateTime.getDate()), dateTime.getId());
        }
        if (!dates.isEmpty()) {
            System.out.println("\n|------------------------------------|");
            System.out.printf("%-13s%-1s\n", " ", "LIST OF DATE");
            System.out.println("|------------------------------------|");
            System.out.printf("%-3s%-11s%-12s%-1s\n", " ", "ID", "DATE", "WEEKDAY");
            System.out.println("|-------|-------------|--------------|");
            dates.forEach((data, id) -> System.out.printf("%-2s%-8s%-15s%-1s\n%-1s\n",
                    " ", id, data.format(dateFormatter), data.format(weekdayFormatter).toUpperCase(),
                    "|-------|-------------|--------------|"));
        } else {
            System.out.println("Date list is empty.");
        }
        return dates;
    }

    public LocalDate getDateByDateId(long dateId){
        List<DateTime> dateTimes = dateTimeDao.getAll();
        return dateTimes.stream().filter(dateTime -> dateTime.getId() == dateId)
                .findFirst().get().getDate();
    }
}
