public class App2 {
    public static void main(String[] args) {
        Address a1= new Address("Dombivali", "Maharashtra", 421201);
        Student s1= new Student("Diksha", 1,a1);
        s1.displayDetails();
    }
}
