
package com.fleet.fleet_maintenance.service;

import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.dao.ServiceRecordDao;
import com.fleet.fleet_maintenance.model.Vehicle;
import com.fleet.fleet_maintenance.model.ServiceRecord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleServiceTest {

    private VehicleDao vehicleDao;
    private ServiceRecordDao serviceRecordDao;
    private AuditService auditService;
    private VehicleService vehicleService;

    @BeforeEach
    void setUp() {
        vehicleDao = mock(VehicleDao.class);
        serviceRecordDao = mock(ServiceRecordDao.class);
        auditService = mock(AuditService.class);

        vehicleService = new VehicleService(
                vehicleDao,
                serviceRecordDao,
                auditService
        );
    }

    @Test
    void testGetAllVehicles() {
        List<Vehicle> vehicles = List.of(
                new Vehicle(0, "MH02XY9999", "Test Truck",
                        12000, 8000, "ACTIVE")
        );

        when(vehicleDao.getAllVehicles()).thenReturn(vehicles);

        List<Vehicle> result = vehicleService.getAllVehicles();

        assertEquals(1, result.size());
        assertEquals("MH02XY9999", result.get(0).getRegNumber());
    }

    @Test
    void testGetVehicle() {
        Vehicle vehicle = new Vehicle(
                0, "MH02XY9999", "Test Truck",
                12000, 8000, "ACTIVE"
        );

        when(vehicleDao.getVehicleByRegNumber("MH02XY9999"))
                .thenReturn(vehicle);

        Vehicle result = vehicleService.getVehicle("MH02XY9999");

        assertEquals("Test Truck", result.getModel());
    }

    @Test
    void testAddVehicle() {
        Vehicle vehicle = new Vehicle(
                0, "MH02XY9999", "Test Truck",
                12000, 8000, "ACTIVE"
        );

        vehicleService.addVehicle(vehicle);

        verify(vehicleDao).addVehicle(vehicle);

        verify(serviceRecordDao).addServiceRecord(
                argThat(record ->
                        record.getRegNumber().equals("MH02XY9999")
                                && record.getServiceType().equals("BASELINE")
                                && record.getServiceCost().compareTo(BigDecimal.ZERO) == 0
                                && record.getServiceOdometer() == 8000
                )
        );

        verify(auditService).logActivity(
                "Vehicle added with baseline service record: MH02XY9999"
        );
    }

    @Test
    void testUpdateOdometer() {
        Vehicle vehicle = new Vehicle(
                0, "MH02XY9999", "Test Truck",
                12000, 8000, "ACTIVE"
        );

        when(vehicleDao.getVehicleByRegNumber("MH02XY9999"))
                .thenReturn(vehicle);

        vehicleService.updateOdometer("MH02XY9999", 15000);

        verify(vehicleDao).updateOdometer("MH02XY9999", 15000);
        verify(auditService).logActivity(
                "Odometer updated for: MH02XY9999"
        );
    }

    @Test
    void testUpdateOdometerWithLowerReading() {
        Vehicle vehicle = new Vehicle(
                0, "MH02XY9999", "Test Truck",
                12000, 8000, "ACTIVE"
        );

        when(vehicleDao.getVehicleByRegNumber("MH02XY9999"))
                .thenReturn(vehicle);

        assertThrows(IllegalArgumentException.class,
                () -> vehicleService.updateOdometer("MH02XY9999", 10000));

        verify(vehicleDao, never())
                .updateOdometer(anyString(), anyInt());
    }

    @Test
    void testDeleteVehicle() {
        when(vehicleDao.deleteVehicle("MH02XY9999")).thenReturn(1);

        vehicleService.deleteVehicle("MH02XY9999");

        verify(vehicleDao).deleteVehicle("MH02XY9999");

        verify(auditService).logActivity(
                "Vehicle deleted: MH02XY9999"
        );
    }
}
