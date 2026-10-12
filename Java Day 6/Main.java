public class Main {
    public static void main(String[] args) {

        Shape s1 = new Circle(7.7);
        s1.setColor("Orange");

        System.out.println("Circle");
        System.out.println("Colour: " + s1.getcolor());
        System.out.println("Area: " + s1.calculateArea());

        Shape s2 = new Rectangle(10, 8.5);
        s2.setColor("Blue");

        System.out.println("\nRectangle");
        System.out.println("Colour: " + s2.getcolor());
        System.out.println("Area: " + s2.calculateArea());
    }
}