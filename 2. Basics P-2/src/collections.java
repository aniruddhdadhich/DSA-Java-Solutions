import java.util.ArrayList;

public class collections {
    public static void main(String[] args) {
        // The concept of ArrayList
        ArrayList<Integer> list= new ArrayList<>();

        // add elements // kinda like push, adds the element at the end
        list.add(0);
        list.add(2);
        list.add(45);

        // get elements => fetching
        int element = list.get(2);
        System.out.println(element);

        // Add element in between
        list.add(3,12);
        System.out.println(list);

        // set element => change the existing element
        list.set(1,10);
        System.out.println(list);

        // delete element
        list.remove(0);
        System.out.println(list);

        // size
        System.out.println(list.size());

    }
}

