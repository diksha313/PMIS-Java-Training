import java.util.function.Predicate;

public class Predicate1 {
    public static void main(String[] args) {
        Predicate<Integer> isAdult = age->age >=18;

        System.out.println(isAdult.test(20));
        System.out.println(isAdult.test(15));
    }
}
