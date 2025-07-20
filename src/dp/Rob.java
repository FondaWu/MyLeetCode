package dp;

import java.util.Arrays;
/*
198. 打家劫舍（中等）
【描述】
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
【提示】
1）1 <= nums.length <= 100
2）0 <= nums[i] <= 400
 */

public class Rob {

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 1};
        //int[] nums = {2, 1, 1, 2};
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println("The result is: " + rob(nums));
        System.out.println("The result is: " + rob1(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length < 1) return 0;

        int[][] count = new int[nums.length][2];
        count[0][0] = 0;
        count[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            count[i][0] = Math.max(count[i - 1][0], count[i - 1][1]);
            count[i][1] = count[i - 1][0] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(count[i][0] + " ");
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(count[i][1] + " ");
        }
        System.out.println();

        return Math.max(count[nums.length - 1][0], count[nums.length - 1][1]);
    }

    public static int rob1(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length < 2) return nums[0];

        int[] count1 = new int[nums.length];
        int[] count2 = new int[nums.length];

        count1[0] = 0;
        count2[0] = nums[0];
        count1[1] = count2[0];
        count2[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            count1[i] = Math.max(count2[i - 2], count1[i - 2] + nums[i - 1]);
            count2[i] = count1[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(count1));
        System.out.println(Arrays.toString(count2));
        return Math.max(count1[nums.length - 1], count2[nums.length - 1]);
    }

}
