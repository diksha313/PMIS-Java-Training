
package com.fleet.fleet_maintenance.dao;

import com.fleet.fleet_maintenance.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleDaoTest {

    private JdbcTemplate jdbcTemplate;
    private VehicleDao vehicleDao;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        vehicleDao = new VehicleDao(jdbcTemplate);
    }

    @Test
    void testGetAllVehicles() {

        List<Vehicle> vehicles = List.of(
                new Vehicle(0, "MH02XY9999", "Test Truck",
                        12000, 8000, "ACTIVE")
        );

        when(jdbcTemplate.query(
                anyString(), any(RowMapper.class)
        )).thenReturn(vehicles);

        List<Vehicle> result = vehicleDao.getAllVehicles();

        assertEquals(1, result.size());
        assertEquals("MH02XY9999", result.get(0).getRegNumber());
    }

    @Test
    void testGetVehicleByRegNumber() {

        Vehicle vehicle = new Vehicle(
                0, "MH02XY9999", "Test Truck",
                12000, 8000, "ACTIVE"
        );

        when(jdbcTemplate.queryForObject(
                anyString(), any(RowMapper.class), eq("MH02XY9999")
        )).thenReturn(vehicle);

        Vehicle result = vehicleDao.getVehicleByRegNumber("MH02XY9999");

        assertEquals("Test Truck", result.getModel());
    }

    @Test
    void testAddVehicle() {

        Vehicle vehicle = new Vehicle(
                0, "MH02XY9999", "Test Truck",
                12000, 8000, "ACTIVE"
        );

        when(jdbcTemplate.update(
                anyString(),
                anyString(),
                anyString(),
                anyInt(),
                anyInt(),
                anyString()
        )).thenReturn(1);

        int result = vehicleDao.addVehicle(vehicle);

        assertEquals(1, result);
    }

    @Test
    void testUpdateOdometer() {

        when(jdbcTemplate.update(
                anyString(), eq(15000), eq("MH02XY9999")
        )).thenReturn(1);

        int result = vehicleDao.updateOdometer("MH02XY9999", 15000);

        assertEquals(1, result);
    }

    @Test
    void testDeleteVehicle() {

        when(jdbcTemplate.update(
                anyString(), eq("MH02XY9999")
        )).thenReturn(1);

        int result = vehicleDao.deleteVehicle("MH02XY9999");

        assertEquals(1, result);
    }
}

