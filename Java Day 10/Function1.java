import java.util.function.*;;
public class Function1 {
    public static void main(String[] args){
        Function<String,Integer>getlength=name->name.length();
        System.out.println(getlength.apply("Java"));
        System.out.println(getlength.apply("John"));
    }

    
}
