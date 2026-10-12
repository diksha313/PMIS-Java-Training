class Battery{
    int capacitymah;
    Battery(int capacitymah){
        this.capacitymah=capacitymah;
    }
    void drain(){
        System.out.println("Battery used.\nCapacity remaining:"+(capacitymah-100));
    }
}
class Camera{
    int pix;
    Camera(int pix){
        this.pix=pix;
    }
    void takePhoto(){
        System.out.println("Click... Captured a photo with "+pix+" sensor");
    }
}
class Phone{
    String brand;
    Battery battery;
    Camera camera;
    Phone(String brand,Battery battery,Camera camera){
        this.brand=brand;
        this.battery=battery;
        this.camera=camera;
    }
    void snapPicture(){
        System.out.println("["+brand+"] is active");
        camera.takePhoto();
        battery.drain();
    }

}