-- BookMyShow test data
-- Inserts 10 dummy records for each persistent entity table in the current project.
-- Assumes a fresh/empty BookMyShow database and the default Hibernate snake_case naming.
-- Ticket is NOT included because Ticket is not annotated with @Entity.
-- Run after Hibernate has created the schema.

SET FOREIGN_KEY_CHECKS = 0;

-- =========================================================
-- 1. REGION
-- =========================================================
INSERT INTO region (id, created_at, updated_at, name) VALUES
(1, NOW(), NOW(), 'Bengaluru'),
(2, NOW(), NOW(), 'Mumbai'),
(3, NOW(), NOW(), 'Delhi'),
(4, NOW(), NOW(), 'Hyderabad'),
(5, NOW(), NOW(), 'Chennai'),
(6, NOW(), NOW(), 'Pune'),
(7, NOW(), NOW(), 'Kolkata'),
(8, NOW(), NOW(), 'Ahmedabad'),
(9, NOW(), NOW(), 'Jaipur'),
(10, NOW(), NOW(), 'Kochi');

-- =========================================================
-- 2. THEATRE
-- =========================================================
INSERT INTO theatre (id, created_at, updated_at, name, region_id) VALUES
(1, NOW(), NOW(), 'PVR Orion Mall', 1),
(2, NOW(), NOW(), 'INOX Garuda Mall', 1),
(3, NOW(), NOW(), 'PVR Phoenix Mall', 2),
(4, NOW(), NOW(), 'Cinepolis Andheri', 2),
(5, NOW(), NOW(), 'PVR Select Citywalk', 3),
(6, NOW(), NOW(), 'AMB Cinemas', 4),
(7, NOW(), NOW(), 'PVR VR Chennai', 5),
(8, NOW(), NOW(), 'INOX Amanora', 6),
(9, NOW(), NOW(), 'INOX Quest Mall', 7),
(10, NOW(), NOW(), 'PVR Lulu Mall', 10);

-- =========================================================
-- 3. SEAT TYPE
-- =========================================================
INSERT INTO seat_type (id, created_at, updated_at, name) VALUES
(1, NOW(), NOW(), 'Silver'),
(2, NOW(), NOW(), 'Gold'),
(3, NOW(), NOW(), 'Platinum'),
(4, NOW(), NOW(), 'Recliner'),
(5, NOW(), NOW(), 'Premium'),
(6, NOW(), NOW(), 'Executive'),
(7, NOW(), NOW(), 'Economy'),
(8, NOW(), NOW(), 'Couple'),
(9, NOW(), NOW(), 'VIP'),
(10, NOW(), NOW(), 'Wheelchair');

-- =========================================================
-- 4. SEAT
-- =========================================================
INSERT INTO seat (id, created_at, updated_at, seat_number, row_val, col_val, seat_type_id) VALUES
(1, NOW(), NOW(), 'A1', 1, 1, 1),
(2, NOW(), NOW(), 'A2', 1, 2, 1),
(3, NOW(), NOW(), 'A3', 1, 3, 1),
(4, NOW(), NOW(), 'B1', 2, 1, 2),
(5, NOW(), NOW(), 'B2', 2, 2, 2),
(6, NOW(), NOW(), 'B3', 2, 3, 2),
(7, NOW(), NOW(), 'C1', 3, 1, 3),
(8, NOW(), NOW(), 'C2', 3, 2, 3),
(9, NOW(), NOW(), 'C3', 3, 3, 4),
(10, NOW(), NOW(), 'C4', 3, 4, 4);

-- =========================================================
-- 5. SCREEN
-- screen.status is an enum without @Enumerated, so Hibernate
-- stores its ordinal: ACTIVE=0, INACTIVE=1, OPERATIONAL=2,
-- UNDER_MAINTENANCE=3.
-- =========================================================
INSERT INTO screen (id, created_at, updated_at, name, status, theatre_id) VALUES
(1, NOW(), NOW(), 'Screen 1', 0, 1),
(2, NOW(), NOW(), 'Screen 2', 2, 1),
(3, NOW(), NOW(), 'Screen 1', 0, 2),
(4, NOW(), NOW(), 'Screen 2', 2, 2),
(5, NOW(), NOW(), 'Screen 1', 0, 3),
(6, NOW(), NOW(), 'Screen 2', 2, 4),
(7, NOW(), NOW(), 'Screen 1', 0, 5),
(8, NOW(), NOW(), 'Screen 1', 2, 6),
(9, NOW(), NOW(), 'Screen 1', 0, 7),
(10, NOW(), NOW(), 'Screen 1', 2, 10);

