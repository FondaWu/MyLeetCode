package array;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 2);
        System.out.println("The result is:" + Arrays.toString(nums));

    }

    private static void rotate1(int[] nums, int k) {
        k = k % nums.length;

        int tmp;
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                tmp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    private static void rotate(int[] nums, int k) {
        k = k % nums.length;

        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - k);
        int[] nums2 = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        int i;
        for (i = 0; i < k; i++){
            nums[i] = nums2[i];
        }
        for (; i < nums.length ; i++){
            nums[i] = nums1[i-k];
        }
    }
}
