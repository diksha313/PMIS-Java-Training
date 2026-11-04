package com.fleet.fleet_maintenance.model;

import java.math.BigDecimal;

public class FuelEntry {

    private int id;
    private String regNumber;
    private BigDecimal litres;
    private BigDecimal cost;
    private int odometerReading;

    public FuelEntry() {
    }

    public FuelEntry(int id, String regNumber, BigDecimal litres,
                     BigDecimal cost, int odometerReading) {
        this.id = id;
        this.regNumber = regNumber;
        this.litres = litres;
        this.cost = cost;
        this.odometerReading = odometerReading;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public BigDecimal getLitres() {
        return litres;
    }

    public void setLitres(BigDecimal litres) {
        this.litres = litres;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }
}