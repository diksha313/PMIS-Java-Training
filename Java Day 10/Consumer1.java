import java.util.function.*;
public class Consumer1 {
    public static void main(String[] args) {
        Consumer<String> pr = message -> System.out.println(message);
        pr.accept("Hello I love Cricket.");

    }
}
