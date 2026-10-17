import java.util.*;

public class Code10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of terms");
        int n = sc.nextInt();
        int n1=0;
        int n2=1;
        System.out.print(n1+" "+n2+" ");
        for(int i=3;i<=n;i++){
            int n3= n1+n2;
            System.out.print(n3+" ");
            n1=n2;
            n2=n3;
        }
        sc.close();
    }
}
