package hash;

/**
 * 229. 多数元素 II（中等）
 * 【描述】
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * <p>
 * 【提示】
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        int nums[] = {1, 2};
        int result = new MajorityElement2().majorityElement(nums);
        System.out.println("The result is:" + result);
    }

    public int majorityElement(int[] nums) {
        int maxValue = nums[0];
        int maxNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (maxValue == nums[i]) {
                maxNum++;
            } else {
                maxNum--;
                if (maxNum == 0) {
                    maxNum = 1;
                    maxValue = nums[i];
                }
            }
        }
        return maxValue;
    }
}
