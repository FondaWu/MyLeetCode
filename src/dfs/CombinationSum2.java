package dfs;

import java.util.*;

/**
 * 39. 组合总和(中等)
 * 【描述】
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * <p>
 * 【提示】
 * 1) 1 <= candidates.length <= 100
 * 2) 1 <= candidates[i] <= 50
 * 3) 1 <= target <= 30
 */
public class CombinationSum2 {
    private static List<List<Integer>> numLists = new ArrayList<>();
    private static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {
        //int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        //int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println("开始计算。。。");
        long start = System.currentTimeMillis();
        List<List<Integer>> numLists = new CombinationSum2().combinationSum(candidates, 8);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        for (List<Integer> numList : numLists) {
            System.out.println(Arrays.toString(numList.toArray()));
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        doCombinationSum(candidates, 0, target);
        HashSet set = new HashSet<>(numLists);
        numLists.clear();
        numLists.addAll(set);
        return numLists;
    }

    private void doCombinationSum(int[] candidates, int n, int target) {
        if (target == 0) {
            numLists.add(new ArrayList<>(numList));
        } else if (n < candidates.length) {
            doCombinationSum(candidates, n + 1, target);
            if (target >= candidates[n]) {
                int i = n + 1;
                int delta = candidates[n];
                numList.add(candidates[n]);
                while (i < candidates.length && candidates[i] == candidates[n] && target >= delta) {
                    delta += candidates[i];
                    numList.add(candidates[n]);
                    i++;
                }
                doCombinationSum(candidates, i, target - delta);
                for (int j = i; j > n; j--) {
                    numList.remove(numList.size() - 1);
                }
            }
        }
    }

    private void doCombinationSum1(int[] candidates, int n, int target) {
        if (target == 0) {
            numLists.add(new ArrayList<>(numList));
        } else if (n < candidates.length) {
            if (target >= candidates[n]){
                doCombinationSum(candidates, n + 1, target);
                numList.add(candidates[n]);
                doCombinationSum(candidates, n + 1, target - candidates[n]);
                numList.remove(numList.size() - 1);
            }
        }
    }
}
