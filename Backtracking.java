public class Backtracking{

    public static void changeArr(int arr[],int i,int value){
        //base case
        if(i == arr.length){
            printArr(arr);
            return;
        }
        // recursion
        arr[i] = value;
        changeArr(arr,i+1,value+1);
        arr[i] = arr[i] - 2;  // backtracking
    }

    public static void printArr(int arr[]){
        for(int i=0; i<5; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //findsubset in string
    public static void findSubset(String str,String ans,int i){
        //base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("NULL");
            }else{
                System.out.println(ans);
            }
            return;
        }
        //recursion backtracking part
        //yes part
        findSubset(str,ans+str.charAt(i),i+1);
        //no part
        findSubset(str,ans,i+1);
    }

    // find permutation
    public static void findPermutation(String str,String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            //"abcd"-> "ab" + "cd" = abcd
            String newStr = str.substring(0,i)+str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }
    }

    //N Queens
    //queen
    // public static boolean  isSafe(char board[][],int row, int col){
    //     // vertical up
    //     for(int i=row-1; i>=0; i--){
    //         if(board[i][col] == 'Q'){
    //             return false;
    //         }
    //     }

    //     //leftdiagonal
    //     for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
    //         if(board[i][j] == 'Q'){
    //             return false;
    //         }
    //     }

    //     //right diagonal
    //     for(int i=row-1,j=col+1;i>=0 && j<board.length; i--,j++){
    //         if(board[i][j] == 'Q'){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // camel

    public static boolean isSafe(char board[][],int row,int col){

        //left up diagonal
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //right up diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // for(int i=row+1,j=col-1; i<board.length && j>=0; i++,j--){
        //     if(board[i][j] == 'Q'){
        //         return false;
        //     }
        // }

        // for(int i=row+1,j=col+1;i<board.length && j<board.length;i++,j++){
        //     if(board[i][j] == 'Q'){
        //         return false;
        //     }
        // }

        return true;
    }

    public static void nQueen(char board[][],int row){
        //base case
        if(row == board.length){
            printboard(board);
            // count++;
            
            return;
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueen(board, row+1);
                board[row][j] = 'X';
            }
        }
    }

    // to print only one solution

    // public static boolean nQueen(char board[][],int row){
    //     //base case
    //     if(row == board.length){
    //         printboard(board);
    //         // count++;
            
    //         return true;
    //     }

    //     for(int j=0; j<board.length; j++){
    //         if(isSafe(board,row,j)){
    //             board[row][j] = 'Q';
    //             if( nQueen(board, row+1)){
    //                  return true
    //            }
    //             board[row][j] = 'X';
    //         }
    //     }
    //      return false;
    // }

    public static void printboard(char board[][]){
        System.out.println("--------chess board-------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    // static int count = 0;  print number of ways

    //ggrid ways
    public static int gridway(int i,int j,int n,int m){
        //base case
        if(i == n-1 && j == m-1){
            return 1;
        }else if(i == n || j == m){
            return 0;
        }

        int w1 = gridway(i+1, j, n, m);
        int w2 = gridway(i, j+1, n, m);

        return w1 + w2;
    }

    public static void main(String[] args){
        // int arr[] = new int[5];
        // changeArr(arr,0,1);
        // printArr(arr);
        // String str = "abc";
        // findSubset(str,"",0);
        // findPermutation(str, "");

        // int n = 5;
        // char board[][] = new char[n][n];

        // //initilization
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         board[i][j] = 'X';
        //     }
        // }

        // nQueen(board,0);
        // if(nQueen(board,0)){
        //     System.out.println("solution is exist");
        // }else{
        //     System.out.println("solution does not exist");
        // }

        //count
        // System.out.println(count);

        int n = 3;
        int m =3;
        System.out.println(gridway(0, 0, n, m));
    }
}