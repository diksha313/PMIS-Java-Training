import java.util.*;
import java.util.stream.*;

public class Lambda4 {
    public static void main(String[] args) {
        List<String> list= List.of("a","b","c");
        System.out.println("Stream from a list:");
        list.stream().forEach(System.out::println);

        int[] arr={1,2,3};
        Arrays.stream(arr).forEach(System.out::println);
        Stream.of("x","y","z").forEach(System.out::println);
        IntStream.range(1, 5).forEach(System.out::println);   
        }
    }

