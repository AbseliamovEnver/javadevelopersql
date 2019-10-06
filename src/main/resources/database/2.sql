# Поиск наименее прибыльного фильма за текущий квартал

SELECT movies.id, movies.name, movie_price.total_price FROM (
    SELECT movie_id FROM tickets WHERE (QUARTER(date_time) = QUARTER(CURDATE()))) AS date
RIGHT JOIN (
    SELECT movie_id AS movie_price_id, SUM(price) AS total_price FROM tickets WHERE buy_status > 0
        GROUP BY movie_id ORDER BY total_price LIMIT 1) AS movie_price
    ON date.movie_id = movie_price.movie_price_id
INNER JOIN movies
    ON movies.id = movie_price.movie_price_id LIMIT 1