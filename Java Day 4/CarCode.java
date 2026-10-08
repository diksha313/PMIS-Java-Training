class Car{
    String brand;
    String colour;
    int speed;
    Car(String brand,String colour,int speed){
        this.brand=brand;
        this.colour=colour;
        this.speed=speed;
    }
    void displayinfo(){
        System.out.println(brand+"\n"+colour+"\n"+speed);
    }
    void incrspeed(int inc){
        System.out.println("Original speed is "+speed);
        speed+=inc;
        System.out.println("Increased speed is "+speed);

    }
}
public class CarCode {
    public static void main(String[] args) {
        Car c1= new Car("BMW","Blue",160);
        c1.displayinfo();
        c1.incrspeed(50);
    }
    
}