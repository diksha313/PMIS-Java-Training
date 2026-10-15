class Pair<K,V>{
    private K key;
    private V value;

    Pair(K key,V value){
        this.key=key;
        this.value=value;
    }
    K getKey(){
        return key;
    }
    V getValue(){
        return value;
    }
}
public class gen1 {
    public static void main(String[] args) {
        Pair<String,Integer> p = new Pair<>("Age",25);
        String k = p.getKey();
        Integer v=p.getValue();
        System.out.println(k+":"+v);
    }
}
/*
class Pair {
    private Object key;
    private Object value;

    Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    Object getKey() {
        return key;
    }

    Object getValue() {
        return value;
    }
}

class gen {
    public static void main(String[] args) {
        Pair p = new Pair("Age", "test");

        String K = (String) p.getKey();
        Integer v = (Integer) p.getValue();
        System.out.println(K + ":" + v);
    }
}
*/