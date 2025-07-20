package array;

import common.Utils;

/*
268. 丢失的数字(简单)
【描述】
给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
【提示】
1）n == nums.length
2）1 <= n <= 104
3）0 <= nums[i] <= n
4）nums 中的所有数字都 独一无二
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = missingNumber(nums);
        System.out.println("计算结果：" + result);
    }

    private static int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        result ^= nums.length;
        return result;
    }


    private static int missingNumber2(int[] nums) {
        int len = (nums.length + 1) >> 3;
        if ((nums.length + 1) % 8 > 0) len++;

        byte[] count = new byte[len];
        int i;
        for (i = 0; i < nums.length; i++) {
            Utils.setBits(count, nums[i]);
        }
        for (i = 0; i < nums.length + 1; i++) {
            if (Utils.getBits(count, i) == 0) return i;
        }
        return -1;
    }


    private static int missingNumber1(int[] nums) {
        byte[] count = new byte[nums.length + 1];
        int i;
        for (i = 0; i < nums.length; i++) {
            count[nums[i]] = 1;
        }
        for (i = 0; i < count.length; i++) {
            if (count[i] != 1) return i;
        }
        return -1;
    }



}
