# Поиск зрителей, которые посещают сеанс в период +-3 дня от своего дня рождения

SELECT viewers.id, viewers.firstName, viewers.lastName, viewers.birthday FROM tickets, viewers
    WHERE tickets.date_time >= CURRENT_TIME AND buy_status <> 0
      AND (DAYOFYEAR(date_time) BETWEEN (DAYOFYEAR(birthday) - 3) AND DAYOFYEAR(birthday)
               OR DAYOFYEAR(date_time) BETWEEN DAYOFYEAR(birthday) AND (DAYOFYEAR(birthday) + 3 ));
