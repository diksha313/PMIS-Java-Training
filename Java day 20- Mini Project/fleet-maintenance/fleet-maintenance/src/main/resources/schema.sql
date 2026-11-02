
CREATE TABLE vehicles (
                          reg_number VARCHAR(20) PRIMARY KEY,
                          model VARCHAR(100) NOT NULL,
                          current_odometer INT NOT NULL,
                          last_service_odometer INT NOT NULL,
                          status VARCHAR(30) NOT NULL
);

CREATE TABLE fuel_entries (
                              entry_id INT AUTO_INCREMENT PRIMARY KEY,
                              reg_number VARCHAR(20) NOT NULL,
                              litres DECIMAL(8,2) NOT NULL,
                              cost DECIMAL(10,2) NOT NULL,
                              odometer_reading INT NOT NULL,
                              fuel_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                              CONSTRAINT fk_fuel_vehicle
                                  FOREIGN KEY (reg_number)
                                      REFERENCES vehicles(reg_number)
);

CREATE TABLE service_records (
                                 service_id INT AUTO_INCREMENT PRIMARY KEY,
                                 reg_number VARCHAR(20) NOT NULL,
                                 service_type VARCHAR(100) NOT NULL,
                                 service_cost DECIMAL(10,2) NOT NULL,
                                 service_odometer INT NOT NULL,
                                 service_date DATE NOT NULL,

                                 CONSTRAINT fk_service_vehicle
                                     FOREIGN KEY (reg_number)
                                         REFERENCES vehicles(reg_number)
);
