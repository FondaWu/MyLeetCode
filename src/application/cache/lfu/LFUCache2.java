package application.cache.lfu;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache2 {

    class CacheEntry {
        private int key;
        private int data;
        private int frequency;

        private long time;

        // default constructor
        public CacheEntry(int key, int data) {
            this.key = key;
            this.data = data;
            this.frequency = 0;
            this.time = System.nanoTime();
        }

        public void update(int data) {
            this.data = data;
            this.frequency++;
            this.time = System.nanoTime();
        }

    }

    private int capacity;

    private Map<Integer, CacheEntry> cacheMap = new HashMap<>();
    private TreeMap<Integer, Integer> timeMap = new TreeMap<>();

    public LFUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            // cache hit
            CacheEntry temp = cacheMap.get(key);
            temp.frequency++;
            temp.time = System.nanoTime();
            return temp.data;
        }
        return -1;
    }

    public void put(int key, int value) {
        CacheEntry temp;
        if (cacheMap.containsKey(key)) {
            temp = cacheMap.get(key);
            temp.update(value);
        } else {
            if (isFull()) {
                int entryKeyToBeRemoved = getLFUKey();
                cacheMap.remove(entryKeyToBeRemoved);
            }
            temp = new CacheEntry(key, value);
            cacheMap.put(key, temp);
        }
    }

    public int getLFUKey() {
        return 0;
    }

    public boolean isFull() {
        return cacheMap.size() == capacity;
    }

    public static void main(String[] args) {
        LFUCache2 lfu = new LFUCache2(2);
        lfu.put(2, 1);
        lfu.put(3, 2);
        int result = lfu.get(3);      // 返回 1
        System.out.println("The result is: " + result);
        result = lfu.get(2);
        System.out.println("The result is: " + result);
        lfu.put(4, 3);
        result = lfu.get(2);
        System.out.println("The result is: " + result);
        result = lfu.get(3);
        System.out.println("The result is: " + result);
        result = lfu.get(4);
        System.out.println("The result is: " + result);
    }
}
