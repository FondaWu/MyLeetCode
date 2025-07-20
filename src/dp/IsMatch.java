package dp;

/**
 * 44. 通配符匹配(困难)
 * 【描述】
 * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 *
 * 【提示】
 * 1）0 <= s.length, p.length <= 2000
 * 2）s 仅由小写英文字母组成
 * 3）p 仅由小写英文字母、'?' 或 '*' 组成
 */
public class IsMatch {
    public static void main(String[] args) {
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", p = "***a******a";
        //String s = "acdcb", p = "a*c?b";
        System.out.println(isMatch2(s, p));
    }

    public static boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化
        dp[0][0] = true;

        // 初始化第一行
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 动态规划遍历
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pc == '?' || sc == pc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    private static Boolean isMatch(String text, String regexp) {
        if (regexp.isEmpty() )
            return text.isEmpty();
        if (regexp.charAt(0) == '*') {
            return matchStar(regexp.substring(1), text.substring(1));
        }
        if (!text.isEmpty() && (regexp.charAt(0) == '?' || regexp.charAt(0) == text.charAt(0))) {
            return isMatch(text.substring(1), regexp.substring(1));
        }
        return false;
    }

    private static Boolean matchStar(String regexp, String text) {
        do {
            if (isMatch(text, regexp)) {
                return true;
            }
            if (text.isEmpty())
                break;
            text = text.substring(1);
        } while (true);
        return true;
    }
}
