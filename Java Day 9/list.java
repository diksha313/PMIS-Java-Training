import java.util.*;
public class list {
    public static void printList(List<?> list){
        for(Object o: list){
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anish","Varun","Diksha");
        List<Integer> nums=Arrays.asList(20,30);
        List<Double> prices=Arrays.asList(55.2,22.3);
        System.out.println("Name:");
        printList(names);
        System.out.println("\nNumbers");
        printList(nums);
        System.out.println("\nPrices");
        printList(prices);
    }
}
