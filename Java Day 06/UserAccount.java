class UserAccount {
    private String username;
    private static int TotalUsers=0;
    UserAccount(String username){
        this.username=username;
        TotalUsers++;
    }
    public String Username(){
        return username;
    }
    public static int TotalUsers(){
        return TotalUsers;
    }
}
