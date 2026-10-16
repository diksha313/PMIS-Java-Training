import java.util.Random;
import java.util.function.*;
public class Supplier1 {
    public static void  main (String []args){
        Supplier<String> otpgen= () -> {
            Random random = new Random();
            int number=100000 + random.nextInt(9000000);
            return String.valueOf(number);
        };
        String userOtp=otpgen.get();
        System.out.println("The otp is "+userOtp);
    }

}