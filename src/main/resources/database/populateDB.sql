INSERT INTO genres (name) VALUES
('Detective'),
('Western'),
('Drama'),
('Adventure'),
('Thriller'),
('Horror'),
('Comedy'),
('Action'),
('Crime'),
('Historical'),
('Musical'),
('Science'),
('War'),
('Fantasy'),
('Animated'),
('Sport'),
('Biographical');

INSERT INTO movies(name, genre_id, cost) VALUES
('Red Dragon', 1, 1000.0),
('The Illusionist', 1, 2500.0),
('Sherlock Holmes', 1, 5620.0),
('Contratiempo', 1, 2563.0),
('Fracture', 1, 4521.0),
('The Hateful Eight', 2, 5847.0),
('The Good, the Bad and the Ugly', 2, 6582.0),
('Unforgiven', 2, 9657.0),
('The Quick and the Dead', 2, 4512.0),
('Django Unchained', 2, 6354.0),
('The Edge', 3, 123.0),
('Gladiator', 3, 321.0),
('The Patriot', 3, 256.0),
('Troy', 3, 2563.2),
('The Devil''s Advocate', 3, 452.0),
('127 Hours', 4, 248.0),
('Everest', 4, 789.0),
('Everest', 4, 987.0),
('Vertical Limit', 4, 963.0),
('North Face', 4, 369.0),
('The Jackal', 5, 147.0),
('The Prestige', 5, 741.0),
('Zodiac', 5, 159.0),
('Mystic River', 5, 951.0),
('Equilibrium', 5, 357.0),
('Eden Lake', 6, 753.0),
('Black Rock', 6, 759.0),
('Get Out', 6, 957.0),
('The Call', 6, 153.0),
('Frozen', 6, 351.0),
('1+1', 7, 456.0),
('12 chairs', 7, 654.0),
('Golden calf', 7, 259.0),
('Business people', 7, 752.0),
('Bluff', 7, 1526.0);

INSERT INTO seat_types(type) VALUES
('VIP'),
('Standard');

INSERT INTO seats(seat_type_id, number) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5);

INSERT INTO roles(role) VALUES
('ADMIN'),
('USER');

INSERT INTO viewers(firstName, lastName, password, role_id, birthday) VALUES
('123', 'Ivanov', '123', 1, STR_TO_DATE('01-02-2019', '%d-%m-%Y')),
('root', 'Petrov', 'root', 1, STR_TO_DATE('02-03-2000', '%d-%m-%Y')),
('admin', 'Sidorov', 'admin', 1, STR_TO_DATE('01-01-1970', '%d-%m-%Y'));

INSERT INTO dates (date_ticket) VALUES
(STR_TO_DATE('01-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('02-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('03-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('04-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('05-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('06-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('07-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('08-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('09-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('10-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('11-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('12-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('13-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('14-10-2019', '%d-%m-%Y')),
(STR_TO_DATE('15-10-2019', '%d-%m-%Y'));

INSERT INTO times (time_ticket) VALUES
(STR_TO_DATE('09:00:00', '%H:%i:%s')),
(STR_TO_DATE('11:00:00', '%H:%i:%s')),
(STR_TO_DATE('13:00:00', '%H:%i:%s')),
(STR_TO_DATE('17:00:00', '%H:%i:%s')),
(STR_TO_DATE('19:00:00', '%H:%i:%s')),
(STR_TO_DATE('21:00:00', '%H:%i:%s'));

INSERT INTO tickets(movie_id, date_id, time_id, seat_id, price) VALUES
(1, 1, 1, 1, 5.5),
(1, 1, 2, 2, 5.5),
(1, 1, 3, 3, 5.5),
(1, 1, 4, 4, 5.5),
(1, 1, 5, 5, 5.5),
(1, 1, 6, 6, 3.5),
(1, 1, 1, 7, 3.5),
(1, 1, 2, 8, 3.5),
(1, 1, 3, 9, 3.5),
(1, 1, 4, 10, 3.5),

(2, 2, 5, 1, 4.5),
(2, 2, 6, 2, 4.5),
(2, 2, 1, 3, 4.5),
(2, 2, 2, 4, 4.5),
(2, 2, 3, 5, 4.5),
(2, 2, 4, 6, 2.5),
(2, 2, 5, 7, 2.5),
(2, 2, 6, 8, 2.5),
(2, 2, 1, 9, 2.5),
(2, 2, 2, 10, 2.5),

(3, 3, 3, 1, 3.5),
(4, 4, 4, 2, 3.5),
(5, 5, 5, 3, 3.5),
(6, 6, 6, 4, 3.5),
(7, 7, 1, 5, 3.5),
(8, 8, 2, 6, 2.0),
(9, 9, 3, 7, 2.0),
(10, 10, 4, 8, 2.0),
(11, 11, 5, 9, 2.0),
(12, 12, 6, 10, 2.0),

(13, 13, 1, 1, 2.5),
(14, 14, 2, 2, 2.5),
(15, 15, 3, 3, 2.5),
(16, 1, 4, 4, 2.5),
(17, 2, 5, 5, 2.5),
(18, 3, 6, 6, 1.0),
(19, 4, 1, 7, 1.0),
(20, 5, 2, 8, 1.0),
(21, 6, 3, 9, 1.0),
(22, 7, 4, 10, 1.0);

INSERT INTO viewers_movies(viewer_id, movie_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 3),
(3, 1),
(3, 3);

