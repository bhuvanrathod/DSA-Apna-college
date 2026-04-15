
import java.util.Scanner;

public class pattern1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // triangle patter
        // for(int i=1; i<=n; i++){
        //     for(int j=1;j<=i; j++){
        //         System.out.print(" * ");
        //     }
        //     System.out.print("\n");
        // }

        // invert triangle 
         
        // for(int i=n; i>=1; i--){               or             for(int i=1; i<=n; i++){
        //     for(int j=i; j>=1; j--){                             for(int j=1; j<=n-i+1; j++)
        //         System.out.print(" * ");                             sop("*")
        //     }
        //     System.out.print("\n");
        // }
        // char ch = 'A';
        // for(int i=1; i<=n; i++){
            
        //     for(int j=1; j<=i; j++){
        //         System.out.print(ch);
        //         ch++;
        //     }
        //     System.out.print("\n");
        // }4

        // for(int i=1; i<=n; i++){
        //     for(int j=i; j>=1; j--){
        //         System.out.print(j);
        //     }
        //     System.out.print("\n");
        // }

        //  for(int i=1; i<=n; i++){
        //     char ch = 'A';
        //     for(int j=i; j>=1; j--){
        //         System.out.print(ch);
        //         ch++;

        //     }
        //     System.out.print("\n");
        // }

        //pyramid
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n-i-1; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=0; j<2*i+1; j++){
        //         System.out.print("*");
        //     }
        //     for(int j=0; j<n-i-1; j++){
        //         System.out.print(" ");
        //     }
        //     System.out.println("\n");
        // }
        // for(int i=n; i>0; i--){
        //     for(int j=n-i-1; j>0; j--){
        //         System.out.print(" ");
        //     }
        //     for(int j=2*i+1; j>0; j--){
        //         System.out.print("*");
        //     }
        //     for(int j=n-i-1; j>0; j--){
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        // }

        //         for(int i=0; i<n; i++){
        //     for(int j=0; j<n-i-1; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=0; j<2*i+1; j++){
        //         System.out.print("*");
        //     }
        //     for(int j=0; j<n-i-1; j++){
        //         System.out.print(" ");
        //     }
        //     System.out.println("\n");
        // }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<i; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=0; j<2*n-(2*i+1); j++){
        //         System.out.print("*");
        //     }
        //     for(int j=0; j<i; j++){
        //         System.out.print(" ");
        //     }
        //     System.out.println("\n");
        // }

        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print("*");
        //     }
           
        //     System.out.print("\n");
        // }


        // hollow block

        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n; j++){
        //         if(i == 1 || i == n || j == 1 || j == n){
        //             System.out.print("*");
        //         }
        //         else{
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.print("\n");
        // }
        
        // inverted half pyramid
        // for (int i = 1; i <= n; i++) {
        //     for( int j = 1; j<=n-i; j++){
        //         System.err.print(" ");
        //     }
        //     for( int j = 1; j<=i; j++){
        //         System.err.print("*");
        //     }
        //     System.out.print("\n");
        // }

        // inverted half pyramid with number
        // for (int i = 1; i <= n; i++) {
        //     for( int j = 1; j<=n-i+1; j++){
        //         System.out.print(j);
        //     }
           
        //     System.out.print("\n");
        // }
        // int num =1;
        // for (int i = 1; i <= n; i++) {
        //     for( int j = 1; j<=i; j++){
        //         System.out.print(num + " ");
        //         num++;
        //     }
           
        //     System.out.print("\n");
        // }

        // o's and 1's
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++){
        //         if((i+j) % 2 ==0 ){
        //             System.out.print("1");
        //         }else{
        //             System.out.print("0");
        //         }
        //     }
        //     System.out.println();
        // }


        // butter fly pattern
        // for (int i = 1; i <= n; i++) {
        //     for( int j = 1; j<=i; j++){
        //         System.out.print("*");
        //     }
        //     for( int j = 1; j<=(2*n)-(2*i); j++){
        //         System.out.print(" ");
        //     }
        //     for( int j = 1; j<=i; j++){
        //         System.out.print("*");
        //     }
            

           
        //     System.out.print("\n");
        // }
        // for(int i=1; i<=n; i++){
        //     for( int j = 1; j<=n-i+1; j++){
        //         System.out.print("*");
        //     }
        //     for( int j = 1; j<=2*i-2; j++){
        //         System.out.print(" ");
        //     }
        //     for( int j = 1; j<=n-i+1; j++){
        //         System.out.print("*");
        //     }
        //     System.out.print("\n");
        // }

        // solid rhombus
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n-i; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1; j<=n; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // number pyramid

        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n-i; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1; j<=i; j++){
        //         System.out.print(i+ " ");
        //     }
        //     System.out.print("\n");
        // }


        // palindron number
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n-i; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=i; j>=1; j--){
        //         System.out.print(j);
        //     }
        //     for(int j=2;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.print("\n");
        // }

        // diamond

        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n-i; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1; j<=2*i-1; j++){
        //         System.out.print("*");
        //     }
            
        //     System.out.print("\n");
        // }
        // for(int i=n; i>=1; i--){

        //     for(int j=1; j<=n-i; j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1; j<=2*i-1; j++){
        //         System.out.print("*");
        //     }
        //     System.out.print("\n");
        // }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=n; j++){
                if(i == 1 || i == n || j == 1 || j == n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            
            
            System.out.print("\n");
        }

    }
}