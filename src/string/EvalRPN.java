package string;

import java.util.Arrays;
import java.util.Stack;

/*
150. 逆波兰表达式求值
描述：给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。请你计算该表达式。返回一个表示表达式值的整数。
注意：
1) 有效的算符为 '+'、'-'、'*' 和 '/' 。
2) 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
3) 两个整数之间的除法总是 向零截断 。
4) 表达式中不含除零运算。
5) 输入是一个根据逆波兰表示法表示的算术表达式。
6) 答案及所有中间计算结果可以用 32 位 整数表示。
 */

public class EvalRPN {

    public static void main(String[] args) {
        //String[] s = new String[]{"2", "1", "+", "3", "*"};
        String[] s = new String[]{"0", "3", "/"};
        System.out.println(evalRPN(s));
    }

    private static int evalRPN(String[] tokens) {
        if (tokens.length < 3) return 0;

        String[] symbols = new String[]{"*", "+", "-",  "/"};
        Stack<Integer> stk = new Stack<>();

        int i = 2, j, d1, d2;
        int result = 0;
        stk.push(Integer.parseInt(tokens[0]));
        stk.push(Integer.parseInt(tokens[1]));
        while (!stk.empty() && i < tokens.length) {
            j = Arrays.binarySearch(symbols, tokens[i]);
            if (j > -1 && j < symbols.length) {
                d2 = stk.pop();
                d1 = stk.pop();
                switch (j) {
                    case 0:
                        result = d1 * d2;
                        break;
                    case 1:
                        result = d1 + d2;
                        break;
                    case 2:
                        result = d1 - d2;
                        break;
                    case 3:
                        result = d1 / d2;
                        break;
                }
                stk.push(result);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return result;
    }

}
