package array;

/*
41. 缺失的第一个正数（困难）
【描述】
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
【示例】
示例 1：
输入：nums = [1,2,0]
输出：3
解释：范围 [1,2] 中的数字都在数组中。
示例 2：
输入：nums = [3,4,-1,1]
输出：2
解释：1 在数组中，但 2 没有。
示例 3：
输入：nums = [7,8,9,11,12]
输出：1
解释：最小的正数 1 没有出现。
【提示】
1）1 <= nums.length <= 105
2）-231 <= nums[i] <= 231 - 1
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        //int[] nums = new int[]{3,-1,23,7,21,12,8,9,18,21,-1,16,1,13,-3,22,23,13,7,14,3,6,4,-3};
        int[] nums = new int[]{1, 2, 0};
        int result = firstMissingPositive(nums);
        System.out.println("缺失的第一个正数:" + result);
    }

    private static int firstMissingPositive(int[] nums) {
        int[] data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) continue;
            data[nums[i]-1] = 1;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 1) return i + 1;

        }
        return data.length + 1;
    }

    private static int firstMissingPositive2(int[] nums) {
        final int maxValue = 500000;
        final int len = 62500;
        byte[] bytes = new byte[len];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > maxValue) continue;
            int n = nums[i] - 1;
            int j = n >> 3;
            int k = n % 8;
            bytes[j] |= 0x01 << k;
        }
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (((bytes[i] >> j) & 0x01) == 0) {
                    return (i << 3) + j + 1;
                }
            }
        }
        return 0;
    }


    private static int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        // 众神归位
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n) {
                int pos = nums[i] - 1;
                // 交换 i 和 pos
                if (nums[i] == nums[pos]) break; // 已经在对应位置
                int t = nums[i];
                nums[i] = nums[pos];
                nums[pos] = t;
            }
        }
        // 找第一个
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private static int firstMissingPositive4(int[] nums) {
        int m, n;
        for (int i = 0; i < nums.length; i++) {
            m = nums[i];
            if (m < 0 || m >= nums.length || m == i) continue;

            nums[m] = m + 1;


        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;

        }
        return nums.length + 1;
    }
}
