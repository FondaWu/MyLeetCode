package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 115. 不同的子序列（困难）
 * 【提示】
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * <p>
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * <p>
 * 【提示】
 * 1）1 <= s.length, t.length <= 1000
 * 2）s 和 t 由英文字母组成
 **/
public class NumDistinct {
    private Map<String, Integer> intResultCache = new HashMap<>();
    private int count = 0;

    private static final int NUM = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        //String s = "rabbbit", t = "rabbit";
        //String s = "babgbag", t = "bag";
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
                t = "bcddceeeebecbc";
        long start = System.currentTimeMillis();
        int result = new NumDistinct().numDistinct(s, t);
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
        System.out.println("result = " + result);
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];

    }

    public int numDistinct1(String s, String t) {
        return match(s, 0, t, 0, t.charAt(0));
    }


    private int match(String s, int idx1, String t, int idx2, char ch) {
        if (idx2 == t.length()) {
            ++count;
            intResultCache.put(String.valueOf(idx1) + '-' + idx2, count);
            return count;
        } else if (idx1 == s.length()) {
            return count;
        }
        if (ch == 0) ch = t.charAt(idx2);
        int i = s.indexOf(ch, idx1);
        if (i != -1) {
            intResultCache.getOrDefault(String.valueOf(i + 1) + '-' + idx2, match(s, i + 1, t, idx2, ch));
            intResultCache.getOrDefault(String.valueOf(i + 1) + '-' + idx2 + 1, match(s, i + 1, t, idx2 + 1, (char) 0));
        }
        return count;
    }

    private int match1(String s, int idx1, String t, int idx2) {
        if (idx2 == t.length()) {
            return 1;
        } else if (idx1 == s.length()) {
            return 0;
        }
        char ch = t.charAt(idx2);
        int i = s.indexOf(ch, idx1);
        if (i != -1) {
            return match1(s, i + 1, t, idx2) + match1(s, i + 1, t, idx2 + 1);
        }
        return 0;
    }

}
