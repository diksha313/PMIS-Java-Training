class Address{
    String city;
    String state;
    int pincode;
    Address(String city,String state,int pincode){
        this.city=city;
        this.state=state;
        this.pincode=pincode;
    }
    void displayAddress(){
        System.out.println(city+","+state+"-"+pincode);
    }
}
class Student{
    String name;
    int rollNo;
    Address address;
    Student(String name, int rollNo,Address address){
        this.name=name;
        this.rollNo=rollNo;
        this.address=address;
    }
    void displayDetails(){
        System.out.println("Student Name- "+name+"\nRoll no-"+rollNo);
        address.displayAddress();
    }

}