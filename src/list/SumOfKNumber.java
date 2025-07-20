package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfKNumber {

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();

        long start = System.currentTimeMillis();
        sumOfKNumber(168, 50, dataList);
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    private static void sumOfKNumber(int sum, int n, List<Integer> dataList) {
        if (sum < 1 || n < 1) return;

        if (sum >= n) {
            dataList.add(0, n);
            sumOfKNumber(sum - n, n - 1, dataList);
            if (sum == n) {
                System.out.println(Arrays.toString(dataList.toArray()));
            }
            dataList.remove(0);
        }
        sumOfKNumber(sum, n - 1, dataList);
    }
}
