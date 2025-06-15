package com.ps.dealership;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private final DataSource dataSource = DatabaseManager.getDataSource();

    // 🔍 Search by price range
    public List<Vehicle> getByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(mapRow(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    // 🔍 Search by make and model
    public List<Vehicle> getByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, make);
            statement.setString(2, model);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(mapRow(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    // 🔍 Search by year range
    public List<Vehicle> getByYearRange(int minYear, int maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, minYear);
            statement.setInt(2, maxYear);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(mapRow(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    // 🔍 Search by color
    public List<Vehicle> getByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE color = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, color);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(mapRow(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    // 🔍 Search by mileage
    public List<Vehicle> getByMileageRange(int minMileage, int maxMileage) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, minMileage);
            statement.setInt(2, maxMileage);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(mapRow(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    // 🔍 Search by type
    public List<Vehicle> getByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE vehicleType = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, type);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(mapRow(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    // ➕ Add a vehicle
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (vin, year, make, model, vehicleType, color, odometer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, vehicle.getVin());
            statement.setInt(2, vehicle.getYear());
            statement.setString(3, vehicle.getMake());
            statement.setString(4, vehicle.getModel());
            statement.setString(5, vehicle.getVehicleType());
            statement.setString(6, vehicle.getColor());
            statement.setInt(7, vehicle.getOdometer());
            statement.setDouble(8, vehicle.getPrice());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ❌ Remove a vehicle
    public void removeVehicle(String vin) {
        String sql = "DELETE FROM vehicles WHERE vin = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, vin);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔁 Helper: map a database row to a Vehicle object
    private Vehicle mapRow(ResultSet resultSet) throws SQLException {
        return new Vehicle(
                resultSet.getInt("id"),
                resultSet.getString("vin"),
                resultSet.getInt("year"),
                resultSet.getString("make"),
                resultSet.getString("model"),
                resultSet.getString("vehicleType"),
                resultSet.getString("color"),
                resultSet.getInt("odometer"),
                resultSet.getDouble("price")
        );
    }
}
