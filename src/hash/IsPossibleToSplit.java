package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 3046. 分割数组（简单）
 * 【描述】
 * 给你一个长度为 偶数 的整数数组 nums 。你需要将这个数组分割成 nums1 和 nums2 两部分，要求：
 * nums1.length == nums2.length == nums.length / 2 。
 * nums1 应包含 互不相同 的元素。
 * nums2也应包含 互不相同 的元素。
 * 如果能够分割数组就返回 true ，否则返回 false 。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：nums = [1,1,2,2,3,4]
 * 输出：true
 * 解释：分割 nums 的可行方案之一是 nums1 = [1,2,3] 和 nums2 = [1,2,4] 。
 * 示例 2：
 * 输入：nums = [1,1,1,1]
 * 输出：false
 * 解释：分割 nums 的唯一可行方案是 nums1 = [1,1] 和 nums2 = [1,1] 。但 nums1 和 nums2 都不是由互不相同的元素构成。因此，返回 false 。
 * <p>
 * 【提示】
 * 1 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class IsPossibleToSplit {

    public static void main(String[] args) {
        //int nums[] = {1, 1, 2, 2, 3, 4};
        int nums[] = {6, 1, 3, 1, 1, 8, 9, 2};
        boolean result = new IsPossibleToSplit().isPossibleToSplit(nums);
        System.out.println("The result is:" + result);
    }

    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> dataCounts = new HashMap<>();

        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = dataCounts.getOrDefault(nums[i], 0);
            if (count == 2)
                return false;
            dataCounts.put(nums[i], count + 1);
            if (count > 1) tmp++;
        }

        return tmp <= nums.length / 2;
    }
}
