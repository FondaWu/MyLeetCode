package array;

public class FindLengthOfLCIS {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println("开始计算。。。");
        int result = new FindLengthOfLCIS().findLengthOfLCIS(nums);
        System.out.println("计算结果：" + result);
    }

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (++count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }

        return max;
    }

}
