package dfs;

import java.util.*;

/**
 * 39. 组合总和(中等)
 * 【描述】
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 【提示】
 * 1）1 <= candidates.length <= 30
 * 2）2 <= candidates[i] <= 40
 * 3）candidates 的所有元素 互不相同
 * 4）1 <= target <= 40
 **/
public class CombinationSum {

    public static void main(String[] args) {
        //int[] candidates = {2, 3, 6, 7};
        //int[] candidates = {1, 2, 3};
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("开始计算。。。");
        long start = System.currentTimeMillis();
        List<List<Integer>> numLists = new CombinationSum().combinationSum(candidates, 30);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        for (List<Integer> numList : numLists) {
            //System.out.println(Arrays.toString(numList.toArray()));
        }
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> numLists = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        dfs(candidates, 0, target, numList, numLists);
        return numLists;
    }

    private void dfs(int[] candidates, int n, int target, List<Integer> numList, List<List<Integer>> numLists) {
        if (target == 0) {
            numLists.add(new ArrayList<>(numList));
        } else if (n < candidates.length) {
            dfs(candidates, n + 1, target, numList, numLists);
            if (target >= candidates[n]) {
                numList.add(candidates[n]);
                dfs(candidates, n, target - candidates[n], numList, numLists);
                numList.remove(numList.size() - 1);
            }
        }
    }

}
