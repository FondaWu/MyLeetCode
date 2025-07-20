package application.cache.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存(中等)
 * 【描述】
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入
 * 操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 【提示】
 * 1）1 <= capacity <= 3000
 * 2）0 <= key <= 10000
 * 3）0 <= value <= 105
 * 4）最多调用 2 * 105 次 get 和 put
 */

public class LRUCache2 {

    class Node {
        public int key;
        public int val;
        public Node last;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;

    private Node head;
    private Node tail;

    private Map<Integer, Node> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = new Node(-1, -1);
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = this.getNode(key);
        return node == null ? -1 : node.val;
    }

    private Node getNode(int key) {
        if (!map.containsKey(key))
            return null;

        Node node = map.get(key);
        if (node != head) {
            Node lastNode = node.last;
            Node nextNode = node.next;
            lastNode.next = nextNode;
            nextNode.last = lastNode;
            node.next = head;
            head.last = node;
            head = node;
        }
        return node;
    }

    public void put(int key, int val) {
        Node node;
        if (map.containsKey(key)) {
            node = this.getNode(key);
            node.val = val;
        } else {
            node = new Node(key, val);
            if (head == null) {
                node.next = tail;
                tail.last = node;
            } else {
                node.next = head;
                head.last = node;
            }
            head = node;
            map.put(key, node);

            if (map.size() > capacity) {
                Node tmp = tail.last;
                tmp.last.next = tail;
                tail.last = tmp.last;
                map.remove(tmp.key);
            }
        }

    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1); // 缓存是 {1=1}
        cache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(cache.get(1));    // 返回 1
        cache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(cache.get(2));    // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(cache.get(1));    // 返回 -1 (未找到)
        System.out.println(cache.get(3));    // 返回 3
        System.out.println(cache.get(4));    // 返回 4

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
    }

}
