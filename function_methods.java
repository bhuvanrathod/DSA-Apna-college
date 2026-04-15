import java.util.*;
public class function_methods {

    // public static void printhello(){
    //     System.out.print("hello");
    // }

    // public static int calculator(int num1,int num2){   // formal parameter
    //     return num1 + num2;
    // }

    // public static void  swapnum(int a,int b){
    //     int temp = a;
    //     a = b;
    //     b = temp;

    //     System.out.println(a);
    //     System.out.println(b);
    // }

    // public static int factorial(int n){
        
    //     int fac = 1;

    //     for(int i=1; i<=n; i++){
    //         fac = fac * i;
    //     }

    //     return fac;
    // }

    // public static int bincoff(int n,int r){
    //     int fact_n = factorial(n);
    //     int fact_r = factorial(r);
    //     int fact_nmr = factorial(n-r);

    //     return fact_n/(fact_r*fact_nmr);
    // }

    // public static boolean  isprime(int n){
        
    //     for(int i = 2; i<=n-1; i++){
    //         if(n % i == 0){
    //             return false;
                
    //         }
    //     }
    //     return  true;
    // }

    // public static void primeinrange(int n){
    //     for(int i=2; i<=n; i++){
    //         if(isprime(i)){
    //             System.out.println(i + " ");
    //         }
    //     }
    //     System.out.println("\n");
    // }

    // public static int bintodec(int n){
    //     double pow = 0;
    //     int dec = 0;
    //     while(n!=0){
    //         int ld = n % 10;
    //         dec = dec + (ld * (int)(Math.pow(2, pow)));
    //         n= n/10;
    //         pow++;
    //     }

    //     return dec;
        
    // }

    // public static int dectobin(int n){
    //     int bin = 0;
    //     int pow = 0;
    //     while(n != 0){
    //         int rem = n % 2;
    //         bin = bin + (rem * (int)(Math.pow(10, pow)));
    //         n=n/2;
    //         pow++;
    //     }
    //     return bin;
    // }

    // public static int avgofthree(int a,int b,int c){
    //     return (a + b + c)/3;
    // }

    // public static boolean iseven(int n){
    //     boolean iseven = true;
    //     if (n % 2 != 0){
    //         iseven = false;
    //     }
    //     return iseven;
    // }

    // public static void ispalindrom(int n){
    //     int a = n; 
    //     int rev = 0;
    //     while(n != 0){
    //         int rem = n % 10;
    //         rev = rev*10 + rem;
    //         n = n / 10;
    //     }

    //     if(a == rev){
    //         System.out.println("the num is palindrom");
    //     }else{
    //         System.out.println("the num is not palindrom");
    //     }
    // }

    public static int digisum(int n){
        int sum = 0;
        while(n != 0){
            int rem = n % 10;
            sum = sum + rem;
            n = n/10;
        }

        return sum;
    }
    public static void main(String[] args){
        // printhello();
        
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.println("Sum of two number is " + calculator(a,b));   //  actual parameter
        // swapnum(a,b);
        // System.out.print("bin coff is " + bincoff(n, 2));
        // primeinrange(n);
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt(); 
        System.out.println(digisum(n));
        
        
       
    }
}