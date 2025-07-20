package list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountPairs {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-6, 2, 5, -2, -7, -1, 3);

        int result = countPairs(nums, -2);
        System.out.println("计算结果：" + result);

    }

    private static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0, m = nums.size() - 1, n = 0;
        boolean find;
        do {
            find = false;
            for (int i = m; i > n; i--) {
                if (nums.get(n) + nums.get(i) < target) {
                    count += i - n;
                    m = i;
                    n++;
                    find = true;
                    break;
                }
            }
        } while (find);
        return count;
    }
}
