package hash;


import java.util.Map;
import java.util.HashMap;

/**
 * 1394. 找出数组中的幸运数（简单）
 * 【描述】
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 *
 * 【示例】
 * 示例 1：
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * 示例 2：
 * 输入：arr = [1,2,2,3,3,3]
 * 输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * 示例 3：
 * 输入：arr = [2,2,2,3,3]
 * 输出：-1
 * 解释：数组中不存在幸运数。
 * 示例 4：
 * 输入：arr = [5]
 * 输出：-1
 * 示例 5：
 * 输入：arr = [7,7,7,7,7,7,7]
 * 输出：7
 *
 *
 * 【提示】
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 */
public class FindLucky {

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 3, 3};

        long result = new FindLucky().findLucky(nums);
        System.out.println("The result is:" + result);
    }

    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int d : arr) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        int max = - 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getKey() == entry.getValue() && entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    public int findLucky1(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int d : arr) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        int max = - 1;
        for (Integer key : map.keySet()){
            if (map.get(key) == key && key > max) {
                max = key;
            }
        }
        return max;
    }
}
