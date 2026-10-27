public class Main {
    public static void main(String[] args) {

        RentableShop shop = new RentableShop();

        Car car = new Car("C1", "Swift", 1500);
        Bike bike = new Bike("B1", "Activa", 400);
        Truck truck = new Truck("T1", "Tata Ace", 2500);

        shop.addVehicle(car);
        shop.addVehicle(bike);
        shop.addVehicle(truck);

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");

        try {
            shop.rent("B1", asha, 8);
            shop.rent("T1", ravi, 2);

            try {
                shop.rent("B1", ravi, 3);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            shop.giveBack("T1");

            shop.showAvailable();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
