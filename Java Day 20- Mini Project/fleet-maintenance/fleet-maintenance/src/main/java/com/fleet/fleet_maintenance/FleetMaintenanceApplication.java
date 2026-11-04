package com.fleet.fleet_maintenance;

import com.fleet.fleet_maintenance.console.ConsoleMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FleetMaintenanceApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				SpringApplication.run(
						FleetMaintenanceApplication.class, args
				);

		ConsoleMenu menu = context.getBean(ConsoleMenu.class);

		menu.start();
	}
}
