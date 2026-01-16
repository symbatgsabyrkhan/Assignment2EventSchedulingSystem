package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import objects.Event;
import objects.Conference;

public class EventDAO {
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS events (id SERIAL PRIMARY KEY, name VARCHAR(255), event_date VARCHAR(100), capacity INTEGER)";
    private static final String INSERT = "INSERT INTO events (name, event_date, capacity) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM events";
    private static final String SELECT_BY_NAME = "SELECT * FROM events WHERE name = ?";
    private static final String UPDATE = "UPDATE events SET capacity = ? WHERE name = ?";
    private static final String DELETE = "DELETE FROM events WHERE name = ?";

    private void createTable() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void save(Event event) {
        createTable();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT)) {
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDate());
            pstmt.setInt(3, event.getCapacity());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deleteEvent(String name) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Conference getEventByName(String name) {
        createTable();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_NAME)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Conference(rs.getString("name"), rs.getString("event_date"), rs.getInt("capacity"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Event> getAll() {
        createTable();
        List<Event> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                list.add(new Event(rs.getString("name"), rs.getString("event_date"), rs.getInt("capacity")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void update(String name, int cap) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, cap);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}