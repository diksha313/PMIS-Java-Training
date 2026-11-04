package com.fleet.fleet_maintenance.dao;

import com.fleet.fleet_maintenance.model.Vehicle;
import com.fleet.fleet_maintenance.rowmapper.VehicleRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Map;
import java.util.List;

public class VehicleDao {

    private final JdbcTemplate jdbcTemplate;

    public VehicleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vehicle> getAllVehicles() {

        String sql = """
            SELECT * FROM vehicles
            WHERE status != 'DELETED'
            """;

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
    public int updateStatus(String regNumber, String status) {

        String sql = """
            UPDATE vehicles
            SET status = ?
            WHERE reg_number = ?
            """;

        return jdbcTemplate.update(sql, status, regNumber);
    }
    public List<Map<String, Object>> getOperationalCostReport() {

        String sql = """
            SELECT
                v.reg_number,
                v.model,
                COALESCE(f.total_fuel_cost, 0) AS fuel_cost,
                COALESCE(s.total_service_cost, 0) AS maintenance_cost,
                COALESCE(f.total_fuel_cost, 0)
                    + COALESCE(s.total_service_cost, 0) AS total_cost
            FROM vehicles v
            LEFT JOIN (
                SELECT reg_number, SUM(cost) AS total_fuel_cost
                FROM fuel_entries
                GROUP BY reg_number
            ) f ON v.reg_number = f.reg_number
            LEFT JOIN (
                SELECT reg_number, SUM(service_cost) AS total_service_cost
                FROM service_records
                GROUP BY reg_number
            ) s ON v.reg_number = s.reg_number
            WHERE v.status != 'DELETED'
            ORDER BY v.reg_number
            """;

        return jdbcTemplate.queryForList(sql);
    }

    public int deleteVehicle(String regNumber) {

        String sql = """
        UPDATE vehicles
        SET status = 'DELETED'
        WHERE reg_number = ?
        AND status != 'DELETED'
        """;

        return jdbcTemplate.update(sql, regNumber);
    }
}
