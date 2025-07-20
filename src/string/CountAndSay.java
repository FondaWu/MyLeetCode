package string;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 38. 外观数列（中等）
 * 【提示】
 * 「外观数列」是一个数位字符串序列，由递归公式定义：
 * countAndSay(1) = "1"
 * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 * 行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
 * 给定一个整数 n ，返回 外观数列 的第 n 个元素。
 * 【示例】
 * 示例 1：
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = "1" 的行程长度编码 = "11"
 * countAndSay(3) = "11" 的行程长度编码 = "21"
 * countAndSay(4) = "21" 的行程长度编码 = "1211"
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出："1"
 * 解释：
 * 这是基本情况。
 * <p>
 * 【提示】
 * 1 <= n <= 30
 * <p>
 * 进阶：你能迭代解决该问题吗？
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 5;
        String result = new CountAndSay().countAndSay(n);
        System.out.println("计算结果:" + result);
    }

    public String countAndSay(int n) {
        String digits = "1";

        for (int i = 1; i < n; i++) {
            ArrayList<int[]> map = digits2Map(digits);
            digits = map2Digits(map);
        }
        return digits;
    }

    public String test(int n) {
        String digits ="111221";
        ArrayList<int[]> map = digits2Map(digits);
        return map2Digits(map);
    }

    private ArrayList<int[]> digits2Map(String digits) {
        ArrayList<int[]> map = new ArrayList<>();
        if (digits.length() == 1) {
            map.add(new int[]{1, 1});
        } else {
            char ch1 = digits.charAt(0);
            char ch2;
            int count = 1;
            for (int i = 1; i < digits.length(); i++) {
                ch2 = digits.charAt(i);
                if (ch1 == ch2) {
                    count++;
                } else {
                    map.add(new int[]{ch1 - 48, count});
                    ch1 = ch2;
                    count = 1;
                }
            }
            map.add(new int[]{ch1 - 48, count});
        }
        return map;
    }

    private String map2Digits(ArrayList<int[]> map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            sb.append(map.get(i)[1]).append(map.get(i)[0]);
        }
        return sb.toString();
    }

}
