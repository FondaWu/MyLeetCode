package string;

/**
 * 2414. 最长的字母序连续子字符串的长度（中等）
 * 【提示】
 * 字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
 * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
 *
 * 【示例】
 * 示例 1：
 * 输入：s = "abacaba"
 * 输出：2
 * 解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
 * "ab" 是最长的字母序连续子字符串。
 *
 * 示例 2：
 * 输入：s = "abcde"
 * 输出：5
 * 解释："abcde" 是最长的字母序连续子字符串。
 *
 * 【提示】
 * 1）1 <= s.length <= 105
 * 2）s 由小写英文字母组成
 */

public class LongestContinuousSubstring {

    public static void main(String[] args) {
        String s = "abcde"; //"abacaba";
        int result = new LongestContinuousSubstring().longestContinuousSubstring(s);
        System.out.println("最长的字母序连续子字符串的长度:" + result);
    }

    public int longestContinuousSubstring(String s) {
        int maxLen = 0, curLen = 1;
        int cur = 1;

        char lastChar = s.charAt(0);
        while (cur < s.length()) {
            char curChar = s.charAt(cur);
            if (curChar - lastChar == 1){
                curLen++;
                if (curLen == 26) return 26;
            } else{
                if (curLen > maxLen) maxLen = curLen;
                curLen = 1;
            }
            lastChar = curChar;
            cur++;
        }
        return curLen > maxLen ? curLen : maxLen;
    }

    public int longestContinuousSubstring1(String s) {
        int maxLen = 0, curLen = 1;
        int cur = 1;

        while (cur < s.length()) {
            if (s.charAt(cur) - s.charAt(cur - 1) == 1){
                curLen++;
                if (curLen == 26) return 26;
            } else{
                if (curLen > maxLen) maxLen = curLen;
                curLen = 1;
            }
            cur++;
        }
        return curLen > maxLen ? curLen : maxLen;
    }

}
