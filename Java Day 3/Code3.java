import java.util.*;
public class Code3 {
    public static void largerNumber(int n1, int n2) {
    
    if(n1 > n2) {
        System.out.println("The larger number is: " + n1);
    } 
    else {
        System.out.println("The larger number is: " + n2);
    }
}
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a number");
       int n1 = sc.nextInt();
       System.out.println("Enter a number");
       int n2 = sc.nextInt();
       largerNumber(n1, n2);
       sc.close();
    }
}
