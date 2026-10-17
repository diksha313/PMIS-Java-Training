public class UserAccountRegistrationSystem {
    public static void main(String[] args) {
        System.out.println("Initial Users"+UserAccount.TotalUsers());
     
        UserAccount user1 = new UserAccount("Aarav");
        UserAccount user2 = new UserAccount("Priya");
        UserAccount user3 = new UserAccount("Rohan");

 
        System.out.println("Username: " + user1.Username());
        System.out.println("Username: " + user2.Username());
        System.out.println("Username: " + user3.Username());

        
        System.out.println("Total Users Registered: "
                + UserAccount.TotalUsers());
    }
}
    
