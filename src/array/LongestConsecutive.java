package array;

import common.Utils;

import java.util.Arrays;

/*
128. 最长连续序列(中等)
【描述】
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
【描述】
示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
【提示】
1）0 <= nums.length <= 105
2) -109 <= nums[i] <= 109
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int nums[] = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        int result = longestConsecutive(nums);
        System.out.println("计算结果：" + result);
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int longest = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] < 2) {
                if (nums[i] - nums[i - 1] == 1) count++;
            } else {
                if (count > longest) longest = count;
                count = 1;
            }
        }
        if (count > longest) longest = count;
        return longest;
    }

    public static int longestConsecutive1(int[] nums) {
        final byte mark[] = new byte[25000000];
        int i, j, k;
        for (i = 0; i < nums.length; i++) {
            j = (100000000 + nums[i]) >> 3;
            k = (100000000 + nums[i]) % 8;
            mark[j] = Utils.setBit(mark[j], k);
        }

        int start = -1, longest = 0;
        for (i = 0; i < 200000000; i++) {
            j = (i) >> 3;
            k = (i) % 8;

            if (Utils.getBit(mark[j], k) == 1) {
                if (start < 0) start = i;
            } else if (start != -1) {
                if (i - start > longest) longest = i - start;
                start = -1;
            }
        }
        return longest;
    }
}
