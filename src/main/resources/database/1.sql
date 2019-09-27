SELECT *
FROM movies
WHERE cost = (SELECT MAX(cost) FROM movies);

SELECT * FROM movies WHERE cost = MAX(cost);