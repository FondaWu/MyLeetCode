package hash;

import java.util.HashMap;

/**
 * 1865. 找出和为指定值的下标对（中等）
 * 【描述】
 * 给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构：
 * 累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
 * 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <= j < nums2.length）。
 * 实现 FindSumPairs 类：
 * FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 对象。
 * void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val 。
 * int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目。
 * 【示例】
 * 输入：
 * ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
 * [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
 * 输出：
 * [null, 8, null, 2, 1, null, null, 11]
 * 解释：
 * FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
 * findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
 * findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
 * findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
 * findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
 * findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
 * findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
 * findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
 * 【提示】
 * 1 <= nums1.length <= 1000
 * 1 <= nums2.length <= 105
 * 1 <= nums1[i] <= 109
 * 1 <= nums2[i] <= 105
 * 0 <= index < nums2.length
 * 1 <= val <= 105
 * 1 <= tot <= 109
 * 最多调用 add 和 count 函数各 1000 次
 */
public class FindSumPairs {

    private int nums1[];
    private int nums2[];

    private HashMap<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
    }

    public void add(int index, int val) {
        if (val == 0) return;

        int key1 = this.nums2[index];
        nums2[index] += val;
        int key2 = key1 + val;
        map.put(key1, map.get(key1) - 1);
        map.put(key2, map.getOrDefault(key2, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int target = tot - nums1[i];
            count += map.getOrDefault(target, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums1[] = new int[]{1, 1, 2, 2, 2, 3};
        int nums2[] = new int[]{1, 4, 5, 2, 5, 4};
        FindSumPairs findSumPairs = new FindSumPairs(nums1, nums2);
        System.out.println(findSumPairs.count(7));  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
        findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8));  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
        System.out.println(findSumPairs.count(4));  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
        findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7));  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4)
    }
}
