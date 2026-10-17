import java.util.*;
public class Code02 {
    static int sumOddNumbers(int n) {
    int sum=0;
    for(int i=1;i<=n;i++){
        if(i%2!=0){
            sum=sum+i;
        }
    }
    return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int result =Code02.sumOddNumbers(n);
        System.out.println("The sum of odd numbers from 1 to " + n + " is " + result);
        sc.close();
    }
}
