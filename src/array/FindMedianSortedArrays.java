package array;

import java.util.Arrays;

/**
 * @author: FondaWu
 * @create: 2022-01-29 17:23
 * @description: ${description}
 **/

/*
4. 寻找两个正序数组的中位数(困难)
【描述】
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。

【示例】
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2

示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

【提示】
1) nums1.length == m
2) nums2.length == n
3) 0 <= m <= 1000
4) 0 <= n <= 1000
5) 1 <= m + n <= 2000
6) -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int nums1[] = {1};
        int nums2[] = {2, 3, 8, 9, 10, 11};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 采用归并比较算法，因为只需要取中位数，所以新建数组大小nums只需要nums1和nums2一半即可
        int len3 = (len1 + len2) / 2 + 1;
        int[] nums = new int[len3];
        int i1 = 0, i2 = 0, j = 0;

        // 采用归并比较算法，向数组nums按大小依次从nums1和nums2拷贝数据
        // 一直到nums1和nums2其中之一遍历完毕，或者新建数组已经塞满
        while (true) {
            if (i1 >= len1 || i2 >= len2 || j >= len3) break;
            if (nums1[i1] < nums2[i2]) {
                nums[j++] = nums1[i1++];
            } else {
                nums[j++] = nums2[i2++];
            }
        }

        // 如果新建数组还未塞满，则从未遍历完的数组中直接拷贝数据把新建数组塞满
        if (j < len3) {
            if (i1 < len1) System.arraycopy(nums1, i1, nums, j, len3 - j);
            if (i2 < len2) System.arraycopy(nums2, i2, nums, j, len3 - j);
        }
        // nums1和nums2之和为偶数，则返回中间两数之和的平均数
        if (((len1 + len2)) % 2 == 0)
            return (nums[len3 - 2] + nums[len3 - 1]) / 2.0;
            // nums1和nums2之和为奇数，则直接返回中间数
        else
            return nums[len3 - 1];
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1 + len2;
        int[] nums = new int[len1 + len2];
        int i1 = 0, i2 = 0, j = 0;
        while (true) {
            if (i1 >= len1 || i2 >= len2) break;
            if (nums1[i1] < nums2[i2]) {
                nums[j++] = nums1[i1++];
            } else {
                nums[j++] = nums2[i2++];
            }
        }
        if (i1 < len1) System.arraycopy(nums1, i1, nums, j, len1 - i1);
        if (i2 < len2) System.arraycopy(nums2, i2, nums, j, len2 - i2);

        System.out.println(Arrays.toString(nums));

        int n = len3 >> 1;
        if (len3 % 2 == 0) return (nums[n - 1] + nums[n]) / 2.0;
        else return nums[n];
    }


}
