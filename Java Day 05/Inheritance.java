
class Animal{
    void eat(){
        System.out.println("The animal eats food");
    }
}

    class Dog extends Animal{
        void bark(){
            System.out.println("Dog barks boo boo");
        }
    
}

public class Inheritance {
    
    public static void main(String[] args){
        Dog myDog= new Dog();
        myDog.eat();
        myDog.bark();
    }
}
