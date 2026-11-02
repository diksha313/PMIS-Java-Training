
package com.fleet.fleet_maintenance.dao;

import com.fleet.fleet_maintenance.model.FuelEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FuelEntryDaoTest {

    private JdbcTemplate jdbcTemplate;
    private FuelEntryDao fuelEntryDao;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        fuelEntryDao = new FuelEntryDao(jdbcTemplate);
    }

    @Test
    void testGetAllFuelEntries() {

        List<FuelEntry> entries = List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 12000)
        );

        when(jdbcTemplate.query(
                anyString(), any(RowMapper.class)
        )).thenReturn(entries);

        List<FuelEntry> result = fuelEntryDao.getAllFuelEntries();

        assertEquals(1, result.size());
        assertEquals("MH02XY9999", result.get(0).getRegNumber());
    }

    @Test
    void testGetFuelEntriesByVehicle() {

        List<FuelEntry> entries = List.of(
                new FuelEntry(1, "MH02XY9999",
                        new BigDecimal("30.00"),
                        new BigDecimal("3150.00"), 12000)
        );

        when(jdbcTemplate.query(
                anyString(), any(RowMapper.class), eq("MH02XY9999")
        )).thenReturn(entries);

        List<FuelEntry> result =
                fuelEntryDao.getFuelEntriesByVehicle("MH02XY9999");

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

        when(jdbcTemplate.update(
                anyString(),
                eq("MH02XY9999"),
                eq(new BigDecimal("30.00")),
                eq(new BigDecimal("3150.00")),
                eq(12000)
        )).thenReturn(1);

        int result = fuelEntryDao.addFuelEntry(entry);

        assertEquals(1, result);
    }
}

