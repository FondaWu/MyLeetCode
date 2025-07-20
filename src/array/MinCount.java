package array;

/*
LCP 06. 拿硬币(简单)
【描述】
桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
【提示】
1）1 <= n <= 4
2）1 <= coins[i] <= 10
 */
public class MinCount {

    public static void main(String[] args) {
        int[] coins = {2, 3, 10};
        int result = minCount(coins);
        System.out.println("计算结果：" + result);
    }

    public static int minCount(int[] coins) {
        int result = 0;

        for (int i = 0; i < coins.length; i++) {
            result += coins[i] >> 1;
            if (coins[i] % 2 > 0)
                result++;
        }
        return result;
    }
}
