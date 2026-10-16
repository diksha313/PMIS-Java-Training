import java.util.*;
import java.util.stream.*;
public class Lambda5 {
   public static void main(String[] args) {
    List<Integer> nums= List.of(5,12,8,3,20,7);
    List<Integer> result = nums.stream()
    .filter(n->n>=7)
    .collect(Collectors.toList());
    System.out.println(result);
    
   } 
}
