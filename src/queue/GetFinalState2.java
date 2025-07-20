package queue;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 3266. K 次乘运算后的最终数组 II（困难）
 * 【描述】
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * k 次操作以后，你需要将 nums 中每一个数值对 109 + 7 取余。
 * 请你返回执行完 k 次乘运算以及取余运算之后，最终的 nums 数组。
 * 【示例】
 * 示例 1：
 * 输入：nums = [2,1,3,5,6], k = 5, multiplier = 2
 * 输出：[8,4,6,5,6]
 * 解释：
 * 操作	结果
 * 1 次操作后	[2, 2, 3, 5, 6]
 * 2 次操作后	[4, 2, 3, 5, 6]
 * 3 次操作后	[4, 4, 3, 5, 6]
 * 4 次操作后	[4, 4, 6, 5, 6]
 * 5 次操作后	[8, 4, 6, 5, 6]
 * 取余操作后	[8, 4, 6, 5, 6]
 * 示例 2：
 * 输入：nums = [100000,2000], k = 2, multiplier = 1000000
 * 输出：[999999307,999999993]
 * 解释：
 * 操作	结果
 * 1 次操作后	[100000, 2000000000]
 * 2 次操作后	[100000000000, 2000000000]
 * 取余操作后	[999999307, 999999993]
 * <p>
 * 【提示】
 * 1 <= nums.length <= 104
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * 1 <= multiplier <= 106
 */
public class GetFinalState2 {

    public static void main(String[] args) {
        //int nums[] = {2, 1, 3, 5, 6}, k = 5, multiplier = 2;
        //int nums[] = {100000, 2000}, k = 2, multiplier = 1000000;
        int nums[] = {161209470}, k = 56851412, multiplier = 39846;
        long start = System.currentTimeMillis();
        int[] result = new GetFinalState2().getFinalState(nums, k, multiplier);
        System.out.println("算法执行时间:" + (System.currentTimeMillis() - start) + "MS");
        System.out.println(Arrays.toString(result));
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1])
                return (int) (o1[0] - o2[0]);
            else
                return (int) (o1[1] - o2[1]);
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new long[]{i, nums[i]});
        }

        int mod = (int) (Math.pow(10, 9)) + 7;
        for (int i = 0; i < k; i++) {
            long[] tmp = pq.poll();
            if (tmp[1] > Integer.MAX_VALUE / multiplier)
                tmp[1] = (tmp[1] % mod) * multiplier;
            else
                tmp[1] *= multiplier;
            pq.offer(tmp);
        }
        int[] result = new int[nums.length];

        while (!pq.isEmpty()) {
            long[] tmp = pq.poll();
            result[(int) tmp[0]] = (int) (tmp[1] % mod);
        }
        return result;
    }


}
