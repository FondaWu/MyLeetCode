package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
46. 全排列(中等)
描述：给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
提示：
1)1 <= nums.length <= 6
2)-10 <= nums[i] <= 10
3）nums 中的所有整数 互不相同
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> numLists = permute(nums);

        System.out.println("排列循序一共有" + numLists.size());
        //*
        for (List<Integer> numList : numLists) {
            System.out.println(Arrays.toString(numList.toArray()));
        }//*/

    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> numLists = new ArrayList<>();
        List<Integer> numlist = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        selectNext(numLists, numlist, nums, 0, mark);
        return numLists;
    }

    private static void selectNext(List<List<Integer>> numLists, List<Integer> numlist, int[] nums, int n, boolean[] mark) {
        if (n == nums.length) {
            numLists.add(new ArrayList<>(numlist));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!mark[i]) {
                numlist.add(nums[i]);
                mark[i] = true;
                selectNext(numLists, numlist, nums, n + 1, mark);
                numlist.remove(n);
                mark[i] = false;
            }
        }
    }

    private static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> numLists = new ArrayList<>();
        List<Integer> numlist = new ArrayList<>();
        selectNext1(numLists, numlist, nums, 0);
        return numLists;
    }

    private static void selectNext1(List<List<Integer>> numLists, List<Integer> numlist, int[] nums, int n) {
        if (n == nums.length) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(numlist);
            numLists.add(copy);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!numlist.contains(nums[i])) {
                numlist.add(nums[i]);
                selectNext1(numLists, numlist, nums, n + 1);
                numlist.remove(n);
            }
        }
    }
}
