package string;

/*
541. 反转字符串 II（简单）
【描述】
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
【示例】
示例 1：
输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：
输入：s = "abcd", k = 2
输出："bacd"

【提示】
1）1 <= s.length <= 104
2）s 仅由小写英文组成
3）1 <= k <= 104
 */

public class ReverseStr {

    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;

        System.out.println("result = " + new ReverseStr().reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean first = true;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (++count == k) {
                if (first)
                    result.append(sb.reverse());
                else
                    result.append(sb);
                first = !first;
                sb.delete(0, sb.length());
                count = 0;
            }
        }
        if (first)
            result.append(sb.reverse());
        else
            result.append(sb);
        return result.toString();
    }
}
