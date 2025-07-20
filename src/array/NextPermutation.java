package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
31. 下一个排列(中等)
整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。
必须 原地 修改，只允许使用额外常数空间。
提示：
1) 1 <= nums.length <= 100
2) 0 <= nums[i] <= 100
 */

public class NextPermutation {
    private static boolean bfind;

    public static void main(String[] args) {
        //int[] nums = new int[]{6, 7, 5, 3, 5, 6, 2, 9, 1, 2, 7, 0, 9};
        //int[] nums = new int[]{1, 3, 2};
        //int[] nums = new int[]{2, 3, 1};
        int[] nums = new int[]{4, 2, 0, 2, 3, 2, 0};
        System.out.println("输入数据:" + Arrays.toString(nums));
        long start = System.currentTimeMillis();
        nextPermutation(nums);
        System.out.println("算法运行时间:" + (System.currentTimeMillis() - start) + "MS");
        System.out.println("运算结果:" + Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        int tmp;
        int i = nums.length - 2, j;
        Lable:
        for (; i >= 0; i--) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break Lable;
                }
            }
        }
        // 去掉之前的快排代码
        // Arrays.sort(nums, i + 1, nums.length);
        // 获取需要逆序的数组长度
        int len = nums.length - i - 1;
        // 对所有逆序的数字进行对称交换处理
        for (j = 0; j < len / 2; j++) {
            tmp = nums[i + 1 + j];
            nums[i + 1 + j] = nums[len - j + i];
            nums[len - j + i] = tmp;
        }
    }

    private static void nextPermutation2(int[] nums) {
        int tmp;
        int i = nums.length - 2, j;
        Lable:
        for (; i >= 0; i--) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break Lable;
                }
            }
        }
        Arrays.sort(nums, i + 1, nums.length);
    }

    private static void nextPermutation1(int[] nums) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);

        List<Integer> numlist = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        Arrays.sort(nums2);
        boolean find = selectNext(numlist, nums2, nums, 0, mark);
        if (find) {
            for (int i = 0; i < numlist.size(); i++) {
                nums[i] = numlist.get(i);
            }
        } else {
            Arrays.sort(nums);
        }
    }

    private static boolean selectNext(List<Integer> numlist, int[] nums, int[] nums2, int n, boolean[] mark) {
        if (n == nums.length) {
            if (bfind) return true;
            boolean match = true;
            for (int i = 0; i < numlist.size(); i++) {
                if (nums2[i] != numlist.get(i)) {
                    match = false;
                    break;
                }
            }
            bfind = match;
        } else {
            boolean result;
            for (int i = 0; i < nums.length; i++) {
                if (mark[i] || i > 0 && nums[i] == nums[i - 1] && !mark[i - 1])
                    continue;

                numlist.add(nums[i]);
                mark[i] = true;
                result = selectNext(numlist, nums, nums2, n + 1, mark);
                if (result)
                    return result;
                numlist.remove(n);
                mark[i] = false;
            }
        }
        return false;
    }


}
