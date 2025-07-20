package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 2006. 差的绝对值为 K 的数对数目（简单）
 * 【描述】
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * <p>
 * 【提示】
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 */
public class CountKDifference {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 2, 1};
        int k = 1;
        int result = new CountKDifference().countKDifference(nums, k);
        System.out.println("The result is:" + result);
    }

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += map.getOrDefault(nums[i] - k, 0) + map.getOrDefault(nums[i] + k,0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }

    public int countKDifference1(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k)
                    count++;
            }
        }
        return count;
    }
}
