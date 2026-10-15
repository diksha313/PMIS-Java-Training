import java.util.*;
public class gen4{
    static double sum(List<? extends Number>list){
        double total=0;
        for(Number n : list){
        total+=n.doubleValue();
        }
        return total;
    }

public static void main (String[] args){
    List<Integer> integers = List.of(1, 2, 3);
    List<Float> floats = List.of(1.6f, 2.5f, 3.7f);
    List<Double> decimals = List.of(1.5, 2.8, 3.9);

    System.out.println(sum(integers));
    System.out.println(sum(floats));
    System.out.println(sum(decimals));

    
}
}
