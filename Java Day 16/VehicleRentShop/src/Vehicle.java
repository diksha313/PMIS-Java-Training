public abstract class Vehicle implements Rentable {
    private String id;
    private String model;
    private double dailyRate;
    private boolean isAvailable;

    public Vehicle(String id, String model, double dailyRate) {
        this.id = id;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    @Override
    public double calculateRent(int days) {
        return dailyRate * days;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }
}
