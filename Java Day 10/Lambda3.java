import java.util.*;
import java.util.stream.*;;

public class Lambda3 {
    public static void main(String[] args) {
        List<Integer> nums =Arrays.asList(1,2,3,4,5,5);

        List<Integer> res = nums.stream()
        .filter(n-> n%2==0)
        .map(n-> n*n)
        .collect(Collectors.toList());

        System.out.println(("OG List:"));
        System.out.println("Result:"+res);
    }
}
