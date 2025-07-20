package hash;

import string.ConvertDateToBinary;

import java.util.HashMap;

/**
 * 169. 多数元素（简单）
 * 【描述】
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 【提示】
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class MajorityElement {

    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        //int nums[] = {6, 5, 5};
        int result = new MajorityElement().majorityElement(nums);
        System.out.println("The result is:" + result);
    }

    public int majorityElement(int[] nums) {
        int maxValue = nums[0];
        int maxNum = 1;
        for (int i = 1; i < nums.length; i++) {
           if (maxValue == nums[i]){
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

    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int maxValue = 0;
        int maxNum = 0;
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            if (count > maxValue) {
                maxValue = count;
                maxNum = num;
            }
        }
        return maxNum;
    }
}
