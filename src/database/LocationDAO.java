package database;

import java.sql.*;

public class LocationDAO {
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS locations (id SERIAL PRIMARY KEY, city VARCHAR(100), address TEXT)";
    private static final String INSERT = "INSERT INTO locations (city, address) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE locations SET address = ? WHERE city = ?";
    private static final String DELETE = "DELETE FROM locations WHERE city = ?";

    public LocationDAO() {
        createTable();
    }

    private void createTable() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insert(String city, String address) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT)) {
            pstmt.setString(1, city);
            pstmt.setString(2, address);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void update(String city, String newAddress) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, newAddress);
            pstmt.setString(2, city);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(String city) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setString(1, city);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}