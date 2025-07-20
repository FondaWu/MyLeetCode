package array;

public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int result = searchInsert(nums, 7);
        System.out.println("搜索插入位置:" + result);
    }

    private static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else return mid;
        }
        return left;
    }
}
