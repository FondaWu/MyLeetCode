package array;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int j = removeDuplicates(nums);
        System.out.println("j = " + j);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int j = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[j] != nums[i] || nums[j] != nums[j-1]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }
}
