package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集（中等）
 * 【描述】
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 【示例】
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 【提示】
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Subsets {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int nums[] = {1, 2, 3};
        List<List<Integer>> lists = new Subsets().subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println("result = " + Arrays.toString(list.toArray()));
        }
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, lists, list);
        return lists;
    }

    private void dfs(int[] nums, int n, List<List<Integer>> lists, List<Integer> list) {
        if (n < nums.length) {
            list.add(nums[n]);
            dfs(nums, n + 1, lists, list);
            list.remove(list.size() - 1);
            dfs(nums, n + 1, lists, list);
        } else {
            lists.add(new ArrayList<>(list));
        }
    }
}
