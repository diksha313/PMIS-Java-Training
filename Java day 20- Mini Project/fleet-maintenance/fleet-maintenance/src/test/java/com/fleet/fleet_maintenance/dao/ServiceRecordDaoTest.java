
package com.fleet.fleet_maintenance.dao;

import com.fleet.fleet_maintenance.model.ServiceRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceRecordDaoTest {

    private JdbcTemplate jdbcTemplate;
    private ServiceRecordDao serviceRecordDao;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        serviceRecordDao = new ServiceRecordDao(jdbcTemplate);
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

        when(jdbcTemplate.query(
                anyString(), any(RowMapper.class)
        )).thenReturn(records);

        List<ServiceRecord> result =
                serviceRecordDao.getAllServiceRecords();

        assertEquals(1, result.size());
        assertEquals("MH02XY9999", result.get(0).getRegNumber());
    }

    @Test
    void testGetServiceRecordsByVehicle() {

        List<ServiceRecord> records = List.of(
                new ServiceRecord(
                        1, "MH02XY9999", "OIL_CHANGE",
                        new BigDecimal("2500.00"),
                        12000, LocalDate.of(2026, 11, 2)
                )
        );

        when(jdbcTemplate.query(
                anyString(), any(RowMapper.class), eq("MH02XY9999")
        )).thenReturn(records);

        List<ServiceRecord> result =
                serviceRecordDao.getServiceRecordsByVehicle("MH02XY9999");

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

        when(jdbcTemplate.update(
                anyString(),
                eq("MH02XY9999"),
                eq("OIL_CHANGE"),
                eq(new BigDecimal("2500.00")),
                eq(12000),
                eq(LocalDate.of(2026, 11, 2))
        )).thenReturn(1);

        int result = serviceRecordDao.addServiceRecord(record);

        assertEquals(1, result);
    }
}

