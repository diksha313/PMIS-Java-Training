package com.fleet.fleet_maintenance.dao;

import com.fleet.fleet_maintenance.model.Vehicle;
import com.fleet.fleet_maintenance.rowmapper.VehicleRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VehicleDao {

    private final JdbcTemplate jdbcTemplate;

    public VehicleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vehicle> getAllVehicles() {

        String sql = "SELECT * FROM vehicles";

        return jdbcTemplate.query(sql, new VehicleRowMapper());
    }

    public Vehicle getVehicleByRegNumber(String regNumber) {

        String sql = "SELECT * FROM vehicles WHERE reg_number = ?";

        return jdbcTemplate.queryForObject(
                sql, new VehicleRowMapper(), regNumber
        );
    }

    public int addVehicle(Vehicle vehicle) {

        String sql = """
                INSERT INTO vehicles
                (reg_number, model, current_odometer,
                 last_service_odometer, status)
                VALUES (?, ?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                vehicle.getRegNumber(),
                vehicle.getModel(),
                vehicle.getCurrentOdometer(),
                vehicle.getLastServiceOdometer(),
                vehicle.getStatus()
        );
    }

    public int updateOdometer(String regNumber, int odometer) {

        String sql = """
                UPDATE vehicles
                SET current_odometer = ?
                WHERE reg_number = ?
                """;

        return jdbcTemplate.update(sql, odometer, regNumber);
    }

    public int deleteVehicle(String regNumber) {

        String sql = "DELETE FROM vehicles WHERE reg_number = ?";

        return jdbcTemplate.update(sql, regNumber);
    }
}
