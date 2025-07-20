package array;

/**
 * 33. 搜索旋转排序数组（中等）
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 【提示】
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 */
public class Search {

    public static void main(String[] args) {
        //int nums[] = new int[]{4, 5, 6, 7, 0, 1, 2}, target = 0;
        //int nums[] = new int[]{4, 5, 6, 7, 8, 1, 2, 3}, target = 8;
        //int nums[] = new int[]{8, 1, 2, 3, 4, 5, 6, 7}, target = 6;
        //int nums[] = new int[]{4, 5, 6, 7, 8, 1, 2, 3}, target = 8;
        //int nums[] = new int[]{3, 5, 1}, target = 3;
        int nums[] = new int[]{5, 1, 2, 3, 4}, target = 1;

        //int result = new Search().binarySearch(nums, 0, nums.length - 1, target);
        int result = new Search().search(nums, target);
        System.out.println("计算结果:" + result);
    }

    public int search(int[] nums, int target) {
        // 定义首尾索引值
        int start = 0, end = nums.length - 1;
        // 循环比较首尾索引值大小，直到首索引值大于尾索引值
        while (start <= end) {
            // 如果目标数值等于首尾数值,直接返回结果
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;

            // 计算中间索引值，如果中间数值等于目标数值,直接返回结果
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) return middle;

            // 如果中间数值大于首数值，那么说明首数值和中间数值是在同一递增序列
            if (nums[middle] > nums[start]) {
                // 目标值在此递增序列的条件就是大于首数值并且小于中间数值，
                if (target > nums[start] && target < nums[middle])
                    end = middle - 1;
                else // 否则则是在另一数列
                    start = middle + 1;
            } else { // 如果中间数值小于首数值，那么说明中间数值和尾数值是在同一递增序列
                // 目标值在此递增序列的条件就是大于中间数值并且小于尾数值
                if (target > nums[middle] && target < nums[end])
                    start = middle + 1;
                else // 否则则是在另一数列
                    end = middle - 1;
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        // 定义首尾索引值
        int start = 0, end = nums.length - 1;
       // 循环比较首尾索引值大小，直到首索引值大于尾索引值
        while (start <= end) {
            // 如果目标数值等于首尾数值,直接返回结果
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;

            // 计算中间索引值，如果中间数值等于目标数值,直接返回结果
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) return middle;

            // 如果中间数值小于尾数值，那么说明中间数值和尾数值是在同一递增序列
            if (nums[middle] < nums[end]) {
                // 那目标值在此递增序列的条件就是大于中间数值并且小于尾数值
                if (target > nums[middle] && target < nums[end])
                    start = middle + 1;
                else // 否则则是在另一数列
                    end = middle - 1;
            } else { // 如果中间数值大于尾数值，那么说明首数值和中间数值是在同一递增序列
               // 目标值在此递增序列的条件就是大于首数值并且小于中间数值，
                if (target > nums[start] && target < nums[middle])
                    end = middle - 1;
                else // 否则则是在另一数列
                    start = middle + 1;
            }
        }

        return -1;
    }

    public int search1(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;

            if (nums[end] >= nums[start])
                return binarySearch(nums, start, end, target);

            int middle = start + (end - start) / 2;
            if (nums[middle] == target) return middle;

            if (nums[middle] < nums[end]) {
                if (target > nums[middle] && target < nums[end])
                    start = middle + 1;
                else
                    end = middle - 1;
            } else {
                if (target > nums[start] && target < nums[middle])
                    end = middle - 1;
                else
                    start = middle + 1;
            }
        }

        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target == nums[middle]) return middle;
            if (target < nums[middle])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }
}
