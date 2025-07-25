package queue;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 3264. K 次乘运算后的最终数组 I（简单）
 * 【描述】
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 * <p>
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
 * 示例 2：
 * 输入：nums = [1,2], k = 3, multiplier = 4
 * 输出：[16,8]
 * 解释：
 * 操作	结果
 * 1 次操作后	[4, 2]
 * 2 次操作后	[4, 8]
 * 3 次操作后	[16, 8]
 * <p>
 * 【提示】
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 10
 * 1 <= multiplier <= 5
 */
public class GetFinalState {

    public static void main(String[] args) {
        //int nums[] = {2, 1, 3, 5, 6}, k = 5, multiplier = 2;
        int nums[] = {4, 16, 64}, k = 10, multiplier = 4;
        long start = System.currentTimeMillis();
        int[] result = new GetFinalState().getFinalState(nums, k, multiplier);
        System.out.println("算法执行时间:" + (System.currentTimeMillis() - start) + "MS");
        System.out.println(Arrays.toString(result));
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});
        }

        for (int i = 0; i < k; i++) {
            int[] tmp = pq.poll();
            tmp[1] *= multiplier;
            pq.offer(tmp);
        }
        int[] result = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            result[tmp[0]] = tmp[1];
        }
        return result;
    }

    public int[] getFinalState1(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey() - o2.getKey();
            } else {
                return o1.getValue() - o2.getValue();
            }

        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair<>(i, nums[i]));
        }

        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> minPair = pq.poll();
            Pair<Integer, Integer> newPair = new Pair<>(minPair.getKey(), minPair.getValue() * multiplier);
            pq.offer(newPair);
        }
        int[] result = new int[nums.length];
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> minPair = pq.poll();
            result[minPair.getKey()] = minPair.getValue();
        }
        return result;
    }
}
