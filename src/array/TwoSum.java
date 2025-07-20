package array;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};

        int[] pair = twoSum(nums, 22);

        System.out.println(pair[0] + ":" + pair[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            ret[0] = i;
            int num = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num) {
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }
}
