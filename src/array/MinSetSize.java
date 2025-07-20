package array;

import java.util.*;

/**
 * 1338. 数组大小减半（中等）
 * 【描述】
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * 【示例】
 * 示例 1：
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * 示例 2：
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * <p>
 * 【提示】
 * 1 <= arr.length <= 105
 * arr.length 为偶数
 * 1 <= arr[i] <= 105
 */
public class MinSetSize {

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        int result = new MinSetSize().minSetSize(arr);
        System.out.println("计算结果：" + result);
    }

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        int result = 0,sum = 0;
        for (int i = 0; i < list.size(); i++) {
            result++;
            sum += list.get(i);
            if (sum * 2 >= arr.length)
                break;
        }
        return result;
    }

    public int minSetSize1(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        int result = 0,sum = 0;
        for (int i = 0; i < list.size(); i++) {
            result++;
            sum += list.get(i).getValue();
            if (sum >= arr.length/ 2)
                break;
        }
        return result;
    }
}
