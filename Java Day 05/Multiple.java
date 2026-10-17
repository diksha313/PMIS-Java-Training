
//Java doesnt supports multiple inheritance because on child class cannot inherits properties from more than 1 parent class
//so we will acheive this using a interface keyword



interface Mother{
    void message();
}

//parent 2
interface Father{
    void message();
}

//child class inheriting properties from mother and father
class Child implements Mother,Father{
    @Override    //same methods but different parameters
    public void message(){
        System.out.println("Loving both mom and dad");
    }
}

public class Multiple{
    public static void main(String[] args){
        Child c = new Child();
        c.message();

        Mother m = new Child();
        m.message();

        Father f = new Child();
        f.message();
    }
}