# Поиск наименее прибыльного фильма за текущий квартал

SELECT movies.id, movies.name, moviePrice.totalPrice FROM (
    SELECT movie_id FROM tickets WHERE (QUARTER(date_time) = QUARTER(CURDATE()))) AS date
RIGHT JOIN (
    SELECT movie_id AS moviePriceId, SUM(price) AS totalPrice FROM tickets WHERE buy_status > 0
        GROUP BY movie_id ORDER BY movie_id DESC LIMIT 1) AS moviePrice
    ON date.movie_id = moviePrice.moviePriceId
INNER JOIN movies
    ON movies.id = moviePrice.moviePriceId LIMIT 1