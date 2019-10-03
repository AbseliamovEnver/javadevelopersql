# Поиск зрителей, купивших билеты на указанный жанр, на сумму, больше указанной в запросе, в указанный период времени

SELECT viewers.id, viewers.firstName, viewers.lastName, viewers.birthday FROM (
    SELECT buy_status FROM tickets WHERE movie_id IN (SELECT id FROM movies WHERE  genre_id = ?)
        AND buy_status <> 0
        AND date_time BETWEEN ? AND ?
    GROUP BY buy_status HAVING SUM(price) > ?) AS filter
INNER JOIN viewers
    ON viewers.id = filter.buy_status;