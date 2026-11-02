package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleDao vehicleDao;
    private final AuditService auditService;

    public VehicleService(VehicleDao vehicleDao,
                          AuditService auditService) {
        this.vehicleDao = vehicleDao;
        this.auditService = auditService;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    public Vehicle getVehicle(String regNumber) {
        return vehicleDao.getVehicleByRegNumber(regNumber);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleDao.addVehicle(vehicle);
        auditService.logActivity(
                "Vehicle added: " + vehicle.getRegNumber()
        );
    }

    public void updateOdometer(String regNumber, int odometer) {

        Vehicle vehicle = vehicleDao.getVehicleByRegNumber(regNumber);

        if (odometer < vehicle.getCurrentOdometer()) {
            throw new IllegalArgumentException(
                    "New odometer cannot be less than current odometer."
            );
        }

        vehicleDao.updateOdometer(regNumber, odometer);

        auditService.logActivity(
                "Odometer updated for: " + regNumber
        );
    }

    public void deleteVehicle(String regNumber) {
        vehicleDao.deleteVehicle(regNumber);
        auditService.logActivity(
                "Vehicle deleted: " + regNumber
        );
    }
}