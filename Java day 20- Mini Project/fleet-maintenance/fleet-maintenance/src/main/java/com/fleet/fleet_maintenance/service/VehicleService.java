
package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.dao.ServiceRecordDao;
import com.fleet.fleet_maintenance.model.Vehicle;
import com.fleet.fleet_maintenance.model.ServiceRecord;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleDao vehicleDao;
    private final ServiceRecordDao serviceRecordDao;
    private final AuditService auditService;

    public VehicleService(VehicleDao vehicleDao,
                          ServiceRecordDao serviceRecordDao,
                          AuditService auditService) {
        this.vehicleDao = vehicleDao;
        this.serviceRecordDao = serviceRecordDao;
        this.auditService = auditService;
    }

    public List<Map<String, Object>> getOperationalCostReport() {
        return vehicleDao.getOperationalCostReport();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    public Vehicle getVehicle(String regNumber) {
        return vehicleDao.getVehicleByRegNumber(regNumber);
    }

    @Transactional
    public void addVehicle(Vehicle vehicle) {

        vehicleDao.addVehicle(vehicle);

        ServiceRecord baselineRecord = new ServiceRecord(
                0,
                vehicle.getRegNumber(),
                "BASELINE",
                BigDecimal.ZERO,
                vehicle.getLastServiceOdometer(),
                LocalDate.now()
        );

        serviceRecordDao.addServiceRecord(baselineRecord);

        auditService.logActivity(
                "Vehicle added with baseline service record: "
                        + vehicle.getRegNumber()
        );
    }

    public void updateOdometer(String regNumber, int odometer) {

        Vehicle vehicle = vehicleDao.getVehicleByRegNumber(regNumber);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

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
