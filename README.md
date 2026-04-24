# Event Management App

This is a simple Java console application for managing events and participants using MySQL and JDBC. The application allows users to create events, add participants, and display data using SQL queries including joins.

## Features

- Add Event
- View All Events
- Add Participant
- View Events with Participants (JOIN)

## Technologies Used

- Java
- JDBC
- MySQL
- Maven

## Project Structure

The project is organized into the following packages:

- model: Contains the Event and Participant classes
- dao: Contains database operations (EventDAO, ParticipantDAO)
- db: Handles the database connection
- main: Contains MainApp (entry point of the application)

## Database Setup

1. Create the database:

CREATE DATABASE event_management;

2. Use the database:

USE event_management;

3. Create the tables:

CREATE TABLE events (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
date DATE,
location VARCHAR(100)
);

CREATE TABLE participants (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
event_id INT,
FOREIGN KEY (event_id) REFERENCES events(id)
);

## How to Run

1. Make sure MySQL is running
2. Update database credentials in DatabaseConnection.java (username and password)
3. Run MainApp.java from IntelliJ

