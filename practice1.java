
import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        // int a = 10;
        // a++;
        // System.out.println(a);
        // System.out.print("Hello, World!\n");
        // System.out.print("Bhuvan Rathod");
        // Scanner sc = new Scanner(System.in);
        // String input = sc.next();
        // System.out.println(input);
        // String name = sc.nextLine();
        // System.out.println(name);

        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int pro = a * b;
        // System.out.println(pro);
 
        // Scanner sc = new Scanner(System.in);
        // float radius = sc.nextFloat();
        // float area = 3.14f*radius*radius;
        // System.out.println(area);

        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();
        // long avg = (a+b+c)/3;
        // System.out.println(avg);

        // int $=13;
        // System.out.println($);

        // byte b = 4;
        // char c = 'a';
        // short s = 512;
        // int i = 1000;
        // float  f = 3.14f;
        // double d = 99.9954;

        // double result = (int)((f * b) + (i % c) - (d * s));
        // System.out.println(result);

        // int x=2, y=5;

        // int exp1 = (x * y / x);
        // int exp2 = (x * (y / x));

        // System.out.print(exp1 + ",");
        // System.out.print(exp2);

        // int x = 200, y = 50, z = 100;if(x > y && y > z){System.out.println("Hello");}if(z > y && z < x){System.out.println("Java");}if((y+200) < x && (y+150) < z){System.out.println("Hello Java");}

        // int x, y, z;x = y = z = 2;x += y;y -= z;z /= (x + y);System.out.println(x + " " + y + " " + z);  

        // int x = 9, y = 12;
        // int a = 2, b = 4, c = 6;
        // int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
        // System.out.println(exp);    

        // int x = 10, y = 5;int exp1 = (y * (x / y + x / y));int exp2 = (y * x / y + y * x / y);System.out.println(exp1);System.out.println(exp2);

        // Scanner sc = new Scanner(System.in);
        // int income = sc.nextInt();

        // if(income <= 500000){
        //     int tax = 0;
        //     System.out.print("tax for less than 5lpa is" + tax);
        // }
        // else if (income > 500000 && income < 1000000) {
        //     double tax = income*0.2;
        //     System.out.print("tax between  5lpa and 10lpa is" + tax);
        // }
        // else{
        //     double tax = income*0.3;
        //     System.out.print("the tax for above 10lpa is" + tax);
        // }

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter thevalue of num");
        // int num = sc.nextInt();

        // if(num > 0){
        //     System.out.println(num + " is positive");
        // }else{
        //     System.out.println(num + " is negative");
        // }   

        // Scanner sc = new Scanner(System.in);
        // int week = sc.nextInt();

        // switch (week) {
        //     case 1 -> System.out.println("Monday");
        //     case 2 -> System.out.println("tuesday");
        //     case 3 -> System.out.println("wednesday");
        //     case 4 -> System.out.println("Thesday");
        //     case 5 -> System.out.println("Friday");
        //     case 6 -> System.out.println("staurday");
        //     case 7 -> System.out.println("Sunday");
        //     default -> System.out.println("Only 7 day are in week please enter day between 1-7");
        // }

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the year: ");
        // int year = sc.nextInt();

        // if(year % 4 == 0 && year % 100 ==0 && year % 400 == 0 ){
        //     System.out.println(year +" is leap year");
        // }else{
        //     System.out.println(year +" is not leap year");
        // }

                // int rev = 0;
        
        // while (n != 0) {
        //     int r = n%10;
        //     rev = rev*10+r;
        //     System.out.print(r);
        //     n = n/10;
        // }
        
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isprime = true;

        if(n == 2){
            System.out.print("2 is prime num");
        }else{
            for(int i=2; i < n-1; i++){
                if(n % i == 0){
                    isprime = false;
                }
            }
        }

        if(isprime == true){
            System.out.print("n is the prime num");
        }else{
            System.out.print(" is not prime");
        }
        
        

    }
}
