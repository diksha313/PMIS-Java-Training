class Employee {

    // Private fields - Encapsulation
    private int id;
    private String name;
    private double salary;

    // Parameterized Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;

        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0.0;
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setter with validation
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative.");
        }
    }

    // Business logic method
    public void giveRaise(double percent) {
        if (percent > 0) {
            double raiseAmount = this.salary * (percent / 100.0);
            this.salary += raiseAmount;

            System.out.println(
                name + " received a " + percent +
                "% raise. New Salary: Rs." + this.salary
            );
        } else {
            System.out.println("Raise percentage must be positive.");
        }
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Employee emp = new Employee(101, "Alice", 50000.0);

        System.out.println("Initial Salary: Rs." + emp.getSalary());

        // Apply 8% raise
        emp.giveRaise(8);

        // Attempt to set negative salary
        emp.setSalary(-25000);

        // Final salary
        System.out.println(
            "Final Verified Salary: Rs." + emp.getSalary()
        );
    }
}
