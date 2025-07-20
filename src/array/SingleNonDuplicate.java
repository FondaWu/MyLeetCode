package array;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int result = new SingleNonDuplicate().singleNonDuplicate(nums);
        System.out.println("The single number:" + result);
    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }

        return result;
    }
}
