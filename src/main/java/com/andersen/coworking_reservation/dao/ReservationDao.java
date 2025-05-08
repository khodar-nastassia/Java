package com.andersen.coworking_reservation.dao;
import com.andersen.coworking_reservation.db.DBUtil;
import com.andersen.coworking_reservation.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ReservationDao {
    public void reserve(String customerName, int workplaceId, String date, String startTime, String endTime) {
        String sql = "INSERT INTO reservations (customer_name, workplace_id, date, start_time, end_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerName);
            stmt.setInt(2, workplaceId);
            stmt.setString(3, date);
            stmt.setString(4, startTime);
            stmt.setString(5, endTime);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancel(int reservationId) {
        String sql = "DELETE FROM reservations WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> getByCustomerName(String customerName) {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE customer_name = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getInt("workspace_id"),
                        rs.getString("date"),
                        rs.getString("start_time"),
                        rs.getString("end_time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Reservation> getAll() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getInt("workspace_id"),
                        rs.getString("date"),
                        rs.getString("start_time"),
                        rs.getString("end_time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
