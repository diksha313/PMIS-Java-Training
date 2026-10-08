import java.util.Scanner;

public class Code07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();

        if (num1 < 0) {
            System.out.println(num1 + " is negative");
        } else if (num1 > 0) {
            System.out.println(num1 + " is positive");
        } else {
            System.out.println("The number is zero");
        }
    sc.close();
    }
}
