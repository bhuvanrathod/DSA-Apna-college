import java.util.*;
public class HMproblem{
    public static int countuniq(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        return set.size();
    }
    public static boolean validanagram(String s,String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }

    //union and intersection
    public static void unionintersec(int[] arr1,int[] arr2){
        //Union
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        set.clear();

        //Intersection
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                
                System.out.println(set.remove(arr2[i]));
            }
        }
    }

    public static String getstart(HashMap<String,String> tickets){
        HashMap<String,String> revmap = new HashMap<>();
        for(String key : tickets.keySet()){
            revmap.put(tickets.get(key),key);
        }
        for(String key : tickets.keySet()){
            if(!revmap.containsKey(key)){
                return key;
            }
        }
        return null;
    }

    // largest subarray with sum

    public static int maxsum(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                len = Math.max(len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return len;
    }

    // largest subarray sum with k

    public static int maxsubarr(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    public static void main(String[] args){
        HashMap<Integer,Integer> map = new HashMap<>();
        // String s = "race";
        // String t = "care";
        // System.out.println(validanagram(s, t));

        int[] arr = {10,2,-2,-20,10};
        int k = -10;
        System.out.println(maxsubarr(arr,k));
        // Majority element in an array

        // int[] arr = {1,3,2,5,1,3,1,5,1};
        // int n = arr.length;

        // for(int i=0; i<arr.length; i++){
        //     if(map.containsKey(arr[i])){
        //         map.put(arr[i],map.get(arr[i])+1);
        //     }else{
        //         map.put(arr[i],1);
        //     }

        //     // map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        // }
        // Set<Integer> keyset = map.keySet();
        // for(Integer key : keyset){              // direct map.keySet(); 
        //     if(map.get(key) > arr.length/3){
        //         System.out.println(key);
        //     }
        // }
    }
}