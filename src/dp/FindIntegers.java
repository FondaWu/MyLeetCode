package dp;


/**
 * 600. 不含连续1的非负整数（困难）
 * 【描述】
 * 相关标签
 * 相关企业
 * 给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。
 * <p>
 * 【示例】
 * 示例 1:
 * 输入: n = 5
 * 输出: 5
 * 解释:
 * 下面列出范围在 [0, 5] 的非负整数与其对应的二进制表示：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数 3 违反规则（有两个连续的 1 ），其他 5 个满足规则。
 * 示例 2:
 * 输入: n = 1
 * 输出: 2
 * 示例 3:
 * 输入: n = 2
 * 输出: 3
 * <p>
 * <p>
 * 【提示】
 * 1 <= n <= 109
 */
public class FindIntegers {

    public static void main(String[] args) {
        int n = 1000000000;
        long start = System.currentTimeMillis();
        int result = new FindIntegers().findIntegers(n);
        System.out.println("算法执行时间:" + (System.currentTimeMillis() - start) + "MS");
        System.out.println("计算结果：" + result);
    }


    public int findIntegers(int n) {
        int dp[][] = new int[32][2];
        dp[0][0] = 1;
        dp[0][1] = 2;
        for (int i = 0; i < 32; i++) {
        }

        return 0;
    }

    public int findIntegers1(int n) {
        int digits[] = new int[31];

        for (int i = 0; i < 31; i++) {
            digits[i] = 1 << i | 1 << i + 1;
        }

        int result = 1;
        int max = 31;
        for (int i = n; i > 0; i--) {
            boolean suitable = true;
            for (int j = 0; j < max; j++) {
                if ((i & digits[j]) == digits[j]){
                    suitable = false;
                    break;
                }
                if (i < digits[j]){
                    max = j;
                    break;
                }
            }
            if (suitable == true) {
                result++;
            }
        }
        return result;
    }
}
