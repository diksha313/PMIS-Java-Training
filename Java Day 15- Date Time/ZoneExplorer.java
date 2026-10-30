import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.*;

//the user will enter the zone id and the time of that particular zone will get printed

public class ZoneExplorer{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);


        //this prints all the available zones         
        Set<String>availableZones=ZoneId.getAvailableZoneIds();
        System.out.println("Available time zones: ");
        availableZones.forEach(System.out::println);

        System.out.println("Enter the ZoneId: ");
        String zoneInput=sc.nextLine();

        try{
            ZoneId zone =ZoneId.of(zoneInput);
            ZonedDateTime currentTime = ZonedDateTime.now(zone);
            System.out.println("Time zone: "+ zone);
            System.out.println("Current date and time: " +currentTime);

        }
        catch(java.time.DateTimeException e){
            System.out.println("Invalid time zone! Please enter valid time zone id.");
        }
        sc.close();

    }
}
