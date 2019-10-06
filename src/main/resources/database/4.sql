# Поиск зрителей, которые посещают сеанс в период +-3 дня от своего дня рождения

SELECT viewers.id, viewers.first_name, viewers.last_name, viewers.birthday
FROM viewers
INNER JOIN tickets ON viewers.id = tickets.buy_status
    AND date_time >= CURRENT_TIME AND buy_status <> 0
    AND (DAYOFYEAR(date_time) BETWEEN (DAYOFYEAR(birthday) - 3) AND DAYOFYEAR(birthday)
        OR DAYOFYEAR(date_time) BETWEEN DAYOFYEAR(birthday) AND (DAYOFYEAR(birthday) + 3 ))