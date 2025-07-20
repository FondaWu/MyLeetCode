package number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitNum {

    public static void main(String[] args) {
        int result = splitNum(4325);
        System.out.println("The result is:" + result);
    }

    private static int splitNum(int num) {
        List<Integer> dataList = new ArrayList<>();
        int i, n;
        do {
            n = num - num / 10 * 10;
            for (i = 0; i < dataList.size() && dataList.get(i) < n; i++) ;
            dataList.add(i, n);
            num /= 10;
        } while (num > 0);

        int num1 = 0, num2 = 0;
        for (int data : dataList) {
            if (num1 < num2) {
                num1 = num1 * 10 + data;
            } else {
                num2 = num2 * 10 + data;
            }
        }

        return num1 + num2;
    }

    private static int splitNum1(int num) {
        List<Integer> dataList = new ArrayList<>();
        do {
            dataList.add(num - num / 10 * 10);
            num /= 10;
        } while (num > 0);
        Collections.sort(dataList);

        int num1 = 0, num2 = 0;
        for (int data : dataList) {
            if (num1 < num2) {
                num1 = num1 * 10 + data;
            } else {
                num2 = num2 * 10 + data;
            }
        }

        return num1 + num2;
    }
}
