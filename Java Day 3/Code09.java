import java.util.Scanner;

public class Code09 {
    public static int GCD(int a, int b){
        int GCD=1;
        for(int i=1;i<=a && i<=b; i++){
            if(a%i==0 && b%i==0){
                GCD=i;
            }
        }
        return GCD;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number 1 ");
        int a = sc.nextInt();
        System.err.println("Enter number 2 ");
        int b = sc.nextInt();
        System.out.println("GCD of "+a+" & " +b+" is "+GCD(a,b));
        sc.close();
    }
}
