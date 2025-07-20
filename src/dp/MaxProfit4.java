package dp;

/**
 * 188. 买卖股票的最佳时机 IV（困难）
 * 【描述】
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3
 * <p>
 * 【提示】
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 **/

public class MaxProfit4 {

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        int result = new MaxProfit4().maxProfit(k, prices);
        System.out.println("计算结果：" + result);
    }

    public int maxProfit(int k, int[] prices) {
        int[] buys = new int[k];
        int[] sells = new int[k];
        for (int i = 0; i < k; i++) {
            buys[i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                // j-1天卖掉的获利值，第1天为0
                int sellJMinus1 = j > 0 ? sells[j - 1] : 0;
                // 买了j次的最大获利值等于：昨天买了j次，和昨天卖了j-1次，今天再买的最大值
                buys[j] = Math.max(buys[j], sellJMinus1 - prices[i]);
                // 卖了j次的最大获利值等于：昨天卖了j次，和昨天买了j次，今天再卖掉的最大值
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }
        return sells[k - 1];
    }

    public int maxProfit1(int k, int[] prices) {
        // 定义三维动态数组
        int[][][] dp = new int[prices.length][2][k + 1];

        // 第一天未持有股票且i次交易的获利值统一初始化为-prices[0]
        for (int i = 0; i <= k; i++) {
            dp[0][1][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // 今天未持有股票，且j次交易的最大获利等于：昨天未持有股票且有j次交易，和昨天持有股票且j-1次交易然后今天卖掉股票两者最大值
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
            }
            for (int j = 0; j < k; j++) {
                // 今天持有股票，且j次交易的最大获利等于：昨天持有股票且有j次交易和昨天未持有股票且j次交易然后今天买股票的两者最大值
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
            }
        }
        return dp[prices.length - 1][0][k];
    }
}
