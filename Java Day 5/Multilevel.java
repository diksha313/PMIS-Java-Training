
//parent class
class Device{
    void poweron(){
        System.out.println("Device powered on....");
    }
}

//child class 1
class dabbaPhone extends Device{
    void makeCall(){
        System.out.println("Calling the number....");
    }
}

//child class 2
class SmartPhone extends dabbaPhone{
    void browseInternet(){
        System.out.println("Opening Browser....");
    }
}

public class Multilevel {
    public static void main(String[] args){
        SmartPhone samsung=new SmartPhone();
        samsung.browseInternet();
        samsung.makeCall();
        samsung.poweron();
    }
}
