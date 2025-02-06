CREATE DATABASE AirlineDB;

USE AirlineDB;

CREATE TABLE flights (
    flight_id INT PRIMARY KEY AUTO_INCREMENT,
    airline VARCHAR(50),
    departure VARCHAR(50),
    destination VARCHAR(50),
    seats_available INT
);

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    flight_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id)
);
