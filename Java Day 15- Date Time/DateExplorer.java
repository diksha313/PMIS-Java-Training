

//Question
// Create a Java program called DateExplorer that asks the user to enter a date in the format yyyy-MM-dd. The program should then display a menu that allows the user to explore different details about that date.

// For example, the user enters 2026-10-26 and gets the following menu:

// Requirements
// 1. Ask the user to input a date using Scanner.
// 2. Use LocalDate.parse() to convert the input into a LocalDate object.
// 3. Use a switch statement to handle the menu options.
// 4. Use minusMonths() to look back by a number of months specified by the user.
// 5. Use getMonth(), getYear(), and getDayOfWeek() to display date information.
// 6. Use an if-else statement to check whether the entered year is a leap year.
// 7. Use a loop to keep displaying the menu until the user chooses Exit.
// 8. Create a DateExplorer class with methods such as displayMonth(), displayYear(), and lookBackMonths().




import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.util.Scanner;

public class DateExplorer {

    // Method to display the month
    public static void displayMonth(LocalDate date) {
        Month month = date.getMonth();
        System.out.println("Month: " + month);
    }

    // Method to display the year
    public static void displayYear(LocalDate date) {
        int year = date.getYear();
        System.out.println("Year: " + year);
    }

    // Method to display the day of the week
    public static void displayDayOfWeek(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        System.out.println("Day of Week: " + day);
    }

    // Method to look back by a given number of months
    public static void lookBackMonths(LocalDate date, int months) {
        LocalDate pastDate = date.minusMonths(months);
        System.out.println("Date " + months + " months ago: " + pastDate);
    }

    // Method to check whether the year is a leap year
    public static void checkLeapYear(LocalDate date) {
        int year = date.getYear();

        if (date.isLeapYear()) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a date
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        // Convert the input string into a LocalDate object
        LocalDate date = LocalDate.parse(input);

        int choice;

        // Keep displaying the menu until the user chooses Exit using do while so the program continues
        do {
            System.out.println("\n===== Date Explorer Menu =====");
            System.out.println("1. Display Month");
            System.out.println("2. Display Year");
            System.out.println("3. Display Day of Week");
            System.out.println("4. Look Back by Months");
            System.out.println("5. Check Leap Year");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            // Handle the menu options
            switch (choice) {
                case 1:
                    displayMonth(date);
                    break;

                case 2:
                    displayYear(date);
                    break;

                case 3:
                    displayDayOfWeek(date);
                    break;

                case 4:
                    System.out.print("Enter the number of months: ");
                    int months = sc.nextInt();
                    lookBackMonths(date, months);
                    break;

                case 5:
                    checkLeapYear(date);
                    break;

                case 6:
                    System.out.println("Exiting Date Explorer. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
