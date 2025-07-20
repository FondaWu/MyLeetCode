package dp;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数（中等）
 * 【描述】
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 * <p>
 * 【示例】
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * <p>
 * 【提示】
 * 1）1 <= nums.length <= 2000
 * 2）-106 <= nums[i] <= 106
 **/
public class FindNumberOfLIS {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //int[] nums = new int[]{3, 1, 2};
        //int[] nums = new int[]{1, 3, 5, 4, 7};
        int[] nums = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        //int[] nums = new int[]{2, 2, 2, 2, 2};

        int result = new FindNumberOfLIS().findNumberOfLIS(nums);
        System.out.println("result = " + result);
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    public int findNumberOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int maxLen = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置计数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }


}
