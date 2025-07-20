package dfs;

import common.Utils;

/*
55. 跳跃游戏（中等）
【描述】
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
【示例】
示例 1：
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

【提示】
1）1 <= nums.length <= 104
2）0 <= nums[i] <= 105
 */
public class CanJump {
    public static void main(String[] args) {
        //int[] nums = new int[]{2, 3, 1, 1, 4};
        //int[] nums = new int[]{3, 2, 1, 0, 4};
        int[] nums = Utils.readArrayFromFile("res\\55\\75.txt");
        long start = System.currentTimeMillis();
        System.out.println("计算结果：" + new CanJump().canJump(nums));
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i > rightmost)
                return false;
            rightmost = Math.max(rightmost, i + nums[i]);
            if (rightmost >= n - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        return jump(nums, 0, mark);
    }

    public boolean jump(int[] nums, int n, boolean[] mark) {
        mark[n] = true;
        if (n > nums.length - 2) return true;
        for (int i = 1; i <= nums[n]; i++) {
            if (!mark[n + i] && jump(nums, n + i, mark))
                return true;
        }
        return false;
    }
}
