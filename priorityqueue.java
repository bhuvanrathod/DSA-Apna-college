// import java.util.*;
// public class priorityqueue{
//     static class student implements Comparator<student>{
//         String name;
//         int rank;

//         public student(String name,int rank){
//             this.name = name;
//             this.rank = rank;
//         }

//         // @Override
//         public int CompareTo(student s2){
//             return this.rank - s2.rank;
//         }

        
//         // public int compare(student o1, student o2) {
//         //     throw new UnsupportedOperationException("Not supported yet.");
//         // }
//     }
//     public static void main(String[] args){
//         priorityqueue<student> pq = new priorityqueue<>();

//         pq.add(new student("A",3));
//         pq.add(new student("w",5));
//         pq.add(new student("e",1));
//         pq.add(new student("r",8));
//         pq.add(new student("t",4));

//         while(!pq.isEmpty()){
//             System.out.println(pq.peek().name +"->"+pq.peek().rank);
//             pq.remove();
//         }
//     }
// }

import java.util.*;

public class priorityqueue {

    // static class student implements Comparable<student> {

    //     String name;
    //     int rank;

    //     public student(String name, int rank) {
    //         this.name = name;
    //         this.rank = rank;
    //     }

    //     @Override
    //     public int compareTo(student s2) {  
    //         return this.rank - s2.rank;
    //     }
    // }

    static class point implements Comparable<point>{
        int x;
        int y;
        int maxsqr;
        int idx;

        point(int x,int y,int maxsqr,int idx){
            this.x = x;
            this.y = y;
            this.maxsqr = maxsqr;
            this.idx = idx;
        }

        @Override
        public int compareTo(point p2){
            return this.maxsqr - p2.maxsqr;  // for acending order
        }
    }

    static class pair implements Comparable<pair>{
        int val;
        int idx;
        public pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair p2){
            return p2.val - this.val;  // for decending order
        }
    }

    public static void main(String[] args) {

        PriorityQueue<pair> pq = new PriorityQueue< >();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new int[arr.length-k+1];

    //1st windoe
        for(int i=0; i<k; i++){
            pq.add(new pair(arr[i],i));
        }
        res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new pair(arr[i],i));
            res[i-k+1] = pq.peek().val;
        }

        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }

        // pq.add(new student("A", 3));
        // pq.add(new student("W", 5));
        // pq.add(new student("E", 1));
        // pq.add(new student("R", 8));
        // pq.add(new student("T", 4));

        // while (!pq.isEmpty()) {

        //     System.out.println(pq.peek().name + " -> " + pq.peek().rank);

        //     pq.remove();
        // }

        // int[][] pts = {{3,3},{5,-1},{-2,4}};
        // int k = 2;
        // for(int i=0; i<pts.length; i++){
        //     int maxsqr = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
        //     pq.add(new point(pts[i][0],pts[i][1],maxsqr,i));
        // }

        // for(int i=0; i<k; i++){
        //     System.out.print(" "+pq.remove().idx);
        // }
    }
}