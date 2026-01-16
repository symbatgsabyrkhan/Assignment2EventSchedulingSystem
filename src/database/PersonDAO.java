package database;

import java.sql.*;
import objects.Person;
import objects.Participant;
import objects.Organizer;

public class PersonDAO {
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS people (id SERIAL PRIMARY KEY, name VARCHAR(255), role VARCHAR(100), extra_info TEXT)";
    private static final String INSERT = "INSERT INTO people (name, role, extra_info) VALUES (?, ?, ?)";
    private static final String SELECT_BY_NAME = "SELECT * FROM people WHERE name = ?";
    private static final String UPDATE = "UPDATE people SET extra_info = ? WHERE name = ?";
    private static final String DELETE = "DELETE FROM people WHERE name = ?";

    private void createTable() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void savePerson(Person p, String extra) {
        createTable();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getRole());
            pstmt.setString(3, extra);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updatePersonExtra(String name, String newExtra) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, newExtra);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deletePerson(String name) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Participant getParticipantByName(String name) {
        createTable();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_NAME)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Participant(rs.getString("name"), rs.getString("extra_info"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public Organizer getOrganizerByName(String name) {
        createTable();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_NAME)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Organizer(rs.getString("name"), rs.getString("extra_info"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}