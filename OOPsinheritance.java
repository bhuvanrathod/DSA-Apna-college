// public class OOPsinheritance {
//     public static void main(String[] args) {

        // single level inheritance
        // Fish whale = new Fish();
        // whale.eats();
        // whale.swims();
        // whale.breath();

        // multilevel inheritance

        
//     }
// }

// Single level inheritance

// base/parent  class
// class Animal{
//     String color;

//     void eats(){
//         System.out.println("eats");
//     }
//     void breath(){
//         System.out.println("breaths");
//     }

// }

// // subclass/child/derived

// class Fish extends Animal{
//     int fins;

//     void swims(){
//         System.out.println("swim in water");
//     }
// }

// multi level inheritance

// public class OOPsinheritance {
//     public static void main(String[] args) {
//         Dog haski = new Dog();
//         haski.eats();
//         haski.breath();
//         haski.breed = "golden ratriver";
//         haski.legs = 4;
//         haski.color = "golde";
//         System.out.println(haski.breed+" "+ haski.legs+" "+haski.color);
//     }
// }


// // multi level inheritance

// class Animal{
//     String color;

//     void eats(){
//         System.out.println("eats");
//     }
//     void breath(){
//         System.out.println("breaths");
//     }

// }

// class Mammal extends Animal{
//     int legs;
// }

// class Dog extends Mammal{
//     String breed;
// } 

// hierachical inheritance

// public class OOPsinheritance {
//     public static void main(String[] args) {
//         Fish shark = new Fish();
//         shark.swim();
//         shark.eats();
//         shark.breath();
//     }
// }


// // hierachical inheritance

// class Animal{
//     String color;

//     void eats(){
//         System.out.println("eats");
//     }
//     void breath(){
//         System.out.println("breaths");
//     }

// }

// class Mammal extends Animal{
//     void walk(){
//         System.out.println("walk on land");
//     }
// }

// class Fish extends Animal{
//     String breed;
//     void swim(){
//         System.out.println("swim in water");
//     }
// } 

// hybrid inheritance

// public class OOPsinheritance {
//     public static void main(String[] args) {
//         Dog maggi = new Dog();
//         maggi.eats();
//         maggi.breath();
//         maggi.type();
//         maggi.walk();

//     }
// }


// // hybrid inheritance

// class Animal{
//     String color;

//     void eats(){
//         System.out.println("eats");
//     }
//     void breath(){
//         System.out.println("breaths");
//     }

// }

// class Mammal extends Animal{
//     void walk(){
//         System.out.println("walk on land");
//     }
// }

// class Dog extends Mammal{
//     void type(){
//         System.out.println("golden dog");
//     }
// }
// class Fish extends Animal{
//     String breed;
//     void swim(){
//         System.out.println("swim in water");
//     }
// } 

// class Tuna extends Fish{
//     void swimspeed(){
//         System.out.println("30 kmph");
//     }
// }

// class Bird extends Animal{
//     void fly(){
//         System.out.println("fly");
//     }
// }

// class Parrot extends Bird {
//     void maleorfemale(){
//         System.out.println("male bird");
//     }
// }

// method overloading

// public class OOPsinheritance{
//     public static void main(String[] args) {
//         Calculator calc = new Calculator();
//         System.out.println(calc.sum(1,2));
//         System.out.println(calc.sum((float)3.2,(float)3.4));
//         System.out.println(calc.sum(32,34,22));
//     }
// }

// class Calculator{
//     int sum(int a,int b){
//         return a + b;
//     }
//     float sum(float a,float b){
//         return a + b;
//     }
//     int sum(int a,int b,int c){
//         return a + b +c;
//     }
    
// }

// method overriding

// public class OOPsinheritance{
//     public static void main(String[] args) {
//         Deer d = new Deer();
//         d.eat();                          // it will call derived class 
//     }
// }

// class Animal{
//     void eat(){
//         System.out.println("it will be eat");
//     }
// }

// class Deer extends Animal{
//     void eat(){
//         System.out.println("eat grass");
//     }
// }

// abstraction

// public class OOPsinheritance{
//     public static void main(String[] args) {
//         Horse h = new Horse();
//         // h.walk();
//         // h.eat();
        
        
        

//         // Chiken c = new Chiken();
//         // c.eat();
//         // c.walk();                      
//     }
// }

// abstract class Animal{
//     Animal(){
//         System.out.println("animal constructor called");
//     }
//     // public Animal() {
//     //     color = "brown";
//     // }

    
//     void eat(){
//         System.out.println("eats");
//     }
//     abstract void walk();
// }

// class Horse extends Animal{

//     public Horse() {
//         System.out.println("horse constructor called..");
//     }

    
//     // void changecolor(){
//     //     color = "light brown";
//     // }
//     void walk(){
//         System.out.println("walk on 4 legs");
//     }
// }

// class Chiken extends Animal{

//     public Chiken() {
//         System.out.println("choken constructor called");
//     }
    
//     // void changecolor(){
//     //     color = "yello";
//     // }
//     void walk(){
//         System.out.println("walk on 2 legs");
//     }
// }

// interface

// public class OOPsinheritance{
//     public static void main(String[] args) {
//         Queen q = new Queen();
//         q.moves();
//     }
// }

// interface chessplayer{
//     void moves();               // blue printof the class
// }

// class Queen implements chessplayer{
//     public void moves(){
//         System.out.println("up,down,right,left(in all direction)");
//     }
// }

// class Rook implements chessplayer{
//     public void moves(){
//         System.out.println("up,down,right");
//     }
// }

// class King implements chessplayer{
//     public void moves(){
//         System.out.println("up,down,right,left(in one step)");
//     }
// }

// static keyword

// public class OOPsinheritance{
//     public static void main(String[] args) {
//         Student s1 = new Student();
//         s1.schoolname = "jmv";

//         Student s2 = new Student();
//         System.out.println(s2.schoolname);
//         System.out.println((int)s2.calpercentage(98,99,97));  // we have type cast to print value ,or etc... of function 
//     }
// }

// class Student{
//     String name;
//     int rollno;

//     static int calpercentage(int math,int chem,int phy){
//         return (math + chem + phy)/3;
//     }

//     static String schoolname;

//     void setname(String name){
//         this.name = name;
//     }

//     String getname(){
//         return this.name;
//     }
// }

// super keyword

public class OOPsinheritance{
    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

class Animal{
    String color;
    Animal(){
        System.out.println("animal constructor is called");
    }
}

class Horse extends Animal{

    Horse() {
        super.color = "brown";
        System.out.println("horse constructor is called");
    }
    
}