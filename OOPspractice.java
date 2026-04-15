public class OOPspractice {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "bhuvan";
        s1.rollno = 12;
        System.out.println(s1.name+" "+s1.rollno);
    }
}

class Student{
    String name;
    int rollno;
}