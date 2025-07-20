package dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum4 {
    private static List<List<Integer>> numLists = new ArrayList<>();
    private static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int result = new CombinationSum4().combinationSum4(nums, 4);
        System.out.println("计算结果：" + result);
    }

    public int combinationSum4(int[] nums, int target) {
        dfs(nums, 0, target);
        return numLists.size();
    }

    private static void dfs(int[] nums, int i, int target){
        if (target == 0) {
            numLists.add(new ArrayList<>(numList));
        } else if (i < nums.length) {
            if (target >= nums[i]) {
                numList.add(nums[i]);
                dfs(nums, i, target - nums[i]);
                numList.remove(numList.size() - 1);
            }
            dfs(nums, i + 1, target);
        }
    }
}
