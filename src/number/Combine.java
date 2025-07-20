package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
77. 组合（中等）
【描述】
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案。

【提示】
1）1 <= n <= 20
2）1 <= k <= n
 */
public class Combine {

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    private static List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            doCombine(n, k, list, lists);
            return lists;
    }

    private static void doCombine(int n, int k, List<Integer> list, List<List<Integer>> lists) {
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(n);
        doCombine(n - 1, k - 1, list, lists);
        list.remove(list.size()-1);
        if (n > k)
            doCombine(n - 1, k, list, lists);
    }
}
