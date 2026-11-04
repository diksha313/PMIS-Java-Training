
package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.FuelEntryDao;
import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.model.FuelEntry;
import com.fleet.fleet_maintenance.model.Vehicle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
public class FuelService {

    private final FuelEntryDao fuelEntryDao;
    private final VehicleDao vehicleDao;
    private final AuditService auditService;
    private static final BigDecimal LOW_MILEAGE_THRESHOLD =
            new BigDecimal("10.00");
    public FuelService(FuelEntryDao fuelEntryDao,
                       VehicleDao vehicleDao,
                       AuditService auditService) {
        this.fuelEntryDao = fuelEntryDao;
        this.vehicleDao = vehicleDao;
        this.auditService = auditService;
    }

    public List<FuelEntry> getAllFuelEntries() {
        return fuelEntryDao.getAllFuelEntries();
    }

    public List<FuelEntry> getFuelEntries(String regNumber) {
        return fuelEntryDao.getFuelEntriesByVehicle(regNumber);
    }

    @Transactional
    public void addFuelEntry(FuelEntry entry) {

        Vehicle vehicle =
                vehicleDao.getVehicleByRegNumber(entry.getRegNumber());

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

        if (entry.getOdometerReading() < 0) {
            throw new IllegalArgumentException(
                    "Odometer reading cannot be negative."
            );
        }

        fuelEntryDao.addFuelEntry(entry);

        if (entry.getOdometerReading() > vehicle.getCurrentOdometer()) {
            vehicleDao.updateOdometer(
                    entry.getRegNumber(),
                    entry.getOdometerReading()
            );
        }

        auditService.logActivity(
                "Fuel entry added for: " + entry.getRegNumber()
        );
    }
    public boolean isLowMileageAnomaly(String regNumber) {
        BigDecimal efficiency = calculateFuelEfficiency(regNumber);
        return efficiency.compareTo(LOW_MILEAGE_THRESHOLD) < 0;
    }
    public BigDecimal calculateFuelEfficiency(String regNumber) {

        List<FuelEntry> entries =
                fuelEntryDao.getFuelEntriesByVehicle(regNumber);

        if (entries.size() < 2) {
            throw new IllegalStateException(
                    "At least two fuel entries are required."
            );
        }

        entries.sort(
                Comparator.comparingInt(
                        FuelEntry::getOdometerReading
                )
        );

        int firstReading =
                entries.get(0).getOdometerReading();

        int lastReading =
                entries.get(entries.size() - 1).getOdometerReading();

        int distance = lastReading - firstReading;

        BigDecimal totalLitres = entries.stream()
                .skip(1)
                .map(FuelEntry::getLitres)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (distance <= 0 ||
                totalLitres.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException(
                    "Invalid odometer readings or fuel quantity."
            );
        }

        return BigDecimal.valueOf(distance)
                .divide(totalLitres, 2,
                        java.math.RoundingMode.HALF_UP);
    }
}
