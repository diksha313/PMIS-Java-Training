public class Exception2 {
    public static void main(String[] args) {
        try {
            int res = 10/5;
            System.out.println(res);
        } catch (ArithmeticException e) {
            System.out.println("It cannot be divide by zero");
        }finally{
            System.out.println("Program executed");
        }
    }
}
