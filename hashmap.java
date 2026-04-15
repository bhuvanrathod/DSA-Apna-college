import java.util.*;
public class hashmap{
    public static void main(String[] args) {

        //HashMap

        // HashMap<String,Integer> hm = new HashMap<>();
        // hm.put("India",150);
        // hm.put("china",120);
        // hm.put("London",30);
        // System.out.println(hm);
        // int pop = hm.get("India");
        // System.out.println(pop);
        // System.out.println(hm.containsKey("china"));
        // System.out.println(hm.remove("London"));

        // LinkedHashMap

        // LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India",150);
        // lhm.put("china",120);
        // lhm.put("London",30);
        // System.out.println(lhm);
        // int pop = lhm.get("India");
        // System.out.println(pop);
        // System.out.println(lhm.containsKey("china"));
        // System.out.println(lhm.remove("London"));

        // TreeMap

        // TreeMap<String,Integer> tm = new TreeMap<>();
        // tm.put("India",150);
        // tm.put("China",120);
        // tm.put("London",30);
        // System.out.println(tm);
         //     int pop = tm.get("India");
        //     System.out.println(pop);
        //     System.out.println(tm.containsKey("china"));
        //     System.out.println(tm.remove("London"));


        // hashset

        // HashSet<Integer> set = new HashSet<>();
        // set.add(1);
        // set.add(2);
        // set.add(3);
        // set.add(1);
        // System.out.println(set);
        // set.remove(2);
        // System.out.println(set.contains(3));

        // // Build in iterator on hashset
        // Iterator it = set.iterator();
        // while(it.hasNext()){
        //     System.err.println(it.next());
        // }

        // // normal for loop
        // for(Integer i : set){
        //     System.out.println(i);
        // }

        // Linked hashset

        LinkedHashSet<String> lgs = new LinkedHashSet<>();
        lgs.add("banglore");
        lgs.add("kerala");
        lgs.add("andra");
        lgs.add("delihi");
        System.out.println(lgs);

        // Tree map

        TreeSet<String> ts = new TreeSet<>();
        ts.add("banglore");
        ts.add("kerala");
        ts.add("andra");
        ts.add("delihi");
        System.out.println(ts);
    }
}