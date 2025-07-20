package array;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int[] result = searchRange(nums, 2);
        System.out.println("搜索插入位置:" + result[0] + ", " + result[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int[] result = new int[]{-1, -1};
        while (left <= right) {
            mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                left = mid;
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                result[0] = left;
                right = mid;
                while (right < nums.length - 1 && nums[right+1] == target) {
                    right++;
                }

                result[1] = right;

                return result;
            }
        }
        return result;
    }
}
