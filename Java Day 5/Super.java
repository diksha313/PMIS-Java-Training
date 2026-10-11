
class Employee{
    double Salary=30000;
}

class SuperManager extends Employee{
    double Salary=60000;

    void displaySalary(){

        System.out.println("Manager salary: "+Salary);
        System.out.println("Employee salary: "+super.Salary);
    }
}