public class Wrapper2 {
    public static void main(String[] args) {
        String text= "Addison@0109";
        int upper=0, lower=0,symbol=0,num=0;
        for(char ch :text.toCharArray()){
            if(Character.isUpperCase(ch)){
                upper++;
            }else if(Character.isLowerCase(ch)){
                lower++;
            }else if(Character.isDigit(ch)){
                num++;
            }else{
                symbol++;
            }
        }
        System.out.println("Uppercase-"+upper);
        System.out.println("Lowercase-"+lower);
        System.out.println("Digits-"+num);
        System.out.println("Symbol-"+symbol);
    }
}
