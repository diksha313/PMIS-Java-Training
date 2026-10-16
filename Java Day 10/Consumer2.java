import java.util.function.*;
public class Consumer2 {
    public static void main(String[] args) {
        Consumer<String> phn = mobile->{
            System.out.println("Sending the OTP to the phone number:"+mobile);
        };
        phn.accept("8888888888");
    }
    
}
