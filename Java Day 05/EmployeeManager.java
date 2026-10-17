
//parent class
class Employee {
    String name;
    double salary;

    
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    void displayDetails() {
        System.out.println("Name: " +name);
        System.out.println("Salary: " +salary);
    }
}

//child class
class Manager extends Employee {
    String department;

    Manager(String name, double salary, String department) {
        super(name, salary); 
        this.department = department;
    }
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
        System.out.println("Role: Manager");
    }
}