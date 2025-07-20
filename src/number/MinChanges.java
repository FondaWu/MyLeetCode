package number;

import string.CountAndSay;

/**
 * 3226. 使两个整数相等的位更改次数（简单）
 * <p>
 * 【提示】
 * 给你两个正整数 n 和 k。
 * 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
 * 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入： n = 13, k = 4
 * 输出： 2
 * 解释：
 * 最初，n 和 k 的二进制表示分别为 n = (1101)2 和 k = (0100)2，
 * 我们可以改变 n 的第一位和第四位。结果整数为 n = (0100)2 = k。
 * 示例 2：
 * 输入： n = 21, k = 21
 * 输出： 0
 * 解释：
 * n 和 k 已经相等，因此不需要更改。
 * 示例 3：
 * 输入： n = 14, k = 13
 * 输出： -1
 * 解释：
 * 无法使 n 等于 k。
 * 【提示】
 * 1 <= n, k <= 106
 */
public class MinChanges {

    public static void main(String[] args) {
        //int n = 13, k = 4;
        //int n = 21, k = 21;
        int n = 14, k = 13;
        int result = new MinChanges().minChanges(n, k);
        System.out.println("计算结果:" + result);
    }

    public int minChanges(int n, int k) {
        // 计算n和k异或值m，m中的所有位数中为1的值就是n中为1k中为0，或者n中为0k中为1
        int m = (n ^ k);
        // m&n的结果如果不等于m，那么说明存在n中为0k中为1的情况，n不可能变换成k，直接返回-1
        if ((m & n) != m) return -1;
        // m里面所有位数为1的值都是n中为1k中为0的情况，那么直接计算返回m中位数为1的数值即可
        int count = 0;
        while (m != 0) {
            count++;
            m = m & (m - 1);
        }
        return count;
    }

    public int minChanges1(int n, int k) {
        int count = 0;
        int bit1, bit2;
        for (int i = 0; i < Integer.SIZE; i++) {
            bit1 = (n >> i) & 0x01;
            bit2 = (k >> i) & 0x01;
            if (bit1 == 1 && bit2 == 0) count++;
            if (bit1 == 0 && bit2 == 1) return -1;
        }

        return count;
    }
}
