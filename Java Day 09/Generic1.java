class Box<T>{
    private T item;
    void set(T item){
        this.item=item;
    }
    T get(){
        return item;
    }
}
public class Generic1 {
    public static void main(String[] args){
        Box<String> box=new Box<>();
        box.set("hello");
            String s =box.get();
            System.out.println(s);

    }

}


/*
1.com */
