import java.util.Scanner;

public class Code11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in fahrenheit: ");
        double F = sc.nextDouble();

        double C = (F - 32) * 5 / 9;

        System.out.println(C);
        sc.close();
    }
}
