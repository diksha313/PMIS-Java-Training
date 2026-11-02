package com.fleet.fleet_maintenance.dao;

import com.fleet.fleet_maintenance.model.FuelEntry;
import com.fleet.fleet_maintenance.rowmapper.FuelEntryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FuelEntryDao {

    private final JdbcTemplate jdbcTemplate;

    public FuelEntryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FuelEntry> getAllFuelEntries() {

        String sql = "SELECT * FROM fuel_entries";

        return jdbcTemplate.query(sql, new FuelEntryRowMapper());
    }

    public List<FuelEntry> getFuelEntriesByVehicle(String regNumber) {

        String sql = """
                SELECT * FROM fuel_entries
                WHERE reg_number = ?
                """;

        return jdbcTemplate.query(
                sql, new FuelEntryRowMapper(), regNumber
        );
    }

    public int addFuelEntry(FuelEntry entry) {

        String sql = """
                INSERT INTO fuel_entries
                (reg_number, litres, cost, odometer_reading)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                entry.getRegNumber(),
                entry.getLitres(),
                entry.getCost(),
                entry.getOdometerReading()
        );
    }
}