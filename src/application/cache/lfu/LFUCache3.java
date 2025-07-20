package application.cache.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU 缓存（ 困难）
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * 实现 LFUCache 类：
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该
 * 在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 【示例】
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // 返回 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // 返回 4
 * // cache=[3,4], cnt(4)=2, cnt(3)=3
 * <p>
 * 【提示】
 * 1 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * 最多调用 2 * 105 次 get 和 put 方法
 */
public class LFUCache3 {

    private class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    private int capacity;
    private Map<Integer, Node> cacheMap;
    private Map<Integer, LinkedHashSet<Integer>> freqMap;
    private int min;

    public LFUCache3(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.freqMap.put(0, new LinkedHashSet<>());
        min = -1;
    }

    public int get(int key) {
        if (capacity == 0 || !cacheMap.containsKey(key)) return -1;

        // cache hit
        Node node = cacheMap.get(key);
        freqMap.get(node.count).remove(key);
        node.count++;

        if (!freqMap.containsKey(node.count)) {
            freqMap.put(node.count, new LinkedHashSet<>());
        }
        freqMap.get(node.count).add(key);

        if (min == node.count - 1 && freqMap.get(min).isEmpty()) {
            min = node.count;
        }

        return node.val;
    }

    public void put(int key, int data) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.val = data;
            get(key);
            return;
        }

        // 当容器缓存满时 这段时间使用频率最小的key
        if (cacheMap.size() == capacity) {
            Integer evictKey = freqMap.get(min).iterator().next();
            cacheMap.remove(evictKey);
            freqMap.get(min).remove(evictKey);
        }
        // 添加新节点时更新min
        min = 0;
        Node newNode = new Node(data, 0);
        cacheMap.put(key, newNode);
        freqMap.get(min).add(key);
    }

    public static void main(String[] args) {
        LFUCache3 lfu = new LFUCache3(2);
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
