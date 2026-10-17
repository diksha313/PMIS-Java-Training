/** 5 October **/

import java.util.Scanner;

public class Code10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;
        float average = (float) sum / 2;

        System.out.println("Sum = " + sum);
        System.out.println("Floating point average = " + average);

        sc.close();
    }
}