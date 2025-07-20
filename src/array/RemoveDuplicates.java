package array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int j = removeDuplicates(nums);
        System.out.println("j = " + j);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }
}
