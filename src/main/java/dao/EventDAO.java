package dao;

import db.DatabaseConnection;
import model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EventDAO {

    public void addEvent(Event event) {
        String sql = "INSERT INTO events (name, date, location) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, event.getName());
            ps.setDate(2, event.getDate());
            ps.setString(3, event.getLocation());

            ps.executeUpdate();
            System.out.println("Event added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllEvents() {
        String sql = "SELECT * FROM events";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nAll Events:");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                " | Name: " + rs.getString("name") +
                                " | Date: " + rs.getDate("date") +
                                " | Location: " + rs.getString("location")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEventsWithParticipants() {
        String sql = """
            SELECT events.name AS event_name,
                   events.date,
                   events.location,
                   participants.name AS participant_name
            FROM events
            JOIN participants
            ON events.id = participants.event_id
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nEvents with Participants:");

            while (rs.next()) {
                System.out.println(
                        "Event: " + rs.getString("event_name") +
                                " | Date: " + rs.getDate("date") +
                                " | Location: " + rs.getString("location") +
                                " | Participant: " + rs.getString("participant_name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}