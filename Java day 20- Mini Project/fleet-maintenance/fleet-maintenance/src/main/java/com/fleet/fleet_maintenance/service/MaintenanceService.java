package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.ServiceRecordDao;
import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.model.ServiceRecord;
import com.fleet.fleet_maintenance.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    private final ServiceRecordDao serviceRecordDao;
    private final VehicleDao vehicleDao;
    private final AuditService auditService;

    private static final int SERVICE_INTERVAL = 5000;

    public MaintenanceService(ServiceRecordDao serviceRecordDao,
                              VehicleDao vehicleDao,
                              AuditService auditService) {
        this.serviceRecordDao = serviceRecordDao;
        this.vehicleDao = vehicleDao;
        this.auditService = auditService;
    }

    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecordDao.getAllServiceRecords();
    }

    public List<ServiceRecord> getServiceRecords(String regNumber) {
        return serviceRecordDao.getServiceRecordsByVehicle(regNumber);
    }

    public void addServiceRecord(ServiceRecord record) {

        serviceRecordDao.addServiceRecord(record);

        auditService.logActivity(
                "Service record added for: " + record.getRegNumber()
        );
    }

    public List<Vehicle> getMaintenanceAlerts() {

        List<Vehicle> vehicles = vehicleDao.getAllVehicles();

        return vehicles.stream()
                .filter(vehicle ->
                        vehicle.getCurrentOdometer()
                                - vehicle.getLastServiceOdometer()
                                >= SERVICE_INTERVAL)
                .toList();
    }
}