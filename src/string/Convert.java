package string;

/**
 * 6. Z 字形变换（中等）
 * 【描述】
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 【提示】
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */

public class Convert {


    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = new Convert().convert(s, numRows);
        System.out.println("计算结果:" + result);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder[] sbArray = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbArray[i] = new StringBuilder();
        }
        boolean down = true;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sbArray[index].append(s.charAt(i));
            index = down ? index + 1 : index - 1;
            if (index == numRows) {
                index = numRows - 2;
                down = false;
            }
            if (index == -1) {
                index = 1;
                down = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(sbArray[i]);
        }
        return sb.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1)
            return s;

        String[] strs = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = "";
        }

        boolean down = true;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            strs[index] += s.charAt(i);
            index = down ? index + 1 : index - 1;
            if (index == numRows) {
                index = numRows - 2;
                down = false;
            }
            if (index == -1) {
                index = 1;
                down = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
