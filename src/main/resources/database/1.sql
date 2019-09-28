# select of dates in the current quarter
SELECT * FROM dates WHERE QUARTER(date_ticket) > QUARTER(CURDATE());

# select date_id dates in the current quarter
SELECT id FROM dates WHERE QUARTER(date_ticket) > QUARTER(CURDATE());

# select highest grossing movie of all time
SELECT * FROM movies WHERE cost = (SELECT MAX(cost) FROM movies);

# select movie_id highest grossing movie of all time
SELECT id FROM movies WHERE cost = (SELECT MAX(cost) FROM movies);

SELECT * FROM purchased_tickets WHERE movie_id IN (
    SELECT movie_id, SUM(price) FROM purchased_tickets WHERE movie_id IN (
        SELECT movie_id, price FROM purchased_tickets WHERE date_id IN (
            SELECT id FROM dates WHERE QUARTER(date_ticket) = QUARTER(CURDATE())
        )
    ) GROUP BY movie_id);

    SELECT * FROM purchased_tickets WHERE date_id IN (
        SELECT id FROM dates WHERE QUARTER(date_ticket) = QUARTER(CURDATE())) GROUP BY date_id;