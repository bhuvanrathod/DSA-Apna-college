import java.util.*;
public class dynamic_program{
    // using recursion
    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    //using memorization
    public static int fib(int n,int[] f){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n] = fib(n-1,f) + fib(n-2,f);
        return f[n];
    }

    //using tabulation
    public static int fibtabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // using recursion
    public static int climbstairway(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return climbstairway(n-1) + climbstairway(n-2);
    }

    // climbing stair using recursion and memorization
    public static int climbstairrec(int n,int[] way){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        
        if(way[n] != -1){
            return way[n];
        }

        way[n] = climbstairrec(n-1,way) + climbstairrec(n-2,way);  //jump for 3 step is add  + climbstairrec(n-3, way
        return way[n];
    }

    public static int climbstairtab(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    
    // o-1 knapsack problem -> using recursion  --> O(2pow(n))
    public static int knapsack(int[] val,int[] wt,int W,int n){
        if(n == 0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            //include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, W, n-1);
            return Math.max(ans1,ans2);
        }else{
            return knapsack(val, wt, W, n-1);
        }
    }

    // o-1 knapsack problem -> using recursion + memorization ->expo to O(n*W)
    public static int knapsackmem(int[] val,int[] wt,int W,int n,int[][] dp){
        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] <= W){
            //include
            int ans1 = val[n-1] + knapsackmem(val, wt, W - wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsackmem(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        }else{
            dp[n][W] = knapsackmem(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    //0-1 knapsack using tabulation method -> O(n*W)   -> item repetation not allowed
    public static int knapsacktab(int[] val,int[] wt,int W){
        int[][] dp = new int[val.length+1][W+1];
        int n = val.length;
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    int inprofit = v + dp[i-1][j-w];
                    int exprofit = dp[i-1][j];
                    dp[i][j] = Math.max(inprofit,exprofit);
                }else{
                    int exprofit = dp[i-1][j];
                    dp[i][j] = exprofit;
                }
            }
        }
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }

    //target sum subset O(n*sum) using tabulation
    public static boolean targetsumsubset(int[] arr,int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                int v = arr[i-1];
                //include
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }// exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][sum];
    }

    // unbounded knapsack O(n*W) -> here item repetation is allowed
    public static int knapsacktabunbound(int[] val,int[] wt,int W){
        int[][] dp = new int[val.length+1][W+1];
        int n = val.length;
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    int inprofit = v + dp[i][j-w];
                    int exprofit = dp[i-1][j];
                    dp[i][j] = Math.max(inprofit,exprofit);
                }else{
                    int exprofit = dp[i-1][j];
                    dp[i][j] = exprofit;
                }
            }
        }
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }

    //coin change problem O(n*sum)
    public static int coinchange(int[] coin,int sum){
        int n = coin.length;
        int[][] dp = new int[n+1][sum+1];
        
        // inisilaize 0
        //  i->coins: j->sum/change
        for(int i=0; i<n+1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(coin[i-1] <= j){
                    dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][sum];
    }

    //rodcutting O(n*totrod)
    public static int rodcutting(int length[],int price[],int totrod){
        int n = price.length;
        int[][] dp = new int[n+1][totrod+1];

        //initize it will be optional because java initize with zero
        for(int i=0; i<n+1; i++){
            for(int j=0; j<totrod+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        //wt => length val=>price w=totrod 

        for(int i=1; i<n+1; i++){
            for(int j=1; j<totrod+1; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i-1][j-length[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0; i<n+1; i++){
            for(int j=0; j<totrod+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][totrod];
    }
    public static void main(String[] args) {
        int n = 5;
        int[] f = new int[n+1];
        Arrays.fill(f,-1);
        // System.out.println(fibtabulation(n));
        // System.out.println(climbstairtab(n));
        int val[] = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsackmem(val, wt, W, val.length,dp));
        // System.out.println(knapsacktabunbound(val, wt, W));
    //     int arr[] = {4,2,7,1,3};
    //     int sum = 10;
    //     System.out.println(targetsumsubset(arr, sum));
        // int[] coin = {2,5,3,6};
        // int sum = 10;
        // System.out.println(coinchange(coin, sum));
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int totrod = 8;
        System.out.println(rodcutting(length, price, totrod));
    }
}