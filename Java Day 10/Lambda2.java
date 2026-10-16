
import java.util.*;
public class Lambda2 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,5);
    
    List<Integer> result = new ArrayList<>();

    for(int n : nums){
        if(n%2==0){
            result.add(n * n);
        }
       
    } System.out.println(result);
}
}
