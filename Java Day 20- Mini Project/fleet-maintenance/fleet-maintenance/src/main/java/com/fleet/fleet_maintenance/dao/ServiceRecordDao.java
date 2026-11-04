package com.fleet.fleet_maintenance.dao;

import com.fleet.fleet_maintenance.model.ServiceRecord;
import com.fleet.fleet_maintenance.rowmapper.ServiceRecordRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServiceRecordDao {

    private final JdbcTemplate jdbcTemplate;

    public ServiceRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ServiceRecord> getAllServiceRecords() {

        String sql = "SELECT * FROM service_records";

        return jdbcTemplate.query(sql, new ServiceRecordRowMapper());
    }

    public List<ServiceRecord> getServiceRecordsByVehicle(String regNumber) {

        String sql = """
                SELECT * FROM service_records
                WHERE reg_number = ?
                """;

        return jdbcTemplate.query(
                sql, new ServiceRecordRowMapper(), regNumber
        );
    }

    public int addServiceRecord(ServiceRecord record) {

        String sql = """
                INSERT INTO service_records
                (reg_number, service_type, service_cost,
                 service_odometer, service_date)
                VALUES (?, ?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                record.getRegNumber(),
                record.getServiceType(),
                record.getServiceCost(),
                record.getServiceOdometer(),
                record.getServiceDate()
        );
    }
}
