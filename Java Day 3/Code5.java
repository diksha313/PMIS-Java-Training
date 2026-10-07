/**Write a function that takes in age as input and returns if that person is eligible to vote or not. A person of age > 18 is eligible to vote.  */
import java.util.Scanner;
public class Code5 {
    public static void isEligibleToVote(int age) {
        if(age >= 18) {
            System.out.println("The person is eligible to vote");
        } else {
            System.out.println("The person is not eligible to vote");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age");
        int age = sc.nextInt();
        isEligibleToVote(age);
        sc.close();
    }
}
