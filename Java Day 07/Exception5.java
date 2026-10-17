public class Exception5 {
    public static void main(String[] args) {
        int balance=5000;
        int withdrawal=7000;
        try {
            if(withdrawal>balance){
                throw new IllegalArgumentException(
                    "Insufficient Balance"
                );
            }
            balance-=withdrawal;
            System.out.println("Withdrawal was successful");
            System.out.println("Remaining balance-"+balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Reason-"+e.getMessage());
        }
        System.out.println("Program completed");
    }
}
