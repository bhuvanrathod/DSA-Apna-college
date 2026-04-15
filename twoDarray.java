// import java.util.*;

public class twoDarray {

    // key found in 2d array

    // public static boolean search(int arr[][], int key){
    //     for(int i=0; i<3; i++){
    //         for(int j=0 ;j<arr[0].length; j++){
    //             if(arr[i][j] == key){
    //                 System.out.println("the key is found at ("+ i +"," +j +")");
    //                 return true;
    //             }
    //         }
            
    //     }
    //     return false;
    // }

    // largest num in array

    // public static int large(int arr[][]){
    //     int large = Integer.MIN_VALUE;
    //     for(int i=0; i<3; i++){
    //         for(int j=0; j<3; j++){
    //             large = Math.max(large,arr[i][j]);
    //         }
    //     }
    //     return large;
    // }

    // small

    // public static int smal(int arr[][]){
    //     int small = Integer.MAX_VALUE;
    //     for(int i=0; i<3; i++){
    //         for(int j=0; j<3; j++){
    //             small = Math.min(small,arr[i][j]);
    //         }
    //     }
    //     return small;
    // }

    // spiral matrix

    //  public static void printspiral(int matrix[][]){
    //     int startrow = 0;
    //     int startcol = 0;
    //     int endrow = matrix.length-1;
    //     int endcol = matrix[0].length-1;

    //     while(startrow <= endrow && startcol <= endcol){
    //         //top
    //         for(int j=startcol; j<=endcol; j++){
    //             System.out.print(matrix[startrow][j]+" ");
    //         }

    //         // right
    //         for(int i=startrow+1; i<=endrow; i++){
    //             System.out.print(matrix[i][endcol] + " ");
    //         }

    //         //bottom
    //         for(int j=endcol-1; j>=startcol; j--){
    //             if(startrow == endrow){
    //                 break;
    //             }
    //             System.out.print(matrix[endrow][j] + " ");
    //         }

    //         //right
    //         for(int i=endrow-1; i>=startrow+1; i--){
    //             if(startcol == endcol){
    //                 break;
    //             }
    //             System.out.print(matrix[i][startcol] + " ");
    //         }
    //         startcol++;
    //         startrow++;
    //         endcol--;
    //         endrow--;
    //     }
    //     System.out.println();
    // }

    // diagonal sum brute force

    // public static int diagonalsum(int arr[][]){
    //     int sum = 0;
    //     for(int i=0; i<arr.length; i++){
    //         for(int j=0; j<arr[0].length; j++){
    //             if(i == j){
    //                 sum += arr[i][j];
    //             }else if(i + j == arr.length-1){
    //                 sum += arr[i][j];
    //             }
    //         }
    //     }
    //     return sum;
    // }

    //diagonalsum optimal

    // public static int diasum(int arr[][]){
    //     int sum = 0;
    //     for(int i=0; i<arr.length; i++){
    //         sum += arr[i][i];

    //         if(i != arr.length-1-i){   // mean i == j do not add
    //             sum += arr[i][arr.length-1-i];
    //         }
    //     }
    //     return  sum;
    // }

    // stairchasesearch

    // top right

    // public static boolean stairsearch(int arr[][], int key){
    //     int row = 0, col = arr[0].length-1;

    //     while(row < arr.length && col >=0){
    //         if(arr[row][col] == key){
    //             System.out.println("found key at (" + row + "," + col + ")");
    //             return true;
    //         }else if(key < arr[row][col]){
    //             col--;
    //         }else{
    //             row++;
    //         }
    //     }
    //     System.out.println("key is not found");
    //     return false;
    // }

    // bottom left

    // public static boolean stairsearch(int arr[][], int key){
    //     int row = arr.length-1, col = 0;

    //     while(col < arr.length && row >=0){
    //         if(arr[row][col] == key){
    //             System.out.println("found key at (" + row + "," + col + ")");
    //             return true;
    //         }else if(key < arr[row][col]){
    //             row--;
    //         }else{
    //             col++;
    //         }
    //     }
    //     System.out.println("key is not found");
    //     return false;
    // }


    public static void main(String[] args) {
        // int matrix[][] = new int[4][4];
        // Scanner sc = new Scanner(System.in);
        
        //input 
        // for(int i=0; i<4; i++){
        //     for(int j=0 ;j<matrix[0].length; j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        //output
        // for(int i=0; i<4; i++){
        //     for(int j=0 ;j<matrix[0].length; j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // int matrix[][] = {
        //     {10,20,30,40},
        //     {15,25,35,45},
        //     {27,29,37,47},
        //     {32,33,39,49}
        // };
        // int key = 33;
        // System.out.println(stairsearch(matrix, key));

        // printspiral(matrix);
        // System.out.println(search(matrix, 3));

        // System.out.println(large(matrix));

        // System.out.println(smal(matrix));


    }
}