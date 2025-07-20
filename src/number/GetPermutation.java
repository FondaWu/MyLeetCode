package number;

/**
 * 60. 排列序列（困难）
 * 【描述】
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 【示例】
 * 示例 1：
 * 输入：n = 3, k = 3
 * 输出："213"
 * 示例 2：
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 示例 3：
 * 输入：n = 3, k = 1
 * 输出："123"
 *
 * 【提示】
 * 1）1 <= n <= 9
 * 2）1 <= k <= n!
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GetPermutation {

    public static void main(String[] args) {
        //int n = 4, k = 9;
        int n = 5, k = 60;
        System.out.println("计算结果：" + new GetPermutation().getPermutation(n, k));
        //int[] nums = {3, 2, 4, 1};
        //new GetPermutation().nextPermutation(nums);
        //System.out.println("计算结果：" + Arrays.toString(nums));
    }

    public String getPermutation(int n, int k) {
        // 生成1到n的数组
        int[] nums = IntStream.range(1, n + 1).toArray();
        // 运行K次获取下一个数字排列组合
        for (int i = 0; i < k - 1; i++) {
            nextPermutation(nums);
        }
        // 最后将生成的整数数组结果转换成字符串
        return Arrays.stream(nums).mapToObj(String::valueOf).reduce((a, b) -> a + b).get();
    }

    private void nextPermutation(int[] nums) {
        int tmp;
        int i = nums.length - 2, j;
        Lable:
        for (; i >= 0; i--) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break Lable;
                }
            }
        }
        int len = nums.length - i -1;
        for (j = 0; j < len / 2; j++) {
            tmp = nums[i + 1 + j];
            nums[i + 1 + j] = nums[len - j + i];
            nums[len - j + i] = tmp;
        }
    }

    private void nextPermutation1(int[] nums) {
        System.out.println(Arrays.toString(nums));
        // 从倒数第二个数开始，尝试能够递增替换此数字，依次向前推进
        int tmp;
        int i = nums.length - 2;
        Lable:
        for (; i >= 0; i--) {
            // 往后找比当前数大的数，将两个数交换，然后跳出整个循环
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break Lable;
                }
            }
        }
        // 后面的数字，从小到大排序即可
        Arrays.sort(nums, i + 1, nums.length);
    }

    public String getPermutation1(int n, int k) {
        // 生成1到n的数组
        int[] nums = IntStream.range(1, n + 1).toArray();
        // 定义一个整型列表,存储最后生成的排列序列
        List<Integer> numlist = new ArrayList<>();
        // 定义一个布尔数组，存储所对应的数据是否被访问
        boolean[] mark = new boolean[nums.length];
        // 递归回溯从小到大生成所有数据
        selectNext(numlist, nums, 0, mark, 0, k);
        // 最后将生成的整数数组结果转换成字符串
        return numlist.stream().map(String::valueOf).reduce((a, b) -> a + b).get();
    }

    /**
     * @param numlist 整型列表,存储最后生成的排列序列
     * @param nums    从1到n的数据
     * @param n       当前选取第几个数字
     * @param mark    当前选取第几个数
     * @param m       当前生成的序列号
     * @param k       要求返回的序列号
     **/
    private int selectNext(List<Integer> numlist, int[] nums, int n, boolean[] mark, int m, int k) {
        // 已经访问到数字集合尾部，当前排列完成生成， 序列号加1并返回
        if (n == nums.length) {
            return m + 1;
        }
        // 从小到大依次访问数字集合数据
        for (int i = 0; i < nums.length; i++) {
            // 如果数字没有被使用
            if (!mark[i]) {
                // 将当前数字添加到结果列表中
                numlist.add(nums[i]);
                // 标记当前数字已经使用
                mark[i] = true;
                // 递归选择下一个数据
                m = selectNext(numlist, nums, n + 1, mark, m, k);
                // 如果生成的序号等于要求返回的序列号，跳出循环
                if (m == k) break;
                // 否则回溯删除当前数字
                numlist.remove(n);
                // 标记当前数字未被使用
                mark[i] = false;
            }
        }
        // 返回生成的序列号
        return m;
    }

}
