package array;

import common.Utils;

import java.util.Arrays;

/*
421. 数组中两个数的最大异或值(中等)
【描述】
给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。

【示例】
示例 1：
输入：nums = [3,10,5,25,2,8]
输出：28
解释：最大运算结果是 5 XOR 25 = 28.
示例 2：
输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
输出：127
【提示】
1）1 <= nums.length <= 2 * 105
2）0 <= nums[i] <= 231 - 1
 */
public class FindMaximumXOR {

    public static void main(String[] args) {
        int[] nums = Utils.readArrayFromFile("res\\421\\41.txt");
        //int[] nums = {4, 5, 6};
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        int result = findMaximumXOR2(nums);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("计算结果：" + result);
    }

    private static int findMaximumXOR(int[] nums) {
        Arrays.sort(nums);

        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int n = nums[i] ^ nums[j];
                if (n > max) {
                    max = n;
                }
            }
        }
        return max;
    }

    private static int findMaximumXOR2(int[] nums) {
        Arrays.sort(nums);

        int i, j;
        int n1 = getHighestPos(nums[0]);
        int n2 = getHighestPos(nums[nums.length - 1]);
        int m1 = nums.length, m2 = -1;

        int max = nums[0] ^ nums[nums.length - 1];
        if (n2 > n1) {
            int highestPos = getHighestPos(max);
            for (i = 0; i < nums.length - 1 && getHighestPos(nums[i]) <= highestPos; i++) ;
            m1 = i;
            for (j = nums.length - 1; j >= 0 && getHighestPos(nums[j]) >= highestPos; j--) ;
            m2 = j;
        }
        for (i = 0; i < m1; i++) {
            for (j = nums.length - 1; j > m2; j--) {
                int n = nums[i] ^ nums[j];
                if (n > max) {
                    max = n;
                }
            }
        }
        return max;
    }

    private static int getHighestPos(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num >>= 1;
        }
        return count;
    }
}
