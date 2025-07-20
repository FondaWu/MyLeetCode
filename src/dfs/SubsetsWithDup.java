package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 90. 子集 II（中等）
 * 【描述】
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集（幂集）。解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 【提示】
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int nums[] = {1, 2, 2, 2};
        List<List<Integer>> lists = new SubsetsWithDup().subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println("result = " + Arrays.toString(list.toArray()));
        }
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, lists, list);
        HashSet set = new HashSet<>(lists);
        lists.clear();
        lists.addAll(set);
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

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs1(nums, 0, true, lists, list);
        return lists;
    }

    private void dfs1(int[] nums, int n, boolean choose, List<List<Integer>> lists, List<Integer> list) {
        if (n < nums.length) {
            dfs1(nums, n + 1, false, lists, list);
            if (!choose && n > 0 && nums[n - 1] == nums[n])
                return;
            list.add(nums[n]);
            dfs1(nums, n + 1, true, lists, list);
            list.remove(list.size() - 1);
        } else {
            lists.add(new ArrayList<>(list));
        }
    }


}
