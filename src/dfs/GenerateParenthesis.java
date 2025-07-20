package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {
    // 生成的有效括号字符串列表
    private List<String> result;
    // StringBuilder变量，用于生成有效括号字符串
    private StringBuilder sb;
    // 左括号数量
    private int count1;
    // 右括号数量
    private int count2;

    public GenerateParenthesis(){
        // 初始化各个变量
        result = new ArrayList<>();
        sb = new StringBuilder();
        count1 = 0;
        count2 = 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> result = new GenerateParenthesis().generateParenthesis(3);
        System.out.println("result = " + Arrays.toString(result.toArray()));
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    public List<String> generateParenthesis(int n) {
        // 有效的括号字符串肯定，第一个肯定是左括号
        generateParenthesis(n, 0);
        // 返回最终结果
        return result;
    }

    /**
     * 生成有效括号字符串
     *  @param n 有效括号组数量
     *  type：当前添加括号的类型，0:左括号，1：右括号
     **/

    private void generateParenthesis(int n, int type) {
        // 当前添加左括号
        if (type == 0) {
            sb.append('(');
            count1++;
        } else { // 当前添加右括号
            sb.append(')');
            count2++;
            // 右括号数量等于n,说明新的有效括号组完成，添加到结果类表中
            if (count2 == n) {
                result.add(sb.toString());
                return;
            }
        }
        // 先处理左括号，如果左括号数小于n，添加左括号
        if (count1 < n) {
            generateParenthesis(n, 0);
            // 回溯，删除这一层递归函数里添加的左括号，并将左括号数减一
            sb.deleteCharAt(sb.length() - 1);
            count1--;
        }
        // 再处理右括号，右括号只能数量小于左括号时才能添加
        if (count2 < count1) {
            generateParenthesis(n, 1);
            // 回溯，删除这一层递归函数里添加的左括号，并将左括号数减一
            sb.deleteCharAt(sb.length() - 1);
            count2--;
        }
    }
}
