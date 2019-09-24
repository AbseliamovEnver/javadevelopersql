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

INSERT INTO movies(name, genre_id) VALUES
('Red Dragon', 1),
('The Illusionist', 1),
('Sherlock Holmes', 1),
('Contratiempo', 1),
('Fracture', 1),
('The Hateful Eight', 2),
('The Good, the Bad and the Ugly', 2),
('Unforgiven', 2),
('The Quick and the Dead', 2),
('Django Unchained', 2),
('The Edge', 3),
('Gladiator', 3),
('The Patriot', 3),
('Troy', 3),
('The Devil''s Advocate', 3),
('127 Hours', 4),
('Everest', 4),
('Everest', 4),
('Vertical Limit', 4),
('North Face', 4),
('The Jackal', 5),
('The Prestige', 5),
('Zodiac', 5),
('Mystic River', 5),
('Equilibrium', 5),
('Eden Lake', 6),
('Black Rock', 6),
('Get Out', 6),
('The Call', 6),
('Frozen', 6),
('1+1', 7),
('12 chairs', 7),
('Golden calf', 7),
('Business people', 7),
('Bluff', 7);

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

INSERT INTO date_times(date_time) VALUES
(STR_TO_DATE('01-10-2019 09:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('01-10-2019 11:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('01-10-2019 13:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('01-10-2019 15:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('01-10-2019 17:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('01-10-2019 19:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('01-10-2019 21:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('01-10-2019 23:00:00', '%d-%m-%Y %H:%i:%s')),

(STR_TO_DATE('02-10-2019 09:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('02-10-2019 11:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('02-10-2019 13:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('02-10-2019 15:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('02-10-2019 17:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('02-10-2019 19:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('02-10-2019 21:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('02-10-2019 23:00:00', '%d-%m-%Y %H:%i:%s')),

(STR_TO_DATE('03-10-2019 09:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('03-10-2019 11:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('03-10-2019 13:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('03-10-2019 15:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('03-10-2019 17:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('03-10-2019 19:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('03-10-2019 21:00:00', '%d-%m-%Y %H:%i:%s')),
(STR_TO_DATE('03-10-2019 23:00:00', '%d-%m-%Y %H:%i:%s'));

INSERT INTO tickets(movie_id, date_time_id, seat_id, price) VALUES
(1, 1, 1, 5.5),
(1, 1, 2, 5.5),
(1, 1, 3, 5.5),
(1, 1, 4, 5.5),
(1, 1, 5, 5.5),
(1, 1, 6, 3.5),
(1, 1, 7, 3.5),
(1, 1, 8, 3.5),
(1, 1, 9, 3.5),
(1, 1, 10, 3.5),

(2, 2, 1, 4.5),
(2, 2, 2, 4.5),
(2, 2, 3, 4.5),
(2, 2, 4, 4.5),
(2, 2, 5, 4.5),
(2, 2, 6, 2.5),
(2, 2, 7, 2.5),
(2, 2, 8, 2.5),
(2, 2, 9, 2.5),
(2, 2, 10, 2.5),

(3, 3, 1, 3.5),
(3, 3, 2, 3.5),
(3, 3, 3, 3.5),
(3, 3, 4, 3.5),
(3, 3, 5, 3.5),
(3, 3, 6, 2.0),
(3, 3, 7, 2.0),
(3, 3, 8, 2.0),
(3, 3, 9, 2.0),
(3, 3, 10, 2.0);

INSERT INTO viewers_movies(viewer_id, movie_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 3),
(3, 1),
(3, 3);
