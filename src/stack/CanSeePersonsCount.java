package stack;

import common.Utils;

import java.util.Arrays;
import java.util.Stack;

/*
1944. 队列中可以看到的人数（困难）
【描述】
有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且
min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。

【示例 】
输入：heights = [10,6,8,5,11,9]
输出：[3,1,2,1,1,0]
解释：
第 0 个人能看到编号为 1 ，2 和 4 的人。
第 1 个人能看到编号为 2 的人。
第 2 个人能看到编号为 3 和 4 的人。
第 3 个人能看到编号为 4 的人。
第 4 个人能看到编号为 5 的人。
第 5 个人谁也看不到因为他右边没人。
示例 2：
输入：heights = [5,1,2,3,10]
输出：[4,1,1,1,0]

【提示】
1）n == heights.length
2）1 <= n <= 105
3）1 <= heights[i] <= 105
4）heights 中所有数 互不相同 。
 */
public class CanSeePersonsCount {

    public static void main(String[] args) {
        //int heights[] = {10, 6, 8, 5, 11, 9};
        //int heights[] = {5, 1, 2, 3, 10};
        int[] heights = Utils.readArrayFromFile("res\\1944\\40.txt");

        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        int[] result = new CanSeePersonsCount().canSeePersonsCount(heights);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("计算结果:" + Arrays.toString(result));
    }

    public int[] canSeePersonsCount(int[] heights) {
        // 定义一个数组，记录所有位置能看到的人数
        int[] result = new int[heights.length];
        // 定义一个堆栈，记录当前位置身高以及右边一个比一个高的身高
        Stack<Integer> stack = new Stack<>();
        // 将最右侧人身高压栈,最右侧的人看到的人数为0
        stack.push(heights[heights.length - 1]);
        // 从最右边第二个位置开始，依次计算能看到的人数
        for (int i = heights.length - 2; i >= 0; i--) {
            // 当前位置至少能看到右侧紧挨着的这个人，
            result[i] = 1;
            // 从栈中弹出所有比当前位置身高矮的人，这些都是当前位置能看到的人
            while (heights[i] > stack.peek()) {
                stack.pop();
                if (stack.empty()) break;
                result[i]++;
            }
            // 再将当前位置身高压栈，栈里此时状况是一山还比一山高
            stack.push(heights[i]);
        }
        return result;
    }

    public int[] canSeePersonsCount1(int[] heights) {
        // 定义一个数组，记录所有位置能看到的人数
        int[] result = new int[heights.length];
        int max, j;
        for (int i = 0; i < heights.length - 1; i++) {
            // 从当前位置右边第一个位置开始计算
            j = i + 1;
            // 定义当前位置右边遍历的最大身高
            max = 0;
            // 向后依次轮询，直到数值大于当前值的位置为止
            do {
                // 如果当前位置身高大于当前最大身高，那么计数加1，并更新当前最大身高
                if (heights[j] > max) {
                    result[i]++;
                    max = heights[j];
                }
            } while (heights[j] < heights[i] && ++j < heights.length);
        }
        return result;
    }
}
