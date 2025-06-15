package com.ps.dealership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DealershipApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VehicleDAO vehicleDAO = new VehicleDAO();
    private static final SalesContractDAO salesDAO = new SalesContractDAO();
    private static final LeaseContractDAO leaseDAO = new LeaseContractDAO();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchVehiclesMenu();
                    break;
                case "2":
                    addVehicle();
                    break;
                case "3":
                    removeVehicle();
                    break;
                case "4":
                    processSaleOrLease();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting the dealership system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== Car Dealership Menu ===");
        System.out.println("1. Search Vehicles");
        System.out.println("2. Add Vehicle");
        System.out.println("3. Remove Vehicle");
        System.out.println("4. Process Sale or Lease Contract");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void searchVehiclesMenu() {
        System.out.println("\nSearch Vehicles By: ");
        System.out.println("1. Price Range");
        System.out.println("2. Make and Model");
        System.out.println("3. Year Range");
        System.out.println("4. Color");
        System.out.println("5. Mileage");
        System.out.println("6. Type");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        List<Vehicle> vehicles = null;

        switch (choice) {
            case "1":
                System.out.print("Min price: ");
                double minPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Max price: ");
                double maxPrice = Double.parseDouble(scanner.nextLine());
                vehicles = vehicleDAO.getByPriceRange(minPrice, maxPrice);
                break;
            case "2":
                System.out.print("Make: ");
                String make = scanner.nextLine();
                System.out.print("Model: ");
                String model = scanner.nextLine();
                vehicles = vehicleDAO.getByMakeModel(make, model);
                break;
            case "3":
                System.out.print("Min year: ");
                int minYear = Integer.parseInt(scanner.nextLine());
                System.out.print("Max year: ");
                int maxYear = Integer.parseInt(scanner.nextLine());
                vehicles = vehicleDAO.getByYearRange(minYear, maxYear);
                break;
            case "4":
                System.out.print("Color: ");
                String color = scanner.nextLine();
                vehicles = vehicleDAO.getByColor(color);
                break;
            case "5":
                System.out.print("Min mileage: ");
                int minMiles = Integer.parseInt(scanner.nextLine());
                System.out.print("Max mileage: ");
                int maxMiles = Integer.parseInt(scanner.nextLine());
                vehicles = vehicleDAO.getByMileageRange(minMiles, maxMiles);
                break;
            case "6":
                System.out.print("Type: ");
                String type = scanner.nextLine();
                vehicles = vehicleDAO.getByType(type);
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }

        if (vehicles != null && !vehicles.isEmpty()) {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        } else {
            System.out.println("No vehicles found.");
        }
    }

    private static void addVehicle() {
        System.out.println("\nEnter vehicle details:");

        System.out.print("VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        vehicleDAO.addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private static void removeVehicle() {
        System.out.print("Enter VIN of vehicle to remove: ");
        String vin = scanner.nextLine();

        String deleteInventorySQL = "DELETE FROM inventory WHERE vin = ?";
        String deleteVehicleSQL = "DELETE FROM vehicles WHERE vin = ?";

        try (Connection connection = DatabaseManager.getDataSource().getConnection()) {
            connection.setAutoCommit(false);

            try (
                    PreparedStatement inventoryStatement = connection.prepareStatement(deleteInventorySQL);
                    PreparedStatement vehicleStatement = connection.prepareStatement(deleteVehicleSQL)
            ) {
                inventoryStatement.setString(1, vin);
                inventoryStatement.executeUpdate();

                vehicleStatement.setString(1, vin);
                vehicleStatement.executeUpdate();

                connection.commit();
                System.out.println("Vehicle removed successfully.");
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Failed to remove vehicle. Rolling back.");
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void processSaleOrLease() {
        System.out.print("Enter vehicle VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Customer name: ");
        String name = scanner.nextLine();

        System.out.print("Customer email: ");
        String email = scanner.nextLine();

        System.out.print("Is this a sale or lease? (S/L): ");
        String type = scanner.nextLine().trim().toUpperCase();

        if (type.equals("S")) {
            System.out.print("Sales price: ");
            double price = Double.parseDouble(scanner.nextLine());

            double tax = price * 0.05;
            double fee = price > 10000 ? 495 : 295;
            double total = price + tax + fee;
            double monthly = total / 24;

            SalesContract contract = new SalesContract(vin, name, email, price, tax, fee, total, monthly);
            salesDAO.save(contract);
            System.out.println("Sale contract processed.");
        } else if (type.equals("L")) {
            System.out.print("Lease price: ");
            double price = Double.parseDouble(scanner.nextLine());

            double endValue = price * 0.5;
            double leaseFee = 250;
            double total = price + leaseFee;
            double monthly = total / 36;

            LeaseContract contract = new LeaseContract(vin, name, email, price, endValue, leaseFee, total, monthly);
            leaseDAO.save(contract);
            System.out.println("Lease contract processed.");
        } else {
            System.out.println("Invalid input. Must be 'S' or 'L'.");
        }
    }
}
