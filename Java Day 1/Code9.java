import java.util.Scanner;

public class Code9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you know Python? (Yes/No): ");
        String python = sc.nextLine();

        System.out.print("Do you know French? (Yes/No): ");
        String french = sc.nextLine();

        if (python.equalsIgnoreCase("Yes") && french.equalsIgnoreCase("No")) {
            System.out.println("You need to learn French.");
        } else if (python.equalsIgnoreCase("No") && french.equalsIgnoreCase("Yes")) {
            System.out.println("You need to learn Python.");
        } else if (python.equalsIgnoreCase("Yes") && french.equalsIgnoreCase("Yes")) {
            System.out.println("You can Apply.");
        } else {
            System.out.println("You need to learn Python and French.");
        }

        sc.close();
    }
}
