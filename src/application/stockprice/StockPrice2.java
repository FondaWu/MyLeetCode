package application.stockprice;

import java.util.*;

public class StockPrice2 {
    private int currentTime = 0;

    private Map<Integer, Integer> timePriceMap = new HashMap<>();

    private List<Map.Entry<Integer,Integer>> entryList;

    private void put(int timestamp, int price) {
        timePriceMap.put(timestamp, price);
        entryList = new ArrayList(timePriceMap.entrySet());
        Collections.sort(entryList, Comparator.comparingInt(Map.Entry::getValue));
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
        if (this.entryList.size() == 0) return 0;
        return entryList.get(entryList.size()-1).getValue();
    }

    public int minimum() {
        if (this.entryList.size() == 0) return 0;
        return entryList.get(0).getValue();
    }

    public static void main(String[] args) {
        StockPrice2 stockPrice = new StockPrice2();
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
