package array;

/**
 * 2717. 半有序排列（简单）
 * 【描述】
 * 给你一个下标从 0 开始、长度为 n 的整数排列 nums 。
 * * 如果排列的第一个数字等于 1 且最后一个数字等于 n ，则称其为 半有序排列 。你可以执行多次下述操作，直到将 nums 变成一个 半有序排列 ：
 * * 选择 nums 中相邻的两个元素，然后交换它们。
 * 返回使 nums 变成 半有序排列 所需的最小操作次数。
 * * 排列 是一个长度为 n 的整数序列，其中包含从 1 到 n 的每个数字恰好一次。
 * <p>
 * 【示例】
 * * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3]
 * 输出：2
 * 解释：可以依次执行下述操作得到半有序排列：
 * 1 - 交换下标 0 和下标 1 对应元素。排列变为 [1,2,4,3] 。
 * 2 - 交换下标 2 和下标 3 对应元素。排列变为 [1,2,3,4] 。
 * 可以证明，要让 nums 成为半有序排列，不存在执行操作少于 2 次的方案。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,1,3]
 * 输出：3
 * 解释：
 * 可以依次执行下述操作得到半有序排列：
 * 1 - 交换下标 1 和下标 2 对应元素。排列变为 [2,1,4,3] 。
 * 2 - 交换下标 0 和下标 1 对应元素。排列变为 [1,2,4,3] 。
 * 3 - 交换下标 2 和下标 3 对应元素。排列变为 [1,2,3,4] 。
 * 可以证明，要让 nums 成为半有序排列，不存在执行操作少于 3 次的方案。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,4,2,5]
 * 输出：0
 * 解释：这个排列已经是一个半有序排列，无需执行任何操作。
 * <p>
 * <p>
 * 【提示】
 * 2 <= nums.length == n <= 50
 * 1 <= nums[i] <= 50
 * nums 是一个 排列
 */
public class SemiOrderedPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 3};
        int result = new SemiOrderedPermutation().semiOrderedPermutation(nums);
        System.out.println("The result is:" + result);
    }

    public int semiOrderedPermutation(int[] nums) {
        int x = -1, y = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) x = i;
            if (nums[i] == nums.length) y = i;
            if (x >= 0 && y >= 0)
                break;
        }
        return x  < y ? x + (nums.length - y - 1) : x + (nums.length - y - 2);
    }
}
