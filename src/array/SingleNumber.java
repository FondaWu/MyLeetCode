package array;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int result = singleNumber(nums);
        System.out.println("The single number:" + result);
    }

    private static int singleNumber(int[] nums) {
        if (nums.length < 1) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
