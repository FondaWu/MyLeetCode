package array;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
315. 计算右侧小于当前元素的个数（困难）
【描述】
给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
示例 1：
输入：nums = [5,2,6,1]
输出：[2,1,1,0]
解释：
5 的右侧有 2 个更小的元素 (2 和 1)
2 的右侧仅有 1 个更小的元素 (1)
6 的右侧有 1 个更小的元素 (1)
1 的右侧有 0 个更小的元素
示例 2：
输入：nums = [-1]
输出：[0]
示例 3：
输入：nums = [-1,-1]
输出：[0,0]
【提示】
1）1 <= nums.length <= 105
2）-104 <= nums[i] <= 104
 */
public class CountSmaller {

    public static void main(String[] args) {
        //int nums[] = {5, 2, 6, 1};
        int[] nums = Utils.readArrayFromFile("res\\315\\62.txt");
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        List<Integer> result = new CountSmaller().countSmaller(nums);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("The result is:" + Arrays.toString(result.toArray()));
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        return result;
    }

    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count;
        for (int i = 0; i < nums.length - 1; i++) {
            count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
            result.add(count);
        }
        result.add(0);
        return result;
    }
}
