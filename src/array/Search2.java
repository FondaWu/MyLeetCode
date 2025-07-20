package array;

/**
 * 81. 搜索旋转排序数组 II(中等)
 * 【描述】
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 你必须尽可能减少整个操作步骤。
 * 【示例】
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 * 【提示】
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 */
public class Search2 {

    public static void main(String[] args) {
        //int nums[] = new int[]{2, 5, 6, 0, 0, 1, 2}, target = 0;
        //int nums[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}, target = 2;
        int nums[] = new int[]{1}, target = 0;

        boolean result = new Search2().search(nums, target);
        System.out.println("计算结果:" + result);
    }

    public boolean search(int[] nums,  int target) {
        // 定义首尾索引值
        int end = nums.length - 1;
        while (end != 0 && nums[end] == nums[0]) {
            end--;
        }
        return doSearch(nums, end, target);
    }

    public boolean doSearch(int[] nums, int end, int target) {
        // 定义首尾索引值
        int start = 0;
        // 循环比较首尾索引值大小，直到首索引值大于尾索引值
        while (start <= end) {
            // 如果目标数值等于首尾数值,直接返回结果
            if (nums[start] == target || nums[end] == target) return true;

            // 计算中间索引值，如果中间数值等于目标数值,直接返回结果
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) return true;

            // 如果中间数值大于首数值，那么说明首数值和中间数值是在同一递增序列
            if (nums[middle] > nums[start] || (nums[middle] == nums[start] && nums[middle] != nums[end])) {
                // 目标值在此递增序列的条件就是大于首数值并且小于中间数值，
                if ((target > nums[start] && target < nums[middle]) || (target > nums[start] && nums[start] == nums[middle]))
                    end = middle - 1;
                else // 否则则是在另一数列
                    start = middle + 1;
            } else {
                // 目标值在此递增序列的条件就是大于中间数值并且小于尾数值
                if ((target > nums[middle] && target < nums[end]) || (target > nums[middle] && nums[middle] == nums[end]))
                    start = middle + 1;
                else // 否则则是在另一数列
                    end = middle - 1;
            }
        }

        return false;
    }


}
