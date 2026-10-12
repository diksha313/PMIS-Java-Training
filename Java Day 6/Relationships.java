class Engine{
    void start(){
        System.out.println("Engine is starting...");
    }
}
class Car{
    private Engine engine;
    Car(){
        this.engine= new Engine();
    }
    void drive(){
        engine.start();
        System.out.println("Car is moving...");
    }
}