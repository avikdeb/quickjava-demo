import java.util.HashMap;
import java.util.Map;

public class DemoCollections {

    public static void main(String[] args) {

        //Map is a <key> <value> paired data structure
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(new Integer(100), "apple");
        map.put(new Integer(200), "banana");
        map.put(new Integer(300), "orange");

        System.out.println("Map created : "+map);
        System.out.println("Total entries = "+map.size());

        for (Integer key : map.keySet()){
            System.out.println("Retrieving entries from Map :");
            System.out.println(key+" >> "+map.get(key));
        }

    }
}
