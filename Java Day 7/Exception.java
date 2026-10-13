public class Exception{
    public static void main(String[] args) {
     int a=10;
     int b=0;
     try{
        int res =a/b;
        System.out.println(res);
     }catch(ArithmeticException e){
        System.out.println("You can't divide by 0");
     }

    }
}