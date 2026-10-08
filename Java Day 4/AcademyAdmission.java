class StudentProfile{
    String fullName;
    int rollNum;
    float examScore;
    StudentProfile(String fullName,int rollNum,float examScore){
        this.fullName=fullName;
        this.rollNum=rollNum;
        this.examScore=examScore;
    }
    StudentProfile(String fullName,int rollNum){
        this.fullName=fullName;
        this.rollNum=rollNum;
        this.examScore=0.0f;
    }
    void reportCard(){
        if(examScore>=90){
            System.out.println("Grade - A");
        }else if(examScore>=75 ){
            System.out.println("Grade - B");
        }else if(examScore>=50){
            System.out.println("Grade - C");
        }else{
            System.out.println("Grade - F");
        }
        
        }
    void displayinfo(){
        System.out.println("Name - "+fullName);
        System.out.println("Roll Num - "+rollNum);
        System.out.println("Score - "+examScore);
        
    }
}
public class AcademyAdmission{
    public static void main(String[] args) {
        StudentProfile s1= new StudentProfile("Diksha", 1, 82.5f);
        StudentProfile s2= new StudentProfile("Bhumi", 30);
        s1.displayinfo();
        s1.reportCard();
        s2.displayinfo();
        s2.reportCard();
    }
}
