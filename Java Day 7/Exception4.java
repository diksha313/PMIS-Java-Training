
import java.io.*;
public class Exception4 {
    static void readfile()throws IOException{
        try (FileReader file =new FileReader("data.txt")){
        System.out.println("File Opened");
    }
    }
    public static void main(String[] args) {
        try {
            readfile();
        } catch (IOException e) {
            
            System.out.println("Could not find the file");
        }
        
    }

    
}