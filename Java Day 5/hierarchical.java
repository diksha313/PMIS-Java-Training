
class Shape{
    String color="Red";
}

class Circle extends Shape{
    void drawCircle(){
        System.out.println("Drawing a "+color+" Circle");
    }
}

class Triangle extends Shape{
    void drawTriangle(){
        System.out.println("Drawing a "+color+" Triangle");
    }
}


public class hierarchical{
    public static void main(String[] args){
        Circle c = new Circle();
        Triangle t = new Triangle();

        c.drawCircle();
        t.drawTriangle();
    }
    
}
