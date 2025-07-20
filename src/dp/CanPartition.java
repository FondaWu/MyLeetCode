package dp;

import common.Utils;

import java.util.Arrays;

/**
 * 416. 分割等和子集（中等）
 * 【描述】
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 【提示】
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class CanPartition {

    public static void main(String[] args) {
        //int nums[] = {1, 5, 11, 5};
        int[] nums = Utils.readArrayFromFile("res\\416\\39.txt");
        long start = System.currentTimeMillis();
        boolean result = new CanPartition().canPartition(nums);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("计算结果：" + result);
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) return false;
        sum >>= 1;

        int dp[][] = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {

        }
        return false;
    }

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) return false;
        sum >>= 1;
        return dfs(nums, 1, sum - nums[0]) && dfs(nums, 0, sum);
    }

    boolean dfs(int[] nums, int i, int target) {
        if (target == 0) return true;
        if (i >= nums.length) return false;

        return dfs(nums, i + 1, target - nums[i]) || dfs(nums, i + 1, target);
    }
}
