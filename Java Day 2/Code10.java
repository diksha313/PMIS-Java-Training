import java.util.*;

public class Code10{

    public static void main(String[] args){
       
        System.out.println("1.Square");
        System.out.println("2.Traingle");
        System.out.println("3.Rectangle");

         Scanner sc = new Scanner(System.in);
         System.out.println("Enter your choice");
         int choice = sc.nextInt();
    
    switch(choice){

        case 1:
            System.out.println("Square");
            System.out.println("Enter side of square: ");
            int side=sc.nextInt();
            int Area=side*side;
            System.out.println("Area of Square: " +Area);
            break;

        case 2:
            System.out.println("Triangle");
            System.out.println("Enter base of triangle: ");
            int base=sc.nextInt();

            System.out.println("Enter height of triangle: ");
            int height=sc.nextInt();

            int Area1=(base*height)/2;
            System.out.println("Area of Triangle: " +Area1);
            break;

        case 3:
            System.out.println("Rectangle");
            System.out.println("Enter length of rectangle: ");
            int length=sc.nextInt();

            System.out.println("Enter width of rectangle: ");
            int Breadth=sc.nextInt();
            
            int Area2=length*Breadth;
            System.out.println("Area of Rectangle: " +Area2);
            break;

        default:
            System.out.println("Invalid choice");
            
            

    }
    sc.close();
}
}
