import java.util.Scanner;

public class Code6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num 1: ");
        int num1 = sc.nextInt();

        System.out.print("Enter num 2: ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("num 1 > num 2");
        } else if (num2 > num1) {
            System.out.println("num 2 > num 1");
        } else {
            System.out.println("num 1 = num 2");
        }
        sc.close();
    }
}
