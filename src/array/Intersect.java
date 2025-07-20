package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intersect {

    public static void main(String[] args) {
        int nums1[] = {1, 2, 2, 2, 1}, nums2[] = {2, 2, 2};
        int[] nums = intersect(nums1, nums2);
        System.out.println("计算结果：" + Arrays.toString(nums));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        int[] nums = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j])
                j++;
            else if (nums1[i] < nums2[j]) i++;
            else {
                nums[k++] = nums1[i];
                i++; j++;
            }
        }
        return Arrays.copyOfRange(nums, 0, k);
    }

    private static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1){
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int [] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2){
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    private static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> numList = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j])
                j++;
            else if (nums1[i] < nums2[j]) i++;
            else {
                numList.add(nums1[i]);
                i++; j++;
            }
        }
        return numList.stream().mapToInt(Integer::intValue).toArray();
    }

}
