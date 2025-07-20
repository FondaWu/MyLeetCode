package dp;

import common.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 907. 子数组的最小值之和(中等)
 * 【描述】
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 *
 * 【示例】
 * 示例 1：
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 *
 * 【提示】
 * 1）1 <= arr.length <= 3 * 104
 * 2）1 <= arr[i] <= 3 * 104
 */

public class SumSubarrayMins {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        //int[] arr = {11, 81, 94, 43, 3};
        //int[] arr = Utils.readArrayFromFile("res\\907\\86.txt");
        long start = System.currentTimeMillis();
        int result = new SumSubarrayMins().sumSubarrayMins(arr);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("计算结果:" + result);
    }

    public int sumSubarrayMins(int[] arr) {
        final int MOD = (int) 1e9 + 7;
        int dp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp += arr[i];
            int min = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < min) min = arr[j];
                dp += min;
            }
            dp %= MOD;
        }
        return dp;

    }

    public int sumSubarrayMins1(int[] arr) {
        final int MOD = (int) 1e9 + 7;
        int result = Arrays.stream(arr).sum();
        int n = arr.length, tmp;
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) arr[i] = arr[i + 1];
            }
            tmp = Arrays.stream(arr, 0, n - 1).sum();
            result = (result + tmp) % MOD;
            n--;
        }
        return result % MOD;
    }
}
