INSERT INTO genres (name) VALUES
('Detective'),
('Western'),
('Drama'),
('Adventure');
# ('Thriller'),
# ('Horror'),
# ('Comedy'),
# ('Action'),
# ('Crime'),
# ('Historical'),
# ('Musical'),
# ('Science'),
# ('War'),
# ('Fantasy'),
# ('Animated'),
# ('Sport'),
# ('Biographical');

INSERT INTO movies(name, genre_id, cost) VALUES
('Red Dragon', 1, 1000.0),
('The Illusionist', 1, 2500.0),
('Sherlock Holmes', 1, 5620.0),
('Contratiempo', 1, 2563.0),
('Fracture', 1, 4521.0),
('The Hateful Eight', 2, 5847.0),
('Good, Bad and Ugly', 2, 6582.0),
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
('Vertical Limit', 4, 963.0),
('North Face', 4, 369.0);
# ('The Jackal', 5, 147.0),
# ('The Prestige', 5, 741.0),
# ('Zodiac', 5, 159.0),
# ('Mystic River', 5, 951.0),
# ('Equilibrium', 5, 357.0),
# ('Eden Lake', 6, 753.0),
# ('Black Rock', 6, 759.0),
# ('Get Out', 6, 957.0),
# ('The Call', 6, 153.0),
# ('Frozen', 6, 351.0),
# ('1+1', 7, 456.0),
# ('12 chairs', 7, 654.0),
# ('Golden calf', 7, 259.0),
# ('Business people', 7, 752.0),
# ('Bluff', 7, 1526.0);

INSERT INTO seat_types(type) VALUES
('VIP'),
('Standard');

INSERT INTO seats(seat_type_id, number) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3);

INSERT INTO roles(role) VALUES
('ADMIN'),
('USER');

INSERT INTO viewers(firstName, lastName, password, role_id, birthday) VALUES
('123', 'Ivanov', '123', 1, STR_TO_DATE('01-02-2019', '%d-%m-%Y')),
('root', 'Petrov', 'root', 1, STR_TO_DATE('02-03-2000', '%d-%m-%Y')),
('admin', 'Sidorov', 'admin', 1, STR_TO_DATE('01-01-1970', '%d-%m-%Y'));

INSERT INTO tickets(date_time, movie_id, seat_id, price, buy_status) VALUES
(STR_TO_DATE('03-11-2019 09:00:00', '%d-%m-%Y %H:%i:%s'), 1, 1, 5.5, 0),
(STR_TO_DATE('03-11-2019 09:00:00', '%d-%m-%Y %H:%i:%s'), 1, 2, 5.5, 0),
(STR_TO_DATE('03-11-2019 09:00:00', '%d-%m-%Y %H:%i:%s'), 1, 3, 5.5, 0),
(STR_TO_DATE('03-11-2019 09:00:00', '%d-%m-%Y %H:%i:%s'), 1, 4, 3.5, 0),
(STR_TO_DATE('03-11-2019 09:00:00', '%d-%m-%Y %H:%i:%s'), 1, 5, 3.5, 0),
(STR_TO_DATE('03-11-2019 09:00:00', '%d-%m-%Y %H:%i:%s'), 1, 6, 3.5, 0),

(STR_TO_DATE('03-11-2019 11:00:00', '%d-%m-%Y %H:%i:%s'), 2, 1, 6.0, 0),
(STR_TO_DATE('03-11-2019 11:00:00', '%d-%m-%Y %H:%i:%s'), 2, 2, 6.0, 0),
(STR_TO_DATE('03-11-2019 11:00:00', '%d-%m-%Y %H:%i:%s'), 2, 3, 6.0, 0),
(STR_TO_DATE('03-11-2019 11:00:00', '%d-%m-%Y %H:%i:%s'), 2, 4, 4.0, 0),
(STR_TO_DATE('03-11-2019 11:00:00', '%d-%m-%Y %H:%i:%s'), 2, 5, 4.0, 0),
(STR_TO_DATE('03-11-2019 11:00:00', '%d-%m-%Y %H:%i:%s'), 2, 6, 4.0, 0),

(STR_TO_DATE('04-11-2019 13:00:00', '%d-%m-%Y %H:%i:%s'), 3, 3, 4.0, 0),
(STR_TO_DATE('05-11-2019 15:00:00', '%d-%m-%Y %H:%i:%s'), 4, 4, 3.5, 0),
(STR_TO_DATE('06-11-2019 17:00:00', '%d-%m-%Y %H:%i:%s'), 5, 5, 3.5, 0),
(STR_TO_DATE('07-11-2019 19:00:00', '%d-%m-%Y %H:%i:%s'), 6, 6, 3.5, 0),

(STR_TO_DATE('08-11-2019 09:00:00', '%d-%m-%Y %H:%i:%s'), 3, 1, 5.5, 0),
(STR_TO_DATE('04-11-2019 11:00:00', '%d-%m-%Y %H:%i:%s'), 4, 2, 5.5, 0),
(STR_TO_DATE('04-11-2019 13:00:00', '%d-%m-%Y %H:%i:%s'), 5, 3, 5.5, 0),
(STR_TO_DATE('04-11-2019 15:00:00', '%d-%m-%Y %H:%i:%s'), 6, 4, 3.5, 0),
(STR_TO_DATE('04-11-2019 17:00:00', '%d-%m-%Y %H:%i:%s'), 2, 5, 3.5, 0),
(STR_TO_DATE('04-11-2019 19:00:00', '%d-%m-%Y %H:%i:%s'), 4, 6, 3.5, 0);