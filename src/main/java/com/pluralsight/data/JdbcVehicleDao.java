package com.pluralsight.data;

import com.pluralsight.models.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcVehicleDao implements VehicleDao {

    @Override
    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM vehicles";
        return queryVehicles(sql);
    }

    @Override
    public List<Vehicle> findByPrice(double min, double max) {
        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";
        return queryVehicles(sql, min, max);
    }

    @Override
    public List<Vehicle> findByMakeModel(String make, String model) {
        String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ?";
        return queryVehicles(sql, make, model);
    }

    @Override
    public List<Vehicle> findByYearRange(int minYear, int maxYear) {
        String sql = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";
        return queryVehicles(sql, minYear, maxYear);
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        String sql = "SELECT * FROM vehicles WHERE color = ?";
        return queryVehicles(sql, color);
    }

    @Override
    public List<Vehicle> findByMileageRange(int min, int max) {
        String sql = "SELECT * FROM vehicles WHERE mileage BETWEEN ? AND ?";
        return queryVehicles(sql, min, max);
    }

    @Override
    public List<Vehicle> findByType(String type) {
        String sql = "SELECT * FROM vehicles WHERE type = ?";
        return queryVehicles(sql, type);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (vin, make, model, year, color, mileage, price, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicle.getVin());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, vehicle.getModel());
            stmt.setInt(4, vehicle.getYear());
            stmt.setString(5, vehicle.getColor());
            stmt.setInt(6, vehicle.getMileage());
            stmt.setDouble(7, vehicle.getPrice());
            stmt.setString(8, vehicle.getType());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteVehicle(int vin) {
        String sql = "DELETE FROM vehicles WHERE vin = ?";

        try (Connection conn = DataManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vin);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Vehicle> queryVehicles(String sql, Object... params) {
        List<Vehicle> result = new ArrayList<>();

        try (Connection conn = DataManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(new Vehicle(
                        rs.getInt("vin"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getInt("mileage"),
                        rs.getDouble("price"),
                        rs.getString("type")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
