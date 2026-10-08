class BankAccount{
    String accountHolder;
    double balance;
    BankAccount(String accountHolder,double balance){
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    void deposit(double deposit){
        System.out.println("Original Balance- "+balance);
        balance+= deposit;
        System.out.println("New Balance - "+balance);
    }
    void withdraw(double withdraw){
        System.out.println("Original Balance - "+balance);
        if(balance>=withdraw){
        balance -= withdraw;
        System.out.println("New Balance - "+balance);
        }else{
        System.out.println("Insufficient Balance");
        }
    }
    void displayinfo(){
        System.out.println("Account Holder Name - "+accountHolder);
        System.out.println("Balance - "+balance);
    }
}
public class BankManagementSystem {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Diksha", 100000);
        b1.displayinfo();
        b1.deposit(5000);
        b1.withdraw(5000);
        b1.withdraw(100001);
        b1.displayinfo();
    }

}