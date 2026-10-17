import java.util.*;
public class Exception6 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a");
        int a= sc.nextInt();
        System.out.println("Enter b");
        int b= sc.nextInt();
        try{
            int res=a/b;
            System.out.println("Result-"+res);
        }catch(ArithmeticException e){
            System.out.println("Reason-"+e.getMessage());
        }
        sc.close();
    }
}
