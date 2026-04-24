package dao;

import db.DatabaseConnection;
import model.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ParticipantDAO {

    public void addParticipant(Participant participant) {

        String sql = "INSERT INTO participants (name, event_id) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, participant.getName());
            stmt.setInt(2, participant.getEventId());

            stmt.executeUpdate();

            System.out.println("Participant added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}