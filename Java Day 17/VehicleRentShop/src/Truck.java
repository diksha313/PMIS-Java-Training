public class Truck extends Vehicle{
private static final double InsuranceFee = 500.0; // Fixed insurance fee for trucks

    public Truck(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }
    @Override
    public double calculateRent(int days) {
        double rent = getDailyRate() * days + InsuranceFee; // Add insurance fee to the rent
        return rent;
    }
}
