import java.util.function.*;;
public class Square {
    public static void main(String[] args){
        Function<Double,Double>getArea= side -> side*side;
        System.out.println(getArea.apply(4d));
        System.out.println(getArea.apply(90d));
    }
}
    