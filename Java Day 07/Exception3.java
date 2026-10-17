import java.util.*;
public class Exception3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter age");
        int age=sc.nextInt();
        sc.close();
        if(age<0){
            throw new IllegalArgumentException(
                "Age cannot be negative"
            );
            
        } 
        System.out.println("Program done");
    }
} 
        
