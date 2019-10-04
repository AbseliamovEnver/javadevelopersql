# Поиск дат, в которые более, чем у 5 зрителей день рождения

SELECT *, COUNT(*), DATE_FORMAT(birthday, '%m-%d') AS date_month FROM viewers
    GROUP BY date_month HAVING COUNT(date_month) > 5