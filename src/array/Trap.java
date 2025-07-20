package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水（困难）
 * 【描述】
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 【提示】
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class Trap {
    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = new Trap().trap(height);
        System.out.println("最大面积:" + result);
    }

    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        for (int i = 1; i < len; i++) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int p1 = deque.pop();
                if (!deque.isEmpty()) {
                    int p2 = deque.peek();
                    // 高取两边最小的一个
                    int h = Math.min(height[p2], height[i]) - height[p1];
                    int w = i - p2 - 1;
                    int area = h * w;
                    sum +=area;
                }
            }
            deque.push(i);
        }
        return sum;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];

        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i] - height[i]);

        return res;
    }

    public int trap1(int[] height) {
        int left = 0, right = height.length - 1;
        int lmax = 0, rmax = 0;
        int res = 0;

        while (left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if (lmax < rmax) {
                res += lmax - height[left];
                left++;
            } else {
                res += rmax - height[right];
                right--;
            }
        }
        return res;
    }

}
