package array;


import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 99};
        int result = singleNumber(nums);
        System.out.println("The single number:" + result);
    }

    private static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int n = 0;
            for (int j = 0; j < nums.length; j++) {
                n += (nums[j] >> i) & 1;
            }
            ans |= (n % 3) << i;
        }
        return ans;
    }

    private static int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

}
