class BankAccount1 {

    private String holderName;
    private double balance;

    public BankAccount1(String holderName, double balance) {
        this.holderName = holderName;
        setBalance(balance);
    }

    // Getter for holderName
    public String getHolderName() {
        return holderName;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double amount) {
        if (amount >= 0) {
            balance = amount;
        } else {
            System.out.println("Invalid balance: cannot be negative!");
        }
    }
}

public class Encapsulation {

    public static void main(String[] args) {

        BankAccount1 acc = new BankAccount1("Alex", 500);

        acc.setBalance(-100);

        System.out.println(acc.getHolderName());
        System.out.println(acc.getBalance());
    }
}
