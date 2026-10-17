class Coffee{
    String studentName;
    double openDeposit;
    
    Coffee(String studentName,double openDeposit){
        this.studentName=studentName;
        this.openDeposit=openDeposit;
    }
    void addFunds(int funds){
        openDeposit+=funds;
        System.out.println("Total Funds - "+openDeposit);
    }
    void buyCoffee(int purchase){
        if(purchase<=openDeposit){
            openDeposit-=purchase;
            System.out.println("Purchase Amount - "+purchase);
            System.out.println("Total Funds - "+openDeposit);
        }else{
            System.out.println("Insufficient balance");
        }
    }
    void displayinfo(){
        System.out.println("Name - "+studentName+"\nCurrent Balance - "+openDeposit);
    }
}
public class CampusCoffeeCart {
    public static void main(String[] args) {
        
    
    Coffee c1 = new Coffee("Diksha", 500);
    c1.displayinfo();
    c1.addFunds(200);
    c1.buyCoffee(150);
    c1.buyCoffee(800);
    }
}
