package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 216. 组合总和 III(中等)
 * 【描述】
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 【示例】
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * 【提示】
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class CombinationSum3 {
    private static List<List<Integer>> numLists = new ArrayList<>();
    private static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {
        int k = 9, n = 45;
        System.out.println("开始计算。。。");
        long start = System.currentTimeMillis();
        List<List<Integer>> numLists = new CombinationSum3().combinationSum(k, n);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        for (List<Integer> numList : numLists) {
            System.out.println(Arrays.toString(numList.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int k, int n) {
        dfs(1, k, n);
        return numLists;
    }

    private void dfs(int num, int k, int n) {
        if (k == 0 && n == 0) {
            numLists.add(new ArrayList<>(numList));
        } else if (k > 0 && n > 0 && num < 10) {
            dfs(num + 1, k, n);
            numList.add(num);
            dfs(num + 1, k - 1, n - num);
            numList.remove(numList.size() - 1);
        }
    }
}
