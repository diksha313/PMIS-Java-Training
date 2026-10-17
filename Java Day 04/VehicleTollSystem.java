class Vehicle {

    protected String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double calculateToll() {
        return 50.0;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

class Car extends Vehicle {

    public Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateToll() {
        return 50.0 + 20.0;
    }
}

class Truck extends Vehicle {

    private int axles;

    public Truck(String registrationNumber, int axles) {
        super(registrationNumber);
        this.axles = axles;
    }

    @Override
    public double calculateToll() {
        return 100.0 + (axles * 50.0);
    }
}

public class VehicleTollSystem {

    public static void main(String[] args) {

        Vehicle myCar = new Car("MH-04-AB-1234");

        Vehicle myTruck = new Truck("MH-43-XY-9999", 4);

        System.out.println(
            "Vehicle: " + myCar.getRegistrationNumber()
            + " | Toll Due: Rs " + myCar.calculateToll()
        );

        System.out.println(
            "Vehicle: " + myTruck.getRegistrationNumber()
            + " | Toll Due: Rs " + myTruck.calculateToll()
        );
    }
}