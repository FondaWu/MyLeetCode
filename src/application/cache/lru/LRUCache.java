package application.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
146. LRU 缓存(中等)
【描述】
请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入
操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
【提示】
1）1 <= capacity <= 3000
2）0 <= key <= 10000
3）0 <= value <= 105
4）最多调用 2 * 105 次 get 和 put
 */

public class LRUCache {
    private int capacity;

    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    };

    public LRUCache(int capacity) {
        if (capacity < 1) throw new RuntimeException("Invalid capacity value.");
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        System.out.println("The result is: " + cache.get(1));
        System.out.println("The result is: " + cache.get(2));
    }

}