-- Screen <-> Seat many-to-many
INSERT INTO screen_seats (screen_id, seats_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- =========================================================
-- 6. MOVIE
-- =========================================================
INSERT INTO movies
(id, created_at, updated_at, name, director, description, duration_in_minutes, language, genre)
VALUES
(1, NOW(), NOW(), 'Inception', 'Christopher Nolan', 'A thief enters dreams to steal secrets.', 148, 'English', 'Sci-Fi'),
(2, NOW(), NOW(), 'Interstellar', 'Christopher Nolan', 'Explorers travel through a wormhole in space.', 169, 'English', 'Sci-Fi'),
(3, NOW(), NOW(), 'The Dark Knight', 'Christopher Nolan', 'Batman faces a criminal mastermind in Gotham.', 152, 'English', 'Action'),
(4, NOW(), NOW(), 'RRR', 'S. S. Rajamouli', 'Two revolutionaries form an unlikely friendship.', 182, 'Telugu', 'Action'),
(5, NOW(), NOW(), 'Kantara', 'Rishab Shetty', 'A village story rooted in folklore and tradition.', 148, 'Kannada', 'Drama'),
(6, NOW(), NOW(), 'Jawan', 'Atlee', 'A man sets out to correct social wrongs.', 169, 'Hindi', 'Action'),
(7, NOW(), NOW(), 'Dangal', 'Nitesh Tiwari', 'A father trains his daughters to become wrestlers.', 161, 'Hindi', 'Sports'),
(8, NOW(), NOW(), 'Drishyam', 'Jeethu Joseph', 'A family tries to protect itself after an incident.', 163, 'Hindi', 'Thriller'),
(9, NOW(), NOW(), 'KGF Chapter 1', 'Prashanth Neel', 'A man rises through the brutal gold-mining underworld.', 156, 'Kannada', 'Action'),
(10, NOW(), NOW(), '3 Idiots', 'Rajkumar Hirani', 'Three friends navigate college and life.', 170, 'Hindi', 'Comedy');

-- Movie cast element collection
INSERT INTO movies_cast (movies_id, cast) VALUES
(1, 'Leonardo DiCaprio'),
(2, 'Matthew McConaughey'),
(3, 'Christian Bale'),
(4, 'N. T. Rama Rao Jr.'),
(5, 'Rishab Shetty'),
(6, 'Shah Rukh Khan'),
(7, 'Aamir Khan'),
(8, 'Ajay Devgn'),
(9, 'Yash'),
(10, 'Aamir Khan');

-- Movie features element collection.
-- Feature enum is stored as ordinal because @Enumerated is not specified:
-- TWO_D=0, THREE_D=1, DOLBY_ATMOS=2, IMAX=3, LASER=4.
INSERT INTO movies_features (movies_id, features) VALUES
(1, 3),
(2, 3),
(3, 0),
(4, 1),
(5, 0),
(6, 1),
(7, 0),
(8, 0),
(9, 1),
(10, 0);

-- =========================================================
-- 7. SHOW
-- =========================================================
INSERT INTO shows
(id, created_at, updated_at, movie_id, start_time, end_time, screen_id)
VALUES
(1, NOW(), NOW(), 1, '2026-09-21 10:00:00', '2026-09-21 12:28:00', 1),
(2, NOW(), NOW(), 2, '2026-09-21 13:00:00', '2026-09-21 15:49:00', 2),
(3, NOW(), NOW(), 3, '2026-09-21 16:00:00', '2026-09-21 18:32:00', 3),
(4, NOW(), NOW(), 4, '2026-09-21 18:00:00', '2026-09-21 21:02:00', 4),
(5, NOW(), NOW(), 5, '2026-09-21 19:00:00', '2026-09-21 21:28:00', 5),
(6, NOW(), NOW(), 6, '2026-09-22 10:00:00', '2026-09-22 12:49:00', 6),
(7, NOW(), NOW(), 7, '2026-09-22 13:00:00', '2026-09-22 15:41:00', 7),
(8, NOW(), NOW(), 8, '2026-09-22 16:00:00', '2026-09-22 18:43:00', 8),
(9, NOW(), NOW(), 9, '2026-09-22 18:00:00', '2026-09-22 20:36:00', 9),
(10, NOW(), NOW(), 10, '2026-09-22 20:00:00', '2026-09-22 22:50:00', 10);

-- =========================================================
-- 8. SHOW SEAT
-- Seat status is stored as STRING because @Enumerated(STRING).
-- =========================================================
INSERT INTO show_seat
(id, created_at, updated_at, show_id, seat_id, status, blocked_at)
VALUES
(1, NOW(), NOW(), 1, 1, 'AVAILABLE', NULL),
(2, NOW(), NOW(), 2, 2, 'AVAILABLE', NULL),
(3, NOW(), NOW(), 3, 3, 'BOOKED', NULL),
(4, NOW(), NOW(), 4, 4, 'AVAILABLE', NULL),
(5, NOW(), NOW(), 5, 5, 'BLOCKED', NOW()),
(6, NOW(), NOW(), 6, 6, 'AVAILABLE', NULL),
(7, NOW(), NOW(), 7, 7, 'BOOKED', NULL),
(8, NOW(), NOW(), 8, 8, 'AVAILABLE', NULL),
(9, NOW(), NOW(), 9, 9, 'AVAILABLE', NULL),
(10, NOW(), NOW(), 10, 10, 'BLOCKED', NOW());

-- =========================================================
-- 9. SHOW SEAT TYPE
-- =========================================================
INSERT INTO show_seat_type
(id, created_at, updated_at, show_id, seat_type_id, price_multiplier)
VALUES
(1, NOW(), NOW(), 1, 1, 1.00),
(2, NOW(), NOW(), 2, 2, 1.25),
(3, NOW(), NOW(), 3, 3, 1.50),
(4, NOW(), NOW(), 4, 4, 2.00),
(5, NOW(), NOW(), 5, 5, 1.40),
(6, NOW(), NOW(), 6, 6, 1.30),
(7, NOW(), NOW(), 7, 7, 1.00),
(8, NOW(), NOW(), 8, 8, 1.75),
(9, NOW(), NOW(), 9, 9, 2.50),
(10, NOW(), NOW(), 10, 10, 0.80);

-- =========================================================
-- 10. USER
-- =========================================================
INSERT INTO users
(id, created_at, updated_at, name, email, mobile_no, password, address, city, state, country, zip_code, role)
VALUES
(1, NOW(), NOW(), 'Aarav Sharma', 'aarav@example.com', '9000000001', 'test123', 'MG Road', 'Bengaluru', 'Karnataka', 'India', '560001', 'USER'),
(2, NOW(), NOW(), 'Priya Singh', 'priya@example.com', '9000000002', 'test123', 'Andheri West', 'Mumbai', 'Maharashtra', 'India', '400053', 'USER'),
(3, NOW(), NOW(), 'Rahul Verma', 'rahul@example.com', '9000000003', 'test123', 'Saket', 'Delhi', 'Delhi', 'India', '110017', 'USER'),
(4, NOW(), NOW(), 'Ananya Rao', 'ananya@example.com', '9000000004', 'test123', 'Banjara Hills', 'Hyderabad', 'Telangana', 'India', '500034', 'USER'),
(5, NOW(), NOW(), 'Karan Mehta', 'karan@example.com', '9000000005', 'test123', 'Anna Nagar', 'Chennai', 'Tamil Nadu', 'India', '600040', 'USER'),
(6, NOW(), NOW(), 'Sneha Patel', 'sneha@example.com', '9000000006', 'test123', 'Koregaon Park', 'Pune', 'Maharashtra', 'India', '411001', 'USER'),
(7, NOW(), NOW(), 'Vikram Das', 'vikram@example.com', '9000000007', 'test123', 'Salt Lake', 'Kolkata', 'West Bengal', 'India', '700091', 'USER'),
(8, NOW(), NOW(), 'Isha Shah', 'isha@example.com', '9000000008', 'test123', 'Navrangpura', 'Ahmedabad', 'Gujarat', 'India', '380009', 'USER'),
(9, NOW(), NOW(), 'Rohan Gupta', 'rohan@example.com', '9000000009', 'test123', 'Malviya Nagar', 'Jaipur', 'Rajasthan', 'India', '302017', 'USER'),
(10, NOW(), NOW(), 'Meera Nair', 'meera@example.com', '9000000010', 'test123', 'Edappally', 'Kochi', 'Kerala', 'India', '682024', 'USER');

-- =========================================================
-- 11. BOOKING
-- BookingStatus is stored as ordinal because @Enumerated is
-- not specified: PENDING=0, CONFIRMED=1, CANCELLED=2.
-- =========================================================
INSERT INTO booking
(id, created_at, updated_at, ticket_number, booking_status, amount, user_id, booking_time, show_id)
VALUES
(1, NOW(), NOW(), 'TKT10001', 1, 250.00, 1, '2026-09-20 10:00:00', 1),
(2, NOW(), NOW(), 'TKT10002', 1, 400.00, 2, '2026-09-20 10:10:00', 2),
(3, NOW(), NOW(), 'TKT10003', 0, 300.00, 3, '2026-09-20 10:20:00', 3),
(4, NOW(), NOW(), 'TKT10004', 1, 500.00, 4, '2026-09-20 10:30:00', 4),
(5, NOW(), NOW(), 'TKT10005', 2, 350.00, 5, '2026-09-20 10:40:00', 5),
(6, NOW(), NOW(), 'TKT10006', 1, 275.00, 6, '2026-09-20 10:50:00', 6),
(7, NOW(), NOW(), 'TKT10007', 1, 450.00, 7, '2026-09-20 11:00:00', 7),
(8, NOW(), NOW(), 'TKT10008', 0, 325.00, 8, '2026-09-20 11:10:00', 8),
(9, NOW(), NOW(), 'TKT10009', 1, 600.00, 9, '2026-09-20 11:20:00', 9),
(10, NOW(), NOW(), 'TKT10010', 1, 200.00, 10, '2026-09-20 11:30:00', 10);

-- Booking <-> ShowSeat many-to-many
INSERT INTO booking_show_seat (booking_id, booked_show_seats_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- =========================================================
-- 12. PAYMENT
-- PaymentMode, PaymentGateway and PaymentStatus are all
-- explicitly stored as STRING.
-- =========================================================
INSERT INTO payment
(id, created_at, updated_at, amount, payment_mode, booking_id, payment_gateway, payment_status)
VALUES
(1, NOW(), NOW(), 250.00, 'UPI', 1, 'RAZORPAY', 'SUCCESS'),
(2, NOW(), NOW(), 400.00, 'CREDIT_CARD', 2, 'STRIPE', 'SUCCESS'),
(3, NOW(), NOW(), 300.00, 'DEBIT_CARD', 3, 'PAYTM', 'PENDING'),
(4, NOW(), NOW(), 500.00, 'UPI', 4, 'RAZORPAY', 'SUCCESS'),
(5, NOW(), NOW(), 350.00, 'NET_BANKING', 5, 'PAYU', 'FAILED'),
(6, NOW(), NOW(), 275.00, 'WALLET', 6, 'PAYTM', 'SUCCESS'),
(7, NOW(), NOW(), 450.00, 'CREDIT_CARD', 7, 'STRIPE', 'SUCCESS'),
(8, NOW(), NOW(), 325.00, 'UPI', 8, 'RAZORPAY', 'PENDING'),
(9, NOW(), NOW(), 600.00, 'DEBIT_CARD', 9, 'PAYPAL', 'SUCCESS'),
(10, NOW(), NOW(), 200.00, 'UPI', 10, 'PAYU', 'SUCCESS');

SET FOREIGN_KEY_CHECKS = 1;
