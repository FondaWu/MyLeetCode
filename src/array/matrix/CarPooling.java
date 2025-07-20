package array.matrix;

import java.util.Arrays;

/*
1094. 拼车(中等)
【描述】
车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放
他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则
请返回 false。

【示例】
示例 1：
输入：trips = [[2,1,5],[3,3,7]], capacity = 4
输出：false
示例 2：
输入：trips = [[2,1,5],[3,3,7]], capacity = 5
输出：true

【提示】
1）1 <= trips.length <= 1000
2）trips[i].length == 3
3）1 <= numPassengersi <= 100
4）0 <= fromi < toi <= 1000
5）1 <= capacity <= 105
 */
public class CarPooling {

    public static void main(String[] args) {
        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;
        boolean result = carPooling(trips, capacity);
        System.out.println("计算结果：" + result);
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] tripVals = new int[1000];
        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                tripVals[j] += trips[i][0];
                if (tripVals[j] > capacity)
                    return false;
            }
        }
        return true;
    }
}
