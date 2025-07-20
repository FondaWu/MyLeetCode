package array;

import common.Utils;

import java.util.*;

/*
2736. 最大和查询(困难)
【描述】
给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 queries[i] = [xi, yi] 。
对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，找出 nums1[j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。
返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。
【示例】
示例 1：
输入：nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
输出：[6,10,7]
解释：
对于第 1 个查询：xi = 4 且 yi = 1 ，可以选择下标 j = 0 ，此时 nums1[j] >= 4 且 nums2[j] >= 1 。nums1[j] + nums2[j] 等于 6 ，可以证明 6 是可以获得的最大值。
对于第 2 个查询：xi = 1 且 yi = 3 ，可以选择下标 j = 2 ，此时 nums1[j] >= 1 且 nums2[j] >= 3 。nums1[j] + nums2[j] 等于 10 ，可以证明 10 是可以获得的最大值。
对于第 3 个查询：xi = 2 且 yi = 5 ，可以选择下标 j = 3 ，此时 nums1[j] >= 2 且 nums2[j] >= 5 。nums1[j] + nums2[j] 等于 7 ，可以证明 7 是可以获得的最大值。
因此，我们返回 [6,10,7] 。
示例 2：
输入：nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
输出：[9,9,9]
解释：对于这个示例，我们可以选择下标 j = 2 ，该下标可以满足每个查询的限制。
示例 3：
输入：nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
输出：[-1]
解释：示例中的查询 xi = 3 且 yi = 3 。对于每个下标 j ，都只满足 nums1[j] < xi 或者 nums2[j] < yi 。因此，不存在答案。

【提示】
1）nums1.length == nums2.length
2）n == nums1.length
3）1 <= n <= 105
4）1 <= nums1[i], nums2[i] <= 109
5）1 <= queries.length <= 105
6）queries[i].length == 2
7）xi == queries[i][1]
8）yi == queries[i][2]
9）1 <= xi, yi <= 109
 */

public class MaximumSumQueries {

    public static void main(String[] args) {
        /*
        int[] nums1 = {50, 50, 45, 10};
        int[] nums2 = {22, 20, 87, 17};
        int[][] queries = {{70, 38}, {5, 97}, {2, 57}, {90, 96}, {5, 12}};
        //*/

        //*
        int[] nums1 = Utils.readArrayFromFile("res\\2736\\1404\\nums1.txt");
        int[] nums2 = Utils.readArrayFromFile("res\\2736\\1404\\nums2.txt");
        int[][] queries = Utils.read2dArrayFromFile("res\\2736\\1404\\queries.txt");
        //*/
        System.out.println("开始计算。。。");
        long start = System.currentTimeMillis();
        int[] results = maximumSumQueries(nums1, nums2, queries);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        //System.out.println("计算结果：" + Arrays.toString(results));
    }

    private static int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[][] nums = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        int[][] queries2 = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            queries2[i][0] = queries[i][0];
            queries2[i][1] = queries[i][1];
            queries2[i][2] = i;
        }

        Arrays.sort(queries2, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        int[] results = new int[queries.length];
        Map<Integer, Integer> valueMap = new HashMap<>();
        int key, n;
        for (int i = 0; i < queries2.length; i++) {
            n = queries2[i][2];
            key = queries2[i][1] * 100 + queries2[i][0];
            if (valueMap.containsKey(key)) {
                results[n] = valueMap.get(key);
            } else {
                results[n] = -1;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j][0] < queries2[i][0])
                        break;
                    if (nums[j][1] >= queries2[i][1]) {
                        results[n] = Math.max(results[n], nums[j][0] + nums[j][1]);
                    }
                }
                valueMap.put(key, results[n]);
            }
        }
        return results;
    }

    private static int[] maximumSumQueries3(int[] nums1, int[] nums2, int[][] queries) {
        int[][] nums = new int[nums1.length][2];
        for (int j = 0; j < nums1.length; j++) {
            nums[j][0] = nums1[j];
            nums[j][1] = nums2[j];
        }
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        int[] results = new int[queries.length];
        Map<Integer, Integer> valueMap = new HashMap<>();
        int key, last;
        for (int i = 0; i < queries.length; i++) {
            key = queries[i][1] * 100 + queries[i][0];
            if (valueMap.containsKey(key)) {
                results[i] = valueMap.get(key);
            } else {
                results[i] = -1;
                last = Integer.MIN_VALUE;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j][0] < queries[i][0])
                        break;
                    if (nums[j][0] == last) continue;
                    if (nums[j][1] >= queries[i][1]) {
                        if (nums[j][0] + nums[j][1] > results[i]) {
                            last = nums[j][0];
                            results[i] = nums[j][0] + nums[j][1];
                        }
                    }
                }
                valueMap.put(key, results[i]);
            }
        }
        return results;
    }

    private static int[] maximumSumQueries2(int[] nums1, int[] nums2, int[][] queries) {
        int[] results = new int[queries.length];
        Map<Integer, Integer> valueMap = new HashMap<>();
        int key;
        for (int i = 0; i < results.length; i++) {
            key = queries[i][1] * 100 + queries[i][0];
            if (valueMap.containsKey(key)) {
                results[i] = valueMap.get(key);
            } else {
                results[i] = -1;
                for (int j = 0; j < nums1.length; j++) {
                    if (nums1[j] >= queries[i][0] && nums2[j] >= queries[i][1]) {
                        results[i] = Math.max(results[i], nums1[j] + nums2[j]);
                    }
                }
                valueMap.put(key, results[i]);
            }
        }
        return results;
    }

    private static int[] maximumSumQueries1(int[] nums1, int[] nums2, int[][] queries) {
        int[] results = new int[queries.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = -1;
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] >= queries[i][0] && nums2[j] >= queries[i][1]) {
                    results[i] = Math.max(results[i], nums1[j] + nums2[j]);
                }
            }
        }
        return results;
    }

}
