package array;

import common.Utils;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        //int[] nums = Utils.readArrayFromFile("res\\912\\15.txt");
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        int result[] = new SortArray().sortArray(nums);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("The result:" + Arrays.toString(result));
    }

    public int[] sortArray(int[] nums) {
        int[] tmp = new int[nums.length];
        merge_sort(nums, 0, nums.length - 1, tmp);
        return tmp;
    }

    private static void merge_sort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid, tmp);
            merge_sort(arr, mid + 1, right, tmp);
            merge(arr, left, mid, right, tmp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        while (j <= right) {
            tmp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = tmp[t++];
        }
    }
}
