import java.util.*;
public class Code08 {
    public static void main(String[] args) {
        int ex=1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x");
        int x= sc.nextInt();
        System.out.println("Enter n");
        int n= sc.nextInt();
        for (int i=1;i<=n; i++){
            ex = x*ex;
        }
        System.out.println(ex);
        sc.close();
    }
}
