package MyHashMap;

import java.util.*;

class MyHashMap {

    private LinkedList<Map.Entry>[] hashMap;

    public MyHashMap(int size) {
        this.hashMap = new LinkedList[size];
    }

    public void put(String key, int value) {
        int position = Math.abs(key.hashCode() % hashMap.length);
        LinkedList<Map.Entry> bucket = hashMap[position];
        if (bucket == null) {
            bucket = new LinkedList<>();
        }
        Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>(key, value);
        bucket.addLast(entry);
        hashMap[position] = bucket;
    }

    public int get(String key) throws Exception {
        int position = Math.abs(key.hashCode() % hashMap.length);
        LinkedList<Map.Entry> bucket = hashMap[position];
        if (bucket == null) {
            throw new NoSuchElementException(String.format("Key %s not found", key));
        }

        Iterator iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        throw new NoSuchElementException(String.format("Key %s not found", key));
    }

    public void remove(String key) {
        int position = Math.abs(key.hashCode() % hashMap.length);
        LinkedList<Map.Entry> bucket = hashMap[position];
        if (bucket == null) {
            throw new NoSuchElementException(String.format("Key %s not found", key));
        }

        Iterator iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();
                return;
            }
        }
        throw new NoSuchElementException(String.format("Key %s not found", key));
    }

    public List<Integer> getAllValues() {
        List<Integer> values = new ArrayList<>();
        for (LinkedList bucket : hashMap) {
            if (bucket != null) {
                Iterator iterator = bucket.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
                    values.add(entry.getValue());
                }
            }
        }
        return values;
    }

    public List<String> getAllKeys() {
        List<String> keys = new ArrayList<>();
        for (LinkedList bucket : hashMap) {
            if (bucket != null) {
                Iterator iterator = bucket.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
                    keys.add(entry.getKey());
                }
            }
        }
        return keys;
    }
}
