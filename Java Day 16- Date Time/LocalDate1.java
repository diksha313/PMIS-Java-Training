
 import java.time.LocalDate;
 import java.time.Month;


 class LocalDate1{
     public static void main(String[] args){
         LocalDate now = LocalDate.now();
         System.out.println("Todays date is: " + now);

         int dayOfMonth=now.getDayOfMonth();
         Month Month=now.getMonth();
         int Year = now.getYear();

         System.out.println("Day: " +dayOfMonth);
         System.out.println("Month: " +Month);
         System.out.println("Year: " +Year);
     }
 }