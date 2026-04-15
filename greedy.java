import java.util.*;
public class greedy{
    public int fractionalknapsack(int[] wight,int[] value,int w){

        double[][] ratio = new double[wight.length][2];

        for(int i=0; i<wight.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)wight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int capacity = w;
        int finalvalue = 0;

        for(int i=ratio.length-1; i>=0; i--){
            int idx= (int)ratio[i][0];
            if(capacity >= wight[idx]){
                finalvalue += value[idx];
                capacity -= wight[idx];
            }else{
                finalvalue += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }

        }
        return finalvalue;

    }

    // minimum absolut difference

    public int minabsdiff(int[] A,int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int minabs = 0;
        for(int i=0; i<A.length; i++){
            minabs += Math.abs(A[i] - B[i]);
        }
        return minabs;
    }

    //max length of chain pairs condition b<c for pairs (a,b) and (c,d)

    public int maxlenchain(int[][] pairs){
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

        int chainlen = 1;
        int chainend = pairs[0][1]; // b

        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] > chainend){   // pairs[i][0] is c
                chainlen++;
                chainend = pairs[i][1];
            }
        }
        return chainlen;
    }

    // Indian coin change problem

    public int indiancoins(Integer[] coins,int amount){
        Arrays.sort(coins,Comparator.reverseOrder());

        int countofcoin = 0;
        for(int i=0; i<coins.length; i++){
            if(coins[i] <= amount){
                while(coins[i] <= amount){
                    countofcoin++;
                    amount -= coins[i];
                }
            }
        }
        return countofcoin;

    }

    // chocola problem

    public static int mincost(int n,int m,Integer[] costhor,Integer[] costver){
        Arrays.sort(costhor,Collections.reverseOrder());
        Arrays.sort(costver,Collections.reverseOrder());

        int h = 0,v = 0;
        int hp = 1,vp = 1;
        int cost = 0;

        while(h < costhor.length && v < costver.length){
            if(costver[v] <= costhor[h]){
                cost += (costhor[h] * vp);
                hp++;
                h++;
            }else{
                cost += (costver[v] * hp);
                vp++;
                v++;
            }
        }

        while( h < costhor.length){
            cost += (costhor[h] * vp);
            hp++;
            h++;
        }
        while(v < costver.length){
            cost += (costver[v] * hp);
            vp++;
            v++;
        }
        return cost;
    }
    public static void main(String[] args){

        greedy g = new greedy();

        int n = 4;
        int m = 6;
        Integer[] costver = {2,1,3,1,4};
        Integer[] costhor = {4,1,2};
        System.out.println("total cost to cut chocola is "+ mincost(n,m,costhor,costver));

        // Integer[] coins = {1,2,5,10,20,50,100,200,500,2000};
        // int amount = 7634;
        // System.out.println("minimum coins required: "+g.indiancoins(coins, amount));

        // int[][] pairs = {{5,24},{39,60},{15,28},{27,40},{50,90}};
        // System.out.println("max length of chain pairs is: "+g.maxlenchain(pairs));

        // int[] A = {3,6,4,9,1};
        // int[] B = {8,3,7,2,5};

        // System.out.println("minimun absolute difference is: "+g.minabsdiff(A, B));
        // int[] wight = {20,40,30};
        // int[] value = {50,100,200};
        // int w = 70;
        // System.out.println("profit is "+g.fractionalknapsack(wight, value, w));

        // this for endtime sorting

        // int[] starttime = {1,3,0,5,8,5};
        // int[] endtime = {2,4,6,7,9,9};

        // //first activity
        // int maxact = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // maxact = 1;
        // ans.add(0);
        // int lastend = endtime[0];
        // for(int i=1; i<endtime.length; i++){
        //     if(starttime[i] >= lastend){
        //         maxact++;
        //         ans.add(i);
        //         lastend = endtime[i];
        //     }

        // }
        // System.out.println("max activity: "+ maxact);
        // for(int i=0; i<ans.size(); i++){
        //     System.out.println("A"+ans.get(i)+" ");
        // }

        // if endtime is not sorted

        // int[] starttime = {1,1,0,5,8,5};
        // int[] endtime = {6,2,4,9,9,7};

        // int[][] activities = new int[starttime.length][3];

        // for(int i=0; i<starttime.length; i++){
        //     activities[i][0] = i;
        //     activities[i][1] = starttime[i];
        //     activities[i][2] = endtime[i];
        // }

        // Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));

        // int maxact = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // maxact = 1;
        // ans.add(activities[0][0]);
        // int lastend = activities[0][2];

        // for(int i=1; i<endtime.length; i++){
        //     if(activities[i][1] > lastend){    >= || >
        //         maxact++;
        //         ans.add(activities[i][0]);
        //         lastend = activities[i][2];
        //     }
        // }
        // System.out.println("max activity: "+ maxact);
        // for(int i=0; i<ans.size(); i++){
        //     System.out.println("A"+ans.get(i)+" ");
        // }



    }
}