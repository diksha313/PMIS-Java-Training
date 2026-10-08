import java.util.Scanner;

public class Code8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Do you have a driving licence? (true/false): ");
        boolean drivingLic = sc.nextBoolean();

        if (age >= 18 && drivingLic) {
            System.out.println("You can drive");
        } else if (age >= 18) {
            System.out.println("You need a licence");
        } else if (drivingLic) {
            System.out.println("You need to be at least 18");
        } else {
            System.out.println("You need to be at least 18 and have a licence");
        }
    sc.close();
    }
}