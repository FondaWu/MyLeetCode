package dp;

/*
91. 解码方法（中等）
【提示】
一条包含字母 A-Z 的消息通过以下映射进行了 解码 ：
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
要 解码 已解码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
题目数据保证答案肯定是一个 32 位 的整数。
【示例】
示例 1：
输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2：
输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
示例 3：
输入：s = "06"
输出：0
解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
【提示】
1）1 <= s.length <= 100
2）s 只包含数字，并且可能包含前导零。
 */
public class NumDecodings {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // String s = "106";
        //String s = "10";
        //String s = "06";
        //String s = "11106";
        String s = "111111111111111111111111111111111111111111111";
        int result = new NumDecodings().numDecodings(s);
        System.out.println("result = " + result);
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    public int numDecodings(String s) {
        // 按照惯例定义一个dp数组
        int[] dp = new int[s.length()];
        char ch1 = s.charAt(0);
        // 设置dp[0]值，如果第一个字符为合法解码，那么设置为1，否则为0
        dp[0] = ch1 > 48 ? 1 : 0;
        // 依次遍历后续字符
        for (int i = 1; i < dp.length; i++) {
            char ch2 = s.charAt(i);
            // 计算当前字符和上一个字符组合解码值:等于((ch1-48)*10+ch2-48)，即(ch1*10 +ch2-528)
            char num = (char) (ch1 * 10 + ch2 - 528);
            // 如果当前字符是合法解码，那么当前字符可以作为一个单独解码加入上一个字符的解码分组里，在这种情况下，解码数就等于上一字符解码数
            if (ch2 > 48) {
                dp[i] = dp[i - 1];
            }
            // 如果上一个字符是合法解码，并且当前字符和上一个字符之和也是合法解码
            if (ch1 > 48 && num < 27) {
                // 如果i值大于1，那么当前字符和上一个字符组合解码加入上上个字符的解码分组里，在这种情况下，解码数要加上于上上个字符解码数
                if (i > 1) {
                    dp[i] += dp[i - 2];
                } else { // 如果i值等于2，那么就多一个当前字符和上一个字符组合解码
                    dp[i] += 1;
                }
            }
            // 更新ch1为ch2值
            ch1 = ch2;
        }
        return dp[s.length() - 1];
    }

    // 递归实现方式，速度慢
    public int numDecodings1(String s) {
        return numDecodings1(s, 0);
    }

    private int numDecodings1(String s, int n) {
        if (n == s.length()) {
            return 1;
        }
        int result = 0;
        char ch1 = s.charAt(n);
        // 当前字符是合法解码，那么将当前字符作为一个解码和之后所有字符放在一个分组
        if (ch1 > 48) {
            // 当前解码数等于之后所有字符解码
            result = numDecodings1(s, n + 1);
            if (n < s.length() - 1) {
                // 计算当前字符和下一个字符组合解码值:等于((ch1-48)*10+ch2-48)，即(ch1*10 +ch2-528)
                char ch2 = (char) (ch1 * 10 + s.charAt(n + 1) - 528);
                // 如果当前字符和下个字符之和也是合法解码，那么解码数再加上去掉这两个字符之后所有字符解码
                if (ch2 < 27) {
                    result += numDecodings1(s, n + 2);
                }
            }
        }
        return result;
    }
}
