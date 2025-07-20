package dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换（中等）
 * 【描述】
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 【提示】
 * 1) 1 <= coins.length <= 12
 * 2) 1 <= coins[i] <= 231 - 1
 * 3) 0 <= amount <= 104
 **/
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2, 4};
        //int[] coins = {474, 83, 404, 3};
        int result = new CoinChange().coinChange(coins, 11);
        System.out.println("计算结果：" + result);
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        // 将dp数组填充最大值，因为我们求的是最小硬币数
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 穷举每一个目标数的最小硬币数
        for (int i = 1; i <= amount; i++) {
            // 对每种子问题都穷举
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) break;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
            System.out.println("dp[" + i + "]=" + dp[i]);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
