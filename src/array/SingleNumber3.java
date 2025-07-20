package array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber3 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        int[] result = singleNumber(nums);
        int result2 = singleNumber2(nums);
        System.out.println("The single number:" + Arrays.toString(result));
    }

    private static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    private static int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) ans[i++] = entry.getKey();
        }
        return ans;
    }

}
