package MyHashMap;

import java.util.List;

public class MyAwesomeHashMap {

    public static void main(String args[] ) throws Exception {

        // Test data
        MyHashMap hashMap = new MyHashMap(50);
        hashMap.put("test_with_1", 1);
        hashMap.put("test_with_2", 2);
        hashMap.put("test_with_3", 3);
        hashMap.put("test_with_4", 4);
        hashMap.put("test_with_5", 5);
        hashMap.put("test_with_10", 10);

        System.out.println(hashMap.get("test_with_10"));

        hashMap.remove("test_with_5");
        hashMap.remove("test_with_1");

        List<Integer> values = hashMap.getAllValues();
        List<String> keys = hashMap.getAllKeys();

        System.out.print("Keys: ");
        for (String key : keys) {
            System.out.print(key + " ");
        }

        System.out.print("Values: ");
        for (Integer value : values) {
            System.out.print(value + " ");
        }
    }
}
