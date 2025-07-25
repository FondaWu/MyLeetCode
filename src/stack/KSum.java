package stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/*
2386. 找出数组的第 K 大和（困难）
【描述】
给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。
数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复）
返回数组的 第 k 大和 。
子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。
注意：空子序列的和视作 0 。

【示例】
示例 1：
输入：nums = [2,4,-2], k = 5
输出：2
解释：所有可能获得的子序列和列出如下，按递减顺序排列：
- 6、4、4、2、2、0、0、-2
数组的第 5 大和是 2 。
示例 2：
输入：nums = [1,-2,3,4,-10,12], k = 16
输出：10
解释：数组的第 16 大和是 10 。

【提示】
1）n == nums.length
2）1 <= n <= 105
3）-109 <= nums[i] <= 109
4）1 <= k <= min(2000, 2n)
 */
public class KSum {

    public static void main(String[] args) {
        int[] nums = {2, 4, -2};
        int k = 5;
        long result = new KSum().kSum(nums, k);
        System.out.println("计算结果：" + result);
    }

    public long kSum(int[] nums, int k) {
        Stack<Integer> stk = new Stack<>();
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (nums[i] > 0 & i > -1) {
            stk.push(nums[i]);
            i--;
        }

        return 0;
    }

}
