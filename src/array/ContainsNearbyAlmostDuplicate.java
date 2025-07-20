package array;

import common.Utils;

public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        int nums[] = {1, 5, 9, 2, 6, 10};
        //int[] nums = Utils.readArrayFromFile("res\\220\\48.txt");
        int indexDiff = 2;
        int valueDiff = 3;
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (++indexDiff > nums.length) indexDiff = nums.length;
        int[] data = new int[indexDiff];

        int i, j = 1, k;
        int len;

        for (i = 0; i < indexDiff; i++) {
            data[i] = nums[i];
        }
        for (i = 1; i < nums.length; i++) {
            data[j] = nums[i];
            len = i < indexDiff ? i : indexDiff;
            for (k = 0; k < len; k++) {
                if (k == j) continue;
                if (Math.abs(data[j] - data[k]) <= valueDiff)
                    return true;

            }
            j = (j + 1) % indexDiff;

        }
        return false;
    }
}
