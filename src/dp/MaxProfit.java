package dp;

/*
121. 买卖股票的最佳时机（简单）
【描述】
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
【示例】
示例 1：
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
【提示】
1）1 <= prices.length <= 105
2）0 <= prices[i] <= 104
 */
public class MaxProfit {

    public static void main(String[] args) {
        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println("The result is: " + new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        // 定义动态规划中间过程数组
        int dp[] = new int[prices.length];
        // 初始化历史最低股价
        int minPrice = prices[0];
        // 初始化历史最大收益
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当天最大收益等于当前股价减去初始化历史最低股价
            dp[i] = prices[i] - minPrice;
            // 当天股价如果低于历史最低股价，更新历史最新股价
            minPrice = Math.min(minPrice, prices[i]);
            // 保存到当天为止，最大的收益
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }

}
