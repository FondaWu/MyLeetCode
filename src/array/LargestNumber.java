package array;

/*
179. 最大数(中等)
【描述】
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
【提示】
1）1 <= nums.length <= 100
2）0 <= nums[i] <= 109
 */

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
        //int[] nums = {3, 30, 34, 5, 9};
        int[] nums = {0, 3};
        String result = largestNumber(nums);
        System.out.println("计算结果：" + result);
    }


    private static String largestNumber(int[] nums) {
        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(nums2, (o1, o2) -> {
            List<Integer> list1 = extractEachDigit(o1);
            List<Integer> list2 = extractEachDigit(o2);
            int n1 = list1.size();
            int n2 = list2.size();
            for (int i = 0; i < Math.min(n1, n2); i++) {
                if (list1.get(i) < list2.get(i)) return 1;
                if (list1.get(i) > list2.get(i)) return -1;
            }
            return (o2 + o1.toString()).compareTo(o1 + o2.toString());
        });

        if (nums2[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int n : nums2) {
            sb.append(n);
        }

        return sb.toString();
    }

    private static List<Integer> extractEachDigit(int n) {
        List<Integer> list = new ArrayList<>();
        int m;
        while (n > 0) {
            m = n / 10;
            list.add(n - m * 10);
            n = m;
        }
        Collections.reverse(list);
        return list;
    }
}
