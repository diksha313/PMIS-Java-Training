public class Exception1 {
    public static void main(String[] args) {
        try {
            int res=10/0;
            System.out.println(res);
            int[] arr={10,20};
            System.out.println(arr[5]);
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by 0");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array is out of bounds.");
        }
    }
}
