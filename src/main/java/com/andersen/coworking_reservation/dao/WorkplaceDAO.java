package com.andersen.coworking_reservation.dao;
import com.andersen.coworking_reservation.model.Workplace;
import com.andersen.coworking_reservation.db.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class WorkplaceDAO {
    public List<Workplace> getAll() {
        List<Workplace> workplaces = new ArrayList<>();
        String sql = "SELECT * FROM worksplaces";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                workplaces.add(new Workplace(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getBoolean("is_available")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workplaces;
    }

    public void add(String type, Double price) {
        String sql = "INSERT INTO workplaces (type, price, is_available) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, type);
            stmt.setDouble(2, price);
            stmt.setBoolean(3, true);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM workplaces WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIsAvailable(int id, boolean isAvailable) {
        String sql = "UPDATE workplaces SET is_available = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, isAvailable);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Workplace> getAvailableWorkplaces() {
        List<Workplace> availableWorkplaces = new ArrayList<>();
        String sql = "SELECT * FROM workplaces WHERE is_available = TRUE";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                boolean isAvailable = rs.getBoolean("is_available");

                Workplace workplace = new Workplace(id, type, price,isAvailable);
                availableWorkplaces.add(workplace);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableWorkplaces;
    }
}
