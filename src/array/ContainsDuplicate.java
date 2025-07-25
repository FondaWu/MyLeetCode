package array;

import java.util.HashSet;
import java.util.Set;

/*
217 存在重复元素
描述：给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};

        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }
}
