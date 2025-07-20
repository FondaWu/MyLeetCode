package array;

import java.util.Arrays;

/**
 * 75. 颜色分类（中等）
 * 【描述】
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 【提示】
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class SortColors {

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        new SortColors().sortColors(arr);
        System.out.println("计算结果：" + Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        Arrays.fill(nums, 0, counts[0], 0);
        Arrays.fill(nums, counts[0], counts[0] + counts[1], 1);
        Arrays.fill(nums, counts[0] + counts[1], counts[0] + counts[1] + counts[2], 2);
    }
}
