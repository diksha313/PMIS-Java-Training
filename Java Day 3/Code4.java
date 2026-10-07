import java.util.*;

public class Code4 {
    public static int circumference(float radius) {
        float circum=2*3.14f*radius;
        return (int)circum;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter radius");
        float radius = sc.nextFloat();
        System.out.println("The circumference is: " + circumference(radius));
        sc.close();
    }
}
