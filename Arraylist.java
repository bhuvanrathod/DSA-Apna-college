import java.util.ArrayList;

// import java.util.*;

public class Arraylist{

    public static void swap(ArrayList<Integer>list,int idx1,int idx2){
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    // brute force approch
    public static void mostwater(ArrayList<Integer> list){
        int height,width;
        int maxwater = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                height = Math.min(list.get(i),list.get(j));
                width = j - i;
                int water = height * width;
                maxwater = Math.max(maxwater,water);
            }
        }
        System.out.println(maxwater);
    }

    // two pointer 

    public static int mostwatertwop(ArrayList<Integer> list){
        int left = 0,right = list.size() - 1;
        int height,width;
        int maxwater = 0;
        while(left < right){
            width = right - left;
            height = Math.min(list.get(left),list.get(right));
            int water = height * width;
            maxwater = Math.max(maxwater,water);

            if(list.get(left) < list.get(right)){
                left++;
            }else{
                right--;
            }
        }
        return maxwater;
    }

    // pair sum brute force

    public static boolean pairsumb(ArrayList<Integer>list,int target){
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    //  two pointer app
    public static boolean pairsumtwop(ArrayList<Integer>list,int target){
        int left = 0,right = list.size()-1;
        while(left < right){
            int sum = list.get(left) + list.get(right);
            if(sum == target){
                return true;
            }
            if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    //pair sum of rotated sorted arraylist

    public static boolean pairsumsr(ArrayList<Integer>list,int target){
        int bp = -1;
        int n = list.size();
        for(int i=0; i<n; i++){
            if(list.get(i) > list.get(i+1)){
                bp = i;
                break;
            }
        }

        int lp = bp + 1;
        int rp = bp;

        while(lp != rp){
            int sum = list.get(lp) + list.get(rp);

            if(sum == target){
                return true;
            }

            if(sum < target){
                lp = (lp + 1)%n;
            }else{
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }

    public static boolean monotic(ArrayList<Integer>list){
        int n = list.size();
        for(int i=0; i<n-2; i++){
            if(list.get(i) < list.get(i+1) && list.get(i+1) > list.get(i+2)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // ArrayList<Integer> list1 = new ArrayList<>();
        // for(int i=1; i<=10; i++){
        //     list1.add(i);               // push element to list
        // }
        // System.out.println(list1);
        // swap(list1, 2, 5);
        // System.out.println(list1);

        // list.add(2,30);      add element 30 at index 2

        // System.out.println(list1.get(3));  // get element from the list

        // delete element
        // list1.remove(5);
        // System.out.println(list1);

        // list1.set(3,100);
        // System.out.println(list1);

        // list1.add(9);
        // list1.add(3);
        // list1.add(5);
        // list1.add(2);
        // list1.add(7);

        // System.out.println(list1);
        // Collections.sort(list1);
        // Collections.sort(list1,Collections.reverseOrder());
        // System.out.println(list1);

        // multi dimension array list

        // ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();

        // ArrayList<Integer>list1 = new ArrayList<>();
        // ArrayList<Integer>list2 = new ArrayList<>();
        // ArrayList<Integer>list3 = new ArrayList<>();
        
        // for(int i=1; i<=5; i++){
        //     list1.add(i*1);
        //     list2.add(2*i);
        //     list3.add(3*i);
        // }
        // mainlist.add(list1);
        // mainlist.add(list2);
        // mainlist.add(list3);

        // System.out.println(mainlist);

        // for(int i=0; i<mainlist.size();  i++){
        //     ArrayList<Integer> currlist = mainlist.get(i);
        //     for(int j=0; j<currlist.size(); j++){
        //         System.out.print(currlist.get(j)+" ");
        //     }
        //     System.out.println();
        // }

        ArrayList<Integer>height = new ArrayList<>();
        height.add(1);
        height.add(1);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        // height.add(7);
        // height.add(8);
        // height.add(9);

        // System.out.println(mostwatertwop(height));

        // System.out.println(pairsumtwop(height,20));

        // System.out.println(pairsumsr(height, 14));
        System.out.println(monotic(height));
    }
}