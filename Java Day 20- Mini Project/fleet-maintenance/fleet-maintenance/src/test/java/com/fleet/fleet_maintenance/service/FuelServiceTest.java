
package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.FuelEntryDao;
import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.model.FuelEntry;
import com.fleet.fleet_maintenance.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FuelServiceTest {

    private FuelEntryDao fuelEntryDao;
    private VehicleDao vehicleDao;
    private AuditService auditService;
    private FuelService fuelService;

    @BeforeEach
    void setUp() {
        fuelEntryDao = mock(FuelEntryDao.class);
        vehicleDao = mock(VehicleDao.class);
        auditService = mock(AuditService.class);

        fuelService = new FuelService(
                fuelEntryDao,
                vehicleDao,
                auditService
        );
    }

    @Test
    void testGetAllFuelEntries() {
        List<FuelEntry> entries = List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 12000)
        );

        when(fuelEntryDao.getAllFuelEntries()).thenReturn(entries);

        List<FuelEntry> result = fuelService.getAllFuelEntries();

        assertEquals(1, result.size());
    }

    @Test
    void testGetFuelEntries() {
        List<FuelEntry> entries = List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 12000)
        );

        when(fuelEntryDao.getFuelEntriesByVehicle("MH02XY9999"))
                .thenReturn(entries);

        List<FuelEntry> result =
                fuelService.getFuelEntries("MH02XY9999");

        assertEquals(1, result.size());
        assertEquals(12000, result.get(0).getOdometerReading());
    }

    @Test
    void testAddFuelEntry() {
        FuelEntry entry = new FuelEntry(
                0, "MH02XY9999",
                new BigDecimal("30.00"),
                new BigDecimal("3150.00"), 12000
        );

        Vehicle vehicle = mock(Vehicle.class);

        when(vehicleDao.getVehicleByRegNumber("MH02XY9999"))
                .thenReturn(vehicle);
        when(vehicle.getCurrentOdometer()).thenReturn(10000);

        fuelService.addFuelEntry(entry);

        verify(fuelEntryDao).addFuelEntry(entry);
        verify(vehicleDao).updateOdometer("MH02XY9999", 12000);
        verify(auditService).logActivity(
                "Fuel entry added for: MH02XY9999"
        );
    }

    @Test
    void testOlderFuelEntryDoesNotUpdateOdometer() {
        FuelEntry entry = new FuelEntry(
                0, "MH02XY9999",
                new BigDecimal("30.00"),
                new BigDecimal("3150.00"), 9000
        );

        Vehicle vehicle = mock(Vehicle.class);

        when(vehicleDao.getVehicleByRegNumber("MH02XY9999"))
                .thenReturn(vehicle);
        when(vehicle.getCurrentOdometer()).thenReturn(12000);

        fuelService.addFuelEntry(entry);

        verify(fuelEntryDao).addFuelEntry(entry);
        verify(vehicleDao, never())
                .updateOdometer(anyString(), anyInt());
    }

    @Test
    void testAddFuelEntryWithUnknownVehicle() {
        FuelEntry entry = new FuelEntry(
                0, "MH02XY9999",
                new BigDecimal("30.00"),
                new BigDecimal("3150.00"), 12000
        );

        when(vehicleDao.getVehicleByRegNumber("MH02XY9999"))
                .thenReturn(null);

        assertThrows(IllegalArgumentException.class,
                () -> fuelService.addFuelEntry(entry));

        verify(fuelEntryDao, never()).addFuelEntry(any());
    }

    @Test
    void testCalculateFuelEfficiency() {
        List<FuelEntry> entries = new ArrayList<>(List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("20.00"),
                        new BigDecimal("2100.00"), 10000),

                new FuelEntry(2, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 10500),

                new FuelEntry(3, "MH02XY9999",
                        new BigDecimal("25.00"),
                        new BigDecimal("2625.00"), 11000)
        ));

        when(fuelEntryDao.getFuelEntriesByVehicle("MH02XY9999"))
                .thenReturn(entries);

        BigDecimal result =
                fuelService.calculateFuelEfficiency("MH02XY9999");

        assertEquals(new BigDecimal("18.18"), result);
    }

    @Test
    void testCalculateFuelEfficiencyWithInsufficientEntries() {
        List<FuelEntry> entries = List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 12000)
        );

        when(fuelEntryDao.getFuelEntriesByVehicle("MH02XY9999"))
                .thenReturn(entries);

        assertThrows(IllegalStateException.class,
                () -> fuelService.calculateFuelEfficiency("MH02XY9999"));
    }
    @Test
    void testLowMileageAnomalyDetected() {

        List<FuelEntry> entries = new ArrayList<>(List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("20.00"),
                        new BigDecimal("2100.00"), 10000),

                new FuelEntry(2, "MH02XY9999",
                        new BigDecimal("60.00"),
                        new BigDecimal("6300.00"), 10500)
        ));

        when(fuelEntryDao.getFuelEntriesByVehicle("MH02XY9999"))
                .thenReturn(entries);

        boolean result =
                fuelService.isLowMileageAnomaly("MH02XY9999");

        assertTrue(result);
    }

    @Test
    void testNormalMileageIsNotAnomaly() {

        List<FuelEntry> entries = new ArrayList<>(List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("20.00"),
                        new BigDecimal("2100.00"), 10000),

                new FuelEntry(2, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 10500),

                new FuelEntry(3, "MH02XY9999",
                        new BigDecimal("25.00"),
                        new BigDecimal("2625.00"), 11000)
        ));

        when(fuelEntryDao.getFuelEntriesByVehicle("MH02XY9999"))
                .thenReturn(entries);

        boolean result =
                fuelService.isLowMileageAnomaly("MH02XY9999");

        assertFalse(result);
    }
    @Test
    void testCalculateFuelEfficiencyWithInvalidReadings() {
        List<FuelEntry> entries = new ArrayList<>(List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("20.00"),
                        new BigDecimal("2100.00"), 10000),

                new FuelEntry(2, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 10000)
        ));

        when(fuelEntryDao.getFuelEntriesByVehicle("MH02XY9999"))
                .thenReturn(entries);

        assertThrows(IllegalStateException.class,
                () -> fuelService.calculateFuelEfficiency("MH02XY9999"));
    }
}
