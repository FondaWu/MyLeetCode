package dp;


import java.util.HashMap;
import java.util.Map;

/*
LCR 127. 跳跃训练（简单）
【描述】
今天的有氧运动训练内容是在一个长条形的平台上跳跃。平台有 num 个小格子，每次可以选择跳 一个格子 或者 两个格子。请返回在训练过程中，学员们共有多少种不同的跳跃方式。
结果可能过大，因此结果需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
【示例 】
示例 1：
输入：n = 2
输出：2
示例 2：
输入：n = 5
输出：8
【提示】
1）0 <= n <= 100
注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class TrainWays {
    private Map<Integer, Integer> tempMap = new HashMap();

    public static void main(String[] args) {
        int result = new TrainWays().trainWays3(3000);
        System.out.println("计算结果：" + result);
    }

    public int trainWays(int num) {
        if (num == 0) return 1;
        if (num < 3) return num;

        int[] dp = new int[num];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < num; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;

        return dp[num - 1];
    }

    public int trainWays2(int num) {
        if (num == 0) return 1;
        if (num < 3) return num;

        if (tempMap.containsKey(num)) {
            return tempMap.get(num);
        } else {
            return (trainWays2(num - 1) + trainWays2(num - 2)) % 1000000007;
        }
    }

    public int trainWays3(int num) {
        if (num == 0) return 1;
        if (num < 3) return num;

        int a = 1;
        int b = 2;

        int result = 0;
        for (int i = 3; i <= num; i++) {
            result = (a + b) % 1000000007;
            a = b;
            b = result;
        }
        return result;
    }
}
