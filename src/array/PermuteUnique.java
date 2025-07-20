package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2};
        List<List<Integer>> numLists = permuteUnique(nums);

        for (List<Integer> numList : numLists) {
            System.out.println(Arrays.toString(numList.toArray()));
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> numLists = new ArrayList<>();
        List<Integer> numlist = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        Arrays.sort(nums);
        selectNext(numLists, numlist, nums, 0, mark);

        return numLists;
    }

    private static void selectNext(List<List<Integer>> numLists, List<Integer> numlist, int[] nums, int n, boolean[] mark) {
        if (n == nums.length) {
            numLists.add(new ArrayList<>(numlist));
            return;
        }

        boolean b;
        for (int i = 0; i < nums.length; i++) {
            b = (i > 0 && nums[i] == nums[i - 1] && !mark[i - 1]);
            if (mark[i] || b)
                continue;

            numlist.add(nums[i]);
            mark[i] = true;
            selectNext(numLists, numlist, nums, n + 1, mark);
            numlist.remove(n);
            mark[i] = false;
        }
    }

    public static List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> numLists = new ArrayList<>();
        List<Integer> numlist = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        selectNext1(numLists, numlist, nums, 0, mark);

        HashSet set = new HashSet<>(numLists);
        numLists.clear();
        numLists.addAll(set);
        return numLists;
    }

    private static void selectNext1(List<List<Integer>> numLists, List<Integer> numlist, int[] nums, int n, boolean[] mark) {
        if (n == nums.length) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(numlist);
            numLists.add(copy);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!mark[i]) {
                numlist.add(nums[i]);
                mark[i] = true;
                selectNext1(numLists, numlist, nums, n + 1, mark);
                numlist.remove(n);
                mark[i] = false;
            }
        }
    }
}
