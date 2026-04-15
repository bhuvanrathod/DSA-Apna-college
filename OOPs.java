

public class OOPs {
    public static void main(String[] args) {
        // Pen p1 = new Pen();
        // p1.Setcolor( "orange");
        // p1.Setcolor("green");
        // System.out.println(p1.getcolor());

        // p1.SetTip(4);
        // System.out.println(p1.getTip());



        // BankAccount b1 = new BankAccount();
        // b1.username = "bhuvanrathod";
        // b1.setPassword = "bhuvanra1234";
        // System.out.println(b1.password);

        // Student s1 = new Student();
        // Student s2 = new Student("bhuvan");
        // System.out.println(s1);

        Student s1 = new Student();
        s1.name = "bhuvan";
        s1.age = 123;
        s1.password = "Bhuvan2006@";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 90;

        Student s2 = new Student(s1);
        s2.password = "jdfvnidfbvd";
        s1.marks[2] = 97;
        for(int i=0; i<3; i++){
            System.out.println(s2.marks[i]);
        }


        System.out.println(s2.name+" "+s2.age+" "+s2.password);
        


    }
}

// class BankAccount {
//     public String username;
//     String password;

//     public void setPassword(String newPassword){
//         password = newPassword;
//     }
// }

// class Pen {
//     private String color;
//     private int Tip;

//     String getcolor(){      // getter
//         return color;
//     }

//     int getTip(){
//         return this.Tip;                        // this -> it is used during the class attribute and method attribute will be same
//     }                                           // the argument will be not pass then we can use (this)

//     void Setcolor(String newcolor){               // setter
//         color = newcolor;
//     }

//     void SetTip(int newTip){
//         Tip = newTip;
//     }
// }

class Student {
    String name;
    int age;
    String password;
    int marks[];

    //Shallow copy constructor
    // Student(Student s1) {
    //     this.name = s1.name;
    //     this.age = s1.age;
    //     this.marks = s1.marks;
    // }

    //Deep copy constructor
    Student(Student s1) {
        this.name = s1.name;
        this.age = s1.age;
        for(int i=0; i<3; i++){
            this.marks[i] = s1.marks[i];
        }
    }


    
    
    Student(){         // Non parameterized constructor
        System.out.println("Constructor is called.....");
        // this.marks = marks;
        marks = new int[3];
    }

    Student(String name){              // parameterized constructor
        this.name = name;
        marks = new int[3];
    }

    Student(int age){              // parameterized constructor
        this.age = age;
        marks = new int[3];
    }
}