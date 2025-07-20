package application.stockprice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice4 {
    private int currentTime = 0;

    private Map<Integer, Integer> priceMap = new HashMap<>();
    private TreeMap<Integer, Integer> priceCountMap = new TreeMap<>();

    public void update(int timestamp, int price) {
        if (timestamp > this.currentTime)
            this.currentTime = timestamp;
        if (priceMap.containsKey(timestamp)) {
            int oldPrice = priceMap.get(timestamp);
            if (oldPrice == price) return;
            int count = priceCountMap.getOrDefault(oldPrice, 0) - 1;
            if (count == 0) {
                priceCountMap.remove(oldPrice);
            } else {
                priceCountMap.put(oldPrice, count);
            }
        }
        priceCountMap.put(price, priceCountMap.getOrDefault(price, 0) + 1);
        priceMap.put(timestamp, price);
    }

    public int current() {
        if (currentTime == 0) return 0;
        return priceMap.get(this.currentTime);
    }

    public int maximum() {
        return priceCountMap.lastKey();
    }

    public int minimum() {
        return priceCountMap.firstKey();
    }

    public static void main(String[] args) {
        StockPrice4 stockPrice = new StockPrice4();
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
