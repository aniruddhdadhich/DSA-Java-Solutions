import java.util.HashMap;
import java.util.*;

public class HashMaps {

    public static void main(String[] args) {
        //Key Value Pairs
        HashMap<String,Integer> map = new HashMap<>();

        //Adding pairs
        map.put("India",120);
        map.put("China",150);
        map.put("Russia", 50);
        map.put("US", 45);
        System.out.println(map);

        // Searching for keys and values
        boolean russia = map.containsKey("Russia");
        boolean france = map.containsKey("France");
        System.out.println(russia);
        System.out.println(france);

        System.out.println(map.get("China")); // returns the value of the provided key

        // Iteration using enhanced for loop
        for(Map.Entry<String,Integer> pair: map.entrySet()){
            System.out.print(pair.getKey());
            System.out.println(" "+ pair.getValue());
        }

        // Iteration using key Set
        Set<String> keys = map.keySet();
        for(String key: keys){
            System.out.println(key+" "+map.get(key));
        }


        // Removing values from map
        map.remove("China");
        System.out.println(map);
    }
}
