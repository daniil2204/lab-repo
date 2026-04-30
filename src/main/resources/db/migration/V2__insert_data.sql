INSERT INTO city (city_id, display_name) VALUES
('c1', 'Kyiv'),
('c2', 'Lviv'),
('c3', 'Odesa'),
('c4', 'Kharkiv');

INSERT INTO user_profile (user_profile_id, first_name, last_name, username, password) VALUES
('u1', 'Ivan', 'Petrenko', 'ipetrenko', 'pass123'),
('u2', 'Olena', 'Shevchenko', 'oshevchenko', 'pass456'),
('u3', 'Dmytro', 'Kovalenko', 'dkovalenko', 'pass789');

INSERT INTO flight (flight_id, departure_city_id, arrival_city_id, departure_time, arrival_time, flight_number, price) VALUES
('f1', 'c1', 'c2', '2025-06-01 08:00:00+03', '2025-06-01 09:30:00+03', 'UA101', '1500'),
('f2', 'c2', 'c3', '2025-06-02 12:00:00+03', '2025-06-02 14:00:00+03', 'UA202', '2000'),
('f3', 'c3', 'c4', '2025-06-03 16:00:00+03', '2025-06-03 18:00:00+03', 'UA303', '1800');

INSERT INTO ticket (ticket_id, flight_id, user_profile_id, pnr) VALUES
('t1', 'f1', 'u1', 'PNR001'),
('t2', 'f2', 'u2', 'PNR002'),
('t3', 'f3', 'u3', 'PNR003');
