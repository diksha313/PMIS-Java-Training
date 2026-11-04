
package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.ServiceRecordDao;
import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.model.ServiceRecord;
import com.fleet.fleet_maintenance.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MaintenanceServiceTest {

    private ServiceRecordDao serviceRecordDao;
    private VehicleDao vehicleDao;
    private AuditService auditService;
    private MaintenanceService maintenanceService;

    @BeforeEach
    void setUp() {
        serviceRecordDao = mock(ServiceRecordDao.class);
        vehicleDao = mock(VehicleDao.class);
        auditService = mock(AuditService.class);

        maintenanceService = new MaintenanceService(
                serviceRecordDao, vehicleDao, auditService
        );
    }

    @Test
    void testGetAllServiceRecords() {
        List<ServiceRecord> records = List.of(
                new ServiceRecord(
                        1, "MH02XY9999", "OIL_CHANGE",
                        new BigDecimal("2500.00"),
                        12000, LocalDate.of(2026, 11, 2)
                )
        );

        when(serviceRecordDao.getAllServiceRecords())
                .thenReturn(records);

        List<ServiceRecord> result =
                maintenanceService.getAllServiceRecords();

        assertEquals(1, result.size());
    }

    @Test
    void testGetServiceRecords() {
        List<ServiceRecord> records = List.of(
                new ServiceRecord(
                        1, "MH02XY9999", "OIL_CHANGE",
                        new BigDecimal("2500.00"),
                        12000, LocalDate.of(2026, 11, 2)
                )
        );

        when(serviceRecordDao.getServiceRecordsByVehicle("MH02XY9999"))
                .thenReturn(records);

        List<ServiceRecord> result =
                maintenanceService.getServiceRecords("MH02XY9999");

        assertEquals(1, result.size());
        assertEquals("OIL_CHANGE", result.get(0).getServiceType());
    }

    @Test
    void testAddServiceRecord() {
        ServiceRecord record = new ServiceRecord(
                0, "MH02XY9999", "OIL_CHANGE",
                new BigDecimal("2500.00"),
                12000, LocalDate.of(2026, 11, 2)
        );

        maintenanceService.addServiceRecord(record);

        verify(serviceRecordDao).addServiceRecord(record);
        verify(auditService).logActivity(
                "Service record added for: MH02XY9999"
        );
    }

    @Test
    void testGetMaintenanceAlerts() {
        List<Vehicle> vehicles = List.of(
                new Vehicle(0, "MH02AB1234", "Tata Ace",
                        18500, 12000, "ACTIVE"),

                new Vehicle(0, "MH04CD5678", "BharatBenz",
                        30999, 26000, "ACTIVE"),

                new Vehicle(0, "MH05GH3456", "Bolero Pickup",
                        28000, 23000, "ACTIVE")
        );

        when(vehicleDao.getAllVehicles()).thenReturn(vehicles);

        List<Vehicle> alerts =
                maintenanceService.getMaintenanceAlerts();

        assertEquals(2, alerts.size());
        assertTrue(alerts.stream().anyMatch(
                v -> v.getRegNumber().equals("MH02AB1234")
        ));
        assertTrue(alerts.stream().anyMatch(
                v -> v.getRegNumber().equals("MH05GH3456")
        ));
    }
}
