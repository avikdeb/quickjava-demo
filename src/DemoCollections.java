import java.util.*;

public class DemoCollections {

    // Example of List
    public static void demoList() {
        List<String> myList = new ArrayList<String>();
        // adding elements to the list
        myList.add("Pen");
        myList.add("Pencil");
        myList.add("Notebook");
        myList.add("Orange");
        myList.add("Banana");

        System.out.println("My List is : "+myList);
        System.out.println("Size of My List is : "+myList.size());

        //Sorting the list
        Collections.sort(myList);
        System.out.println("My sorted list (alphabetically): ");
        for (String str : myList) {
            System.out.println(str);
        }
    }

    // Example of Set : No duplicates
    public static void demoSet() {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(10); //autoboxing
        integerList.add(20);
        integerList.add(20);
        integerList.add(30);
        integerList.add(40);
        integerList.add(40);

        System.out.println("List with duplicates (20. 40) : "+integerList);

        Set<Integer> integerSet = new HashSet<Integer>();
        integerSet.add(10);
        integerSet.add(20);
        integerSet.add(20);
        integerSet.add(30);
        integerSet.add(40);
        integerSet.add(40);

        System.out.println("Set without duplicates (20, 40) : "+integerSet);
    }

    // Example of Map
    public static void demoMap() {
        //Map is a <key> <value> paired data structure
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(new Integer(100), "apple");
        map.put(new Integer(200), "banana");
        map.put(new Integer(300), "orange");

        System.out.println("Map created : " + map);
        System.out.println("Total entries = " + map.size());

        for (Integer key : map.keySet()) {
            System.out.println("Retrieving entries from Map :");
            System.out.println(key + " >> " + map.get(key));
        }
    }

    // Driver code to run examples
    public static void main(String[] args) {
        demoList();
        demoSet();
        demoMap();
    }
}
