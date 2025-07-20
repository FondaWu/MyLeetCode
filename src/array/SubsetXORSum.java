package array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SubsetXORSum {

    public static void main(String[] args) {
        int[] nums = {5, 1, 6};
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        int result = new SubsetXORSum().subsetXORSum(nums);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("计算结果：" + result);
    }


    public int subsetXORSum(int[] nums) {
        List<int[]> subarrays = generateSubArrays(nums);
        int result = 0;
        for (int[] subarray : subarrays) {
            result += getXORSum(subarray);
        }
        return result;
    }

    public List<int[]> generateSubArrays(int[] arr) {
        List<int[]> subArrays = new ArrayList<>();
        int n = arr.length;
        // 2^n 种组合
        int totalCombinations = 1 << n;

        for (int i = 0; i < totalCombinations; i++) {
            List<Integer> currentSubArray = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentSubArray.add(arr[j]);
                }
            }
            // 将 List 转为数组
            int[] subArray = currentSubArray.stream().mapToInt(Integer::intValue).toArray();
            subArrays.add(subArray);
        }
        return subArrays;
    }

    public int getXORSum(int[] subarray ) {
        if (subarray.length == 1) return subarray[0];

        int result = 0;
        for (int i : subarray) {
            result ^= i;
        }

        return result;
    }

}
