package string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2575. 找出字符串的可整除数组(中等)
 * 【描述】
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：word = "998244353", m = 3
 * 输出：[1,1,0,0,0,1,1,0,0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 示例 2：
 * 输入：word = "1010", m = 10
 * 输出：[0,1,0,1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * <p>
 * 【 提示】
 * 1）1 <= n <= 105
 * 2）word.length == n
 * 3）word 由数字 0 到 9 组成
 * 4）1 <= m <= 109
 **/
public class DivisibilityArray {

    public static void main(String[] args) {
        //String word = "998244353";
        //String word = "4868438856666666";
        //String word = "1010";
        String word = "100000000010000000003019999999961000000000";
        int m = 1000000000;
        int[] result = new DivisibilityArray().divisibilityArray(word, m);
        System.out.println("The result is:" + Arrays.toString(result));
    }

    public int[] divisibilityArray(String word, int m) {
        int[] result = new int[word.length()];
        int ch;
        int n;
        int num = 0;

        for (int i = 0; i < word.length(); i++) {
            n = 0;
            ch = word.charAt(i) - '0';
            if (num < (Integer.MAX_VALUE - ch) / 10) {
                num = num * 10 + ch;
                n = num % m;
            } else {
                for (int j = 0; j < 10; j++) {
                    n += num;
                    if (n > m) n -= m;
                }
                n += ch;
            }

            if (n == 0) {
                result[i] = 1;
            }
            num = n;
        }
        return result;
    }

}
