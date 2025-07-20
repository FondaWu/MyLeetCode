package string;

/**
 * 848. 字母移位（中等）
 * 【描述】
 * 有一个由小写字母组成的字符串 s，和一个长度相同的整数数组 shifts。
 * 我们将字母表中的下一个字母称为原字母的 移位 shift() （由于字母表是环绕的， 'z' 将会变成 'a'）。
 * 例如，shift('a') = 'b', shift('t') = 'u', 以及 shift('z') = 'a'。
 * 对于每个 shifts[i] = x ， 我们会将 s 中的前 i + 1 个字母移位 x 次。
 * 返回 将所有这些移位都应用到 s 后最终得到的字符串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", shifts = [3,5,9]
 * 输出："rpl"
 * 解释：
 * 我们以 "abc" 开始。
 * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
 * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
 * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
 * 示例 2:
 * 输入: s = "aaa", shifts = [1,2,3]
 * 输出: "gfd"
 * <p>
 * <p>
 * 提示:
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * shifts.length == s.length
 * 0 <= shifts[i] <= 109
 */
public class ShiftingLetters {

    public static void main(String[] args) {
        String s = "mkgfzkkuxownxvfvxasy";
        int shifts[] = new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513};
        String result = new ShiftingLetters().shiftingLetters(s, shifts);
        System.out.println("计算结果：" + result);
    }

    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1] % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shifts.length; i++) {
            char c = (char) ('a' + (s.charAt(i) - 'a' + shifts[i]) % 26);
            sb.append(c);
        }
        return sb.toString();
    }
}
