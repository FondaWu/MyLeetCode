package dp;

/*
53. 最大子数组和(中等)
【描述】
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。

【示例】
示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：
输入：nums = [1]
输出：1
示例 3：
输入：nums = [5,4,-1,7,8]
输出：23

【提示】
1）1 <= nums.length <= 105
2) -104 <= nums[i] <= 104
 */

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        int result = maxSubArray(nums);
        System.out.println("计算结果：" + result);
    }

    // 解题思路：采用动态规划的方法，数组每个下标对应的最大值，就是本位数字以及上一位的最大值加上本位数字的最大值
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
