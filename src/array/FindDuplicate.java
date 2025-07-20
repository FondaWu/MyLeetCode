package array;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 4, 2};
        int result = findDuplicate(nums);
        System.out.println("计算结果:" + result);
    }

    public static int findDuplicate(int[] nums) {
        byte[] digits = new byte[100000];

        for (int i = 0; i < nums.length; i++) {
            digits[nums[i] - 1]++;
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 1)
                return i + 1;
        }
        return -1;
    }

}
