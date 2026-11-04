package com.fleet.fleet_maintenance.console;

import com.fleet.fleet_maintenance.model.*;
import com.fleet.fleet_maintenance.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class ConsoleMenu {

    private final VehicleService vehicleService;
    private final FuelService fuelService;
    private final MaintenanceService maintenanceService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(VehicleService vehicleService,
                       FuelService fuelService,
                       MaintenanceService maintenanceService) {
        this.vehicleService = vehicleService;
        this.fuelService = fuelService;
        this.maintenanceService = maintenanceService;
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n===== FLEET MAINTENANCE SYSTEM =====");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Update Odometer");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Add Fuel Entry");
            System.out.println("6. View Fuel Entries");
            System.out.println("7. Calculate Fuel Efficiency");
            System.out.println("8. Add Service Record");
            System.out.println("9. View Service Records");
            System.out.println("10. Maintenance Alerts");
            System.out.println("11. Fleet Operational Cost Report");
            System.out.println("12. Check Low Mileage Anomaly");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> viewVehicles();
                    case 2 -> addVehicle();
                    case 3 -> updateOdometer();
                    case 4 -> deleteVehicle();
                    case 5 -> addFuelEntry();
                    case 6 -> viewFuelEntries();
                    case 7 -> calculateEfficiency();
                    case 8 -> addServiceRecord();
                    case 9 -> viewServiceRecords();
                    case 10 -> maintenanceAlerts();
                    case 11 -> operationalCostReport();
                    case 12 -> checkLowMileageAnomaly();
                    case 0 -> System.out.println("Exiting application...");
                    default -> System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                choice = -1;
            }

        } while (choice != 0);
    }

    private void viewVehicles() {

        List<Vehicle> vehicles = vehicleService.getAllVehicles();

        for (Vehicle v : vehicles) {
            System.out.println(
                    v.getRegNumber() + " | " +
                            v.getModel() + " | " +
                            v.getCurrentOdometer() + " | " +
                            v.getStatus()
            );
        }
    }

    private void addVehicle() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        System.out.print("Vehicle Model: ");
        String model = scanner.nextLine();

        System.out.print("Current Odometer: ");
        int current = Integer.parseInt(scanner.nextLine());

        System.out.print("Last Service Odometer: ");
        int last = Integer.parseInt(scanner.nextLine());

        Vehicle vehicle = new Vehicle(
                0, reg, model, current, last, "ACTIVE"
        );

        vehicleService.addVehicle(vehicle);

        System.out.println("Vehicle added successfully!");
    }

    private void updateOdometer() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        System.out.print("New Odometer Reading: ");
        int reading = Integer.parseInt(scanner.nextLine());

        vehicleService.updateOdometer(reg, reading);

        System.out.println("Odometer updated successfully!");
    }

    private void deleteVehicle() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        vehicleService.deleteVehicle(reg);
    }

    private void addFuelEntry() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        System.out.print("Fuel Litres: ");
        BigDecimal litres = new BigDecimal(scanner.nextLine());

        System.out.print("Fuel Cost: ");
        BigDecimal cost = new BigDecimal(scanner.nextLine());

        System.out.print("Odometer Reading: ");
        int reading = Integer.parseInt(scanner.nextLine());

        FuelEntry entry = new FuelEntry(
                0, reg, litres, cost, reading
        );

        fuelService.addFuelEntry(entry);

        System.out.println("Fuel entry added successfully!");
    }

    private void viewFuelEntries() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        List<FuelEntry> entries = fuelService.getFuelEntries(reg);

        for (FuelEntry entry : entries) {
            System.out.println(
                    entry.getRegNumber() + " | " +
                            entry.getLitres() + " litres | " +
                            entry.getCost() + " | " +
                            entry.getOdometerReading()
            );
        }
    }

    private void calculateEfficiency() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        BigDecimal efficiency =
                fuelService.calculateFuelEfficiency(reg);

        System.out.println(
                "Fuel Efficiency: " + efficiency + " km/l"
        );
    }

    private void addServiceRecord() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        System.out.print("Service Type: ");
        String type = scanner.nextLine();

        System.out.print("Service Cost: ");
        BigDecimal cost = new BigDecimal(scanner.nextLine());

        System.out.print("Service Odometer: ");
        int reading = Integer.parseInt(scanner.nextLine());

        System.out.print("Service Date (YYYY-MM-DD): ");
        LocalDate serviceDate = LocalDate.parse(scanner.nextLine().trim());

        ServiceRecord record = new ServiceRecord(
                0, reg, type, cost, reading, serviceDate
        );

        maintenanceService.addServiceRecord(record);

        System.out.println("Service record added successfully!");
    }

    private void viewServiceRecords() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        List<ServiceRecord> records =
                maintenanceService.getServiceRecords(reg);

        for (ServiceRecord record : records) {
            System.out.println(
                    record.getRegNumber() + " | " +
                            record.getServiceType() + " | " +
                            record.getServiceCost() + " | " +
                            record.getServiceDate()
            );
        }
    }

    private void maintenanceAlerts() {

        List<Vehicle> alerts =
                maintenanceService.getMaintenanceAlerts();

        if (alerts.isEmpty()) {
            System.out.println("No maintenance alerts!");
            return;
        }

        System.out.println("Vehicles requiring maintenance:");

        for (Vehicle v : alerts) {
            System.out.println(
                    v.getRegNumber() + " | " +
                            v.getModel() + " | Current Odometer: " +
                            v.getCurrentOdometer()
            );
        }
    }

    private void operationalCostReport() {

        List<Map<String, Object>> report =
                vehicleService.getOperationalCostReport();

        System.out.println("\n===== FLEET OPERATIONAL COST REPORT =====");

        System.out.printf(
                "%-15s %-25s %-15s %-18s %-15s%n",
                "Registration",
                "Model",
                "Fuel Cost",
                "Maintenance",
                "Total Cost"
        );

        for (Map<String, Object> row : report) {

            System.out.printf(
                    "%-15s %-25s %-15s %-18s %-15s%n",
                    row.get("reg_number"),
                    row.get("model"),
                    row.get("fuel_cost"),
                    row.get("maintenance_cost"),
                    row.get("total_cost")
            );
        }
    }

    private void checkLowMileageAnomaly() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine().strip();

        boolean anomaly = fuelService.isLowMileageAnomaly(reg);

        if (anomaly) {
            System.out.println(
                    "LOW MILEAGE ANOMALY DETECTED for " + reg
            );
        } else {
            System.out.println(
                    "Fuel mileage is within the expected range for " + reg
            );
        }
    }
}
