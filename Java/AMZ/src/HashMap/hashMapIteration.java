package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hashMapIteration {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("LY2048303", "John Wells");
        map.put("AB0649858", "Lori Wells");
        map.put("AB4453455", "David Windston");
        map.put("CS9857859", "John Smith");
        map.put("LY9475958", "Alen Cornworth");
        System.out.println();

        Set<String> keys = map.keySet();
        System.out.println("keys: " + keys);
        System.out.println("values: " + map.values());
        System.out.println();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println("ID: " + key + " Value: " + value);
        }
        System.out.println();

        Set entries = map.entrySet();
        System.out.println("entries: " + entries);
        System.out.println();

        for (Object key : entries) {
            Map.Entry entry = (Map.Entry) key;
            Object value = entry.getValue();
            Object keyValue = entry.getKey();
            System.out.println("ID: " + keyValue + " Value: " + value);
            System.out.println("key: " + keyValue + " Value: " + value.getClass());
        }

    }
}
