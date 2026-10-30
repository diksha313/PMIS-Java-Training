
import java.util.List;
import java.util.ArrayList;

public class RentableShop {
    private List<Vehicle> vehicles;

    public RentableShop() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Rental rent(String vehicleId, Customer customer, int days)
            throws Exception {

        if (days <= 0) {
            throw new Exception(
                    "Invalid rental duration. Days must be greater than 0."
            );
        }

        Vehicle selectedVehicle = null;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(vehicleId)) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            throw new Exception(
                    "Vehicle with ID " + vehicleId + " not found."
            );
        }

        if (!selectedVehicle.isAvailable()) {
            throw new Exception(
                    selectedVehicle + " is already rented"
            );
        }

        Rental rental = new Rental(selectedVehicle, customer, days);

        selectedVehicle.setAvailable(false);
        customer.addRental(rental);

        System.out.printf(
                "%s rented %s for %d days = %.2f%n",
                customer.getName(),
                selectedVehicle,
                days,
                rental.getTotalRent()
        );

        return rental;
    }

    public void giveBack(String vehicleId) throws Exception {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(vehicleId)) {
                vehicle.setAvailable(true);
                return;
            }
        }

        throw new Exception("Vehicle " + vehicleId + " not found");
    }

    public void showAvailable() {
        System.out.println("Available vehicles:");

        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println("  " + vehicle);
            }
        }
    }
}


