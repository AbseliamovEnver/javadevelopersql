# Поиск зрителя, который посетил более 10 фильмов в текущем квартале по указанному жанру

SELECT viewers.id, viewers.firstName, viewers.lastName, COUNT(buy_status) FROM (
    SELECT buy_status FROM tickets WHERE (QUARTER(date_time) = QUARTER(CURDATE()))
        AND movie_id IN (SELECT id FROM movies WHERE  genre_id = ?)
        AND buy_status <> 0
    GROUP BY buy_status HAVING COUNT(buy_status) > 6) AS filter
INNER JOIN viewers
    ON viewers.id = filter.buy_status;
