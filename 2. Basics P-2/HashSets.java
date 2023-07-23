import java.util.HashSet;
import java.util.Iterator;

public class HashSets {
    public static void main(String[] args) {
        // HashSet => Contains only unique values.
        HashSet<Integer> set = new HashSet<>();

        //Insert   => O(1)
        set.add(45);
        set.add(44);
        set.add(12);
        set.add(68);
        set.add(98);
        set.add(69);
        set.add(65);
        set.add(45); // Duplicate element
        System.out.println(set);

        //Search  => O(1)
        System.out.println(set.contains(45)); //returns true

        //Delete
        System.out.println(set.remove(45));
        System.out.println(set);

        //size
        System.out.println(set.size());

        //Iterator
        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

    }
}
