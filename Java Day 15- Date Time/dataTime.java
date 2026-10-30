import java.time.LocalDate;

//for printing the date manually
 class dataTime{
     public static void main(String[] args) {
         LocalDate now =LocalDate.now();

         LocalDate customDate=LocalDate.of(2026, 12, 31);
         System.out.println(customDate);

         int dayOfMonth=now.getDayOfMonth();
         int Month=now.getMonthValue();
         int Year=now.getYear();

         System.out.println("Day: " +dayOfMonth);
         System.out.println("Month: " +Month);
         System.out.println("Year: " +Year);

     }
 }
