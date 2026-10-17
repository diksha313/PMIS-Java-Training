import java.util.*;

public class Wrapper3 {
    public static void main(String[] args) {
        List<Integer> numbers= new ArrayList<>();
        numbers.add(13);
        numbers.add(14);
        numbers.add(40);
        numbers.add(45);
        numbers.add(56);
        numbers.add(79);
        List<Integer> even=new ArrayList<>();
        for (Integer num : numbers){
            if(num%2==0){
                even.add(num);
            }
        }
        System.out.println("Even num"+even);
    }
}
