public class Bike extends Vehicle{
    public Bike(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }
    @Override
    public double calculateRent(int days) {
        double rent = getDailyRate() * days;
        if (days > 7) {
            rent *= 0.9; // Apply a 10% discount for rentals longer than 7 days
        }
        return rent;
    }

}
