package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合（中等）
 * 【描述】
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 【提示】
 * 1）0 <= digits.length <= 4
 * 2）digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        // 特殊情况处理，直接返回空数组
        if (digits.length() == 0 || digits.length() > 40) return new ArrayList<>();
        // 新建一个动态数组，存储结果
        List<String> charList = new ArrayList<>();
        // 新建一个StringBuilder，存储字符串生成的中间结果
        StringBuilder sb = new StringBuilder();
        // 调用字母组合生成的递归回溯函数，从第一个数字开始
        appendChars(digits, 0, sb, charList);
        return charList;
    }

    private void appendChars(String digits, int n, StringBuilder sb, List<String> charList) {
        // 已经处理到字符串末尾, 存储生成的字母组合结果
        if (n == digits.length()) {
            charList.add(sb.toString());
        } else {
            // 获取当前数字
            char c1 = digits.charAt(n);
            // 根据字符类型，确定其可映射的字母个数，除了'7'和'9'是4个，其余都是3个
            int len = (c1 == '7' || c1 == '9') ? 4 : 3;
            // '7'数字可映射的字母长度为4，之前所有数字和'8'可映射的字母长度都是3，最后一个忽略不计，因此'7'之前的字母长度为3N,'7'
            // 之后的字母长度为3N+1
            int delta = c1 > '7' ? 1 : 0;
            // 依次处理当前数字可映射的字母
            for (int i = 0; i < len; i++) {
                // 计算当前可映射的字母数值
                char c2 = (char) ('a' + (c1 - '2') * 3 + delta + i);
                // 添加到StringBuilder
                sb.append(c2);
                // 处理下一个数字
                appendChars(digits, n + 1, sb, charList);
                // 回溯删除刚才添加的字母
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
