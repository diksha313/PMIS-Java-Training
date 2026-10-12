public class App3 {
    public static void main(String[] args) {
        Battery b1 =new Battery(450);
        Camera c1= new Camera(180);
        Phone p1= new Phone("iPhone",b1,c1);
        p1.snapPicture();

    }
    
}
