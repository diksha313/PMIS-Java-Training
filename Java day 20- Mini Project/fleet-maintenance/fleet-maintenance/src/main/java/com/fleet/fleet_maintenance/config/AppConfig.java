package com.fleet.fleet_maintenance.config;

import javax.sql.DataSource;
import com.fleet.fleet_maintenance.dao.VehicleDao;
import com.fleet.fleet_maintenance.dao.FuelEntryDao;
import com.fleet.fleet_maintenance.dao.ServiceRecordDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import com.fleet.fleet_maintenance.service.VehicleService;
import com.fleet.fleet_maintenance.service.FuelService;
import com.fleet.fleet_maintenance.service.MaintenanceService;
import com.fleet.fleet_maintenance.service.AuditService;
import com.fleet.fleet_maintenance.console.ConsoleMenu;


@Configuration
public class AppConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public VehicleDao vehicleDao(JdbcTemplate jdbcTemplate) {
        return new VehicleDao(jdbcTemplate);
    }

    @Bean
    public FuelEntryDao fuelEntryDao(JdbcTemplate jdbcTemplate) {
        return new FuelEntryDao(jdbcTemplate);
    }

    @Bean
    public ServiceRecordDao serviceRecordDao(JdbcTemplate jdbcTemplate) {
        return new ServiceRecordDao(jdbcTemplate);
    }
    @Bean
    public AuditService auditService() {
        return new AuditService();
    }

    @Bean
    public VehicleService vehicleService(
            VehicleDao vehicleDao,
            ServiceRecordDao serviceRecordDao,
            AuditService auditService) {

        return new VehicleService(
                vehicleDao,
                serviceRecordDao,
                auditService
        );
    }

    @Bean
    public FuelService fuelService(
            FuelEntryDao fuelEntryDao,
            VehicleDao vehicleDao,
            AuditService auditService) {
        return new FuelService(fuelEntryDao, vehicleDao, auditService);
    }

    @Bean
    public MaintenanceService maintenanceService(
            ServiceRecordDao serviceRecordDao,
            VehicleDao vehicleDao,
            AuditService auditService) {
        return new MaintenanceService(
                serviceRecordDao, vehicleDao, auditService
        );
    }
    @Bean
    public ConsoleMenu consoleMenu(
            VehicleService vehicleService,
            FuelService fuelService,
            MaintenanceService maintenanceService) {

        return new ConsoleMenu(
                vehicleService,
                fuelService,
                maintenanceService
        );
    }
}
