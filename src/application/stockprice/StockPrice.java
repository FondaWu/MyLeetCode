package application.stockprice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPrice {
    private int currentTime = 0;

    public StockPrice() {
    }

    private class Pair {
        public int timestamp;
        public int price;

        public Pair(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }

        @Override
        public boolean equals(Object obj) {
            Pair obj2 = (Pair) obj;
            //并且当前对象的id与obj对象的id相等才可判断两个对象相等
            return (this.timestamp == obj2.timestamp);
        }
    }

    private Map<Integer, Integer> timePriceMap = new HashMap<>();

    private PriorityQueue<Pair> minHeap = new PriorityQueue<>(100, Comparator.comparingInt(o -> o.price));

    private PriorityQueue<Pair> maxHeap = new PriorityQueue<>(100, (o1, o2) -> o2.price - o1.price);

    private void put(int timestamp, int price) {
        Pair pair = new Pair(timestamp, price);
        if (timePriceMap.containsKey(timestamp)) {
            minHeap.remove(pair);
            maxHeap.remove(pair);
        }
        minHeap.offer(pair);
        maxHeap.offer(pair);
        timePriceMap.put(timestamp, price);
    }

    public void update(int timestamp, int price) {
        if (timestamp > this.currentTime)
            this.currentTime = timestamp;
        this.put(timestamp, price);
    }

    public int current() {
        if (currentTime == 0) return 0;
        return timePriceMap.get(this.currentTime);
    }

    public int maximum() {
        if (this.maxHeap.size() == 0) return 0;
        return this.maxHeap.peek().price;
    }

    public int minimum() {
        if (this.minHeap.size() == 0) return 0;
        return this.minHeap.peek().price;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(1, 10);
        // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        stockPrice.update(2, 5);
        // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        System.out.println(stockPrice.current());
        // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        System.out.println(stockPrice.maximum());
        // 之前时间戳为 1 的价格错误，价格更新为 3 ,   时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        stockPrice.update(1, 3);
        // 返回 5 ，更正后最高价格为 5 。
        System.out.println(stockPrice.maximum());
        // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        stockPrice.update(4, 2);
        // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
        System.out.println(stockPrice.minimum());
    }
}
