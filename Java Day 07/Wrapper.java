public class Wrapper {
    public static void main(String[] args) {
        String number ="10, 20, 30";
        int total=0;
        String[] arr=number.split(",");
        for(String num : arr){
            total+=Integer.parseInt(num.trim());
        }
        System.out.println("Sum of numbers-"+total);
    }
    
}
