package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.FuelEntryDao;
import com.fleet.fleet_maintenance.model.FuelEntry;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
public class FuelService {

    private final FuelEntryDao fuelEntryDao;
    private final AuditService auditService;

    public FuelService(FuelEntryDao fuelEntryDao,
                       AuditService auditService) {
        this.fuelEntryDao = fuelEntryDao;
        this.auditService = auditService;
    }

    public List<FuelEntry> getAllFuelEntries() {
        return fuelEntryDao.getAllFuelEntries();
    }

    public List<FuelEntry> getFuelEntries(String regNumber) {
        return fuelEntryDao.getFuelEntriesByVehicle(regNumber);
    }

    public void addFuelEntry(FuelEntry entry) {

        fuelEntryDao.addFuelEntry(entry);

        auditService.logActivity(
                "Fuel entry added for: " + entry.getRegNumber()
        );
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

        if (distance <= 0 || totalLitres.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException(
                    "Invalid odometer readings or fuel quantity."
            );
        }

        BigDecimal efficiency = BigDecimal.valueOf(distance)
                .divide(totalLitres, 2,
                        java.math.RoundingMode.HALF_UP);

        return efficiency;
    }
}
