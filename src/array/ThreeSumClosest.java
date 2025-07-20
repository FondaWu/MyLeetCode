package array;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
16. 最接近的三数之和(中等)

【描述】
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。假定每组输入只存在恰好一个解。

【示例】
示例 1：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

示例 2：
输入：nums = [0,0,0], target = 1
输出：0

【提示】
1) 3 <= nums.length <= 1000
2) -1000 <= nums[i] <= 1000
3) -104 <= target <= 104
 */
public class ThreeSumClosest {
    private static int min = Integer.MAX_VALUE;
    private static int count = 0;
    private static int sumClosest = 0;

    public static void main(String[] args) {
        //int[] nums = {-1, 2, 1, -4};
        //int[] nums = {-1, -4, 1, 2, 1, -4};
        int[] nums = Utils.readArrayFromFile("res\\16\\56.txt");
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        int result = threeSumClosest(nums, 1);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("计算结果：" + result);
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(nums, i + 1, nums.length , nums[i], target);
        }
        return sumClosest;
    }

    private static void twoSum(int[] nums, int start, int len, int num0, int target) {
        int sum = num0;
        for (int i = start; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sum += nums[i] + nums[j];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    sumClosest = sum;
                }
            }
        }
    }

    private static int threeSumClosest1(int[] nums, int target) {
        boolean[] mark = new boolean[nums.length];
        selectNext(nums, 0, 0, target, mark);
        return sumClosest;
    }

    private static void selectNext(int[] nums, int n, int sum, int target, boolean[] mark) {
        if (count == 3) {
            if (Math.abs(sum - target) < min) {
                min = Math.abs(sum - target);
                sumClosest = sum;
            }
        } else {
            for (int i = n; i < nums.length; i++) {
                if (!mark[i]) {
                    mark[i] = true;
                    sum += nums[i];
                    count++;
                    selectNext(nums, n + 1, sum, target, mark);
                    sum -= nums[i];
                    count--;
                    mark[i] = false;
                }
            }
        }
    }
}
