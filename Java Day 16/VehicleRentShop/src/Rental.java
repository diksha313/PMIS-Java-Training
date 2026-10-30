public class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int daysRented;
    private double totalRent;

    public Rental(Vehicle vehicle, Customer customer, int daysRented) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.daysRented = daysRented;
        this.totalRent = vehicle.calculateRent(daysRented);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalRent() {
        return totalRent;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
