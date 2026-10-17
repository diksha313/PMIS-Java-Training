
import java.util.Scanner;

public class String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Array must contain at least 2 elements");
            sc.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
                found = true;
            } else if (arr[i] < largest &&
                       (!found || arr[i] > secondLargest)) {
                secondLargest = arr[i];
                found = true;
            }
        }

        if (found) {
            System.out.println("Second largest element: " + secondLargest);
        } else {
            System.out.println("No second largest distinct element found");
        }

        sc.close();
    }
}