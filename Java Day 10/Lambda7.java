import java.util.*;
import java.util.stream.*;
public class Lambda7 {
    public static void main(String[] args) {
        List<Integer> nums = List.of( 5,4,3,2,1,19);
        List<String> words = List.of("banana","fig","apple ");
        List<String> byLength= words.stream()
        .sorted((a,b)-> a.length()- b.length())
        .collect(Collectors.toList());

        List<Integer> res = nums.stream()
        .sorted()
        .collect(Collectors.toList());

        System.out.println(res);
        System.out.println(byLength);
}
}
