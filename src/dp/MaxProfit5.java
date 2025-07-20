package dp;

/**
 * 309. 买卖股票的最佳时机含冷冻期（中等）
 * 【描述】
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 【示例】
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 *
 * 【提示】
 * 1）1 <= prices.length <= 5000
 * 2）0 <= prices[i] <= 1000
 **/
public class MaxProfit5 {

    public static void main(String[] args) {
        //int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        //int[] prices = {1, 2, 3, 4, 5};
        //int[] prices = {1, 2, 4, 1, 7, 2,1 5, 8, 1, 6, 2, 4, 3, 9, 0};
        int[] prices = {1, 7, 2, 4, 3, 2, 5};
        int result = new MaxProfit5().maxProfit(prices);
        System.out.println("计算结果：" + result);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 初始化dp数组，第一天利润肯定为0
        dp[0][0] = prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果当天价格比昨天高，那么总利润等于之前利润加上两天之差
            if (prices[i] > prices[i - 1])
                dp[i][1] =  prices[i] - prices[i - 1];
                // 否则不要投资，利润不变
            else{
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = prices[i];
            }

        }

        return dp[prices.length - 1][1];
    }



}
