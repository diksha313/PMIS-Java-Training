import java.util.Scanner;
public class Arrays {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n= sc.nextInt();
        int[] arr= new int[n];
        System.out.println("Enter"+n+" elements");
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=arr[i];
        }
        int av =sum/n;
        System.out.println("Sum-"+sum);
        System.out.println("Average"+av);
        sc.close();
    }
}
