package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
32. 最长有效括号(困难)
【描述】
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

【提示】
1) 0 <= s.length <= 3 * 104
2) s[i] 为 '(' 或 ')'
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        //String s = "(()(((()";
        //String s = ")()())";
        //String s = "()(())";
        String s = ")(((((()())()()))()(()))(";
        int result = longestValidParentheses(s);
        System.out.println("字符" + s + "最长有效括号数:" + result);
    }

    private static class ParenthesesInfo {
        public int index;
        public int type;

        public ParenthesesInfo(int index, int type) {
            this.index = index;
            this.type = type;
        }
    }

    private static class ParenthesesCount {
        public int index;
        public int count;

        public ParenthesesCount(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 作为第一个有效子串找到时的基准
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // 更新下一个有效子串的基准
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static int longestValidParentheses6(String s) {
        Stack<ParenthesesInfo> piStack = new Stack<>();
        List<ParenthesesCount> pcList = new ArrayList<>();
        int topIndex, count, max = 0;
        ParenthesesCount pc;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                piStack.add(new ParenthesesInfo(i, 0));
            } else if (charArray[i] == ')') {
                if (!piStack.empty() && piStack.peek().type == 0) {
                    ParenthesesInfo pi = piStack.pop();
                    if (pcList.size() == 0) {
                        pcList.add(new ParenthesesCount(pi.index, 2));
                    } else {
                        topIndex = piStack.empty() ? -1 : piStack.peek().index;
                        count = 2;
                        while (pcList.size() != 0) {
                            pc = pcList.get(pcList.size() - 1);
                            if (topIndex > pc.index) break;
                            count += pc.count;
                            pcList.remove(pcList.size() - 1);
                        }
                        pcList.add(new ParenthesesCount(pi.index, count));
                    }
                } else {
                    piStack.add(new ParenthesesInfo(i, 1));
                }
            }
        }
        for (ParenthesesCount pc2 : pcList) {
            if (pc2.count > max) max = pc2.count;
        }
        return max;
    }

    public static int longestValidParentheses5(String s) {
        Stack<ParenthesesInfo> piStack = new Stack<>();
        List<ParenthesesCount> pcList = new ArrayList<>();
        int topIndex, count, max = 0;
        ParenthesesCount pc;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                piStack.add(new ParenthesesInfo(i, 0));
            } else if (charArray[i] == ')') {
                if (!piStack.empty() && piStack.peek().type == 0) {
                    ParenthesesInfo pi = piStack.pop();
                    if (pcList.size() == 0) {
                        pcList.add(new ParenthesesCount(pi.index, 2));
                    } else {
                        topIndex = piStack.empty() ? -1 : piStack.peek().index;
                        count = 2;
                        int j = pcList.size() - 1;
                        boolean find = false;
                        for (; j >= 0; j--) {
                            pc = pcList.get(j);
                            if (topIndex > pc.index) break;
                            count += pc.count;
                            find = true;
                        }
                        if (find) {
                            pcList.get(j+1).count = count;
                            int len = pcList.size();
                            for(j = j + 2; j < len; j++)
                                pcList.remove(pcList.size()-1);
                        } else{
                            pcList.add(new ParenthesesCount(pi.index, count));
                        }
                    }
                } else {
                    piStack.add(new ParenthesesInfo(i, 1));
                }
            }
        }
        for (ParenthesesCount pc2 : pcList) {
            if (pc2.count > max) max = pc2.count;
        }
        return max;
    }

    public static int longestValidParentheses4(String s) {
        Stack<ParenthesesInfo> piStack = new Stack<>();
        List<ParenthesesCount> pcList = new ArrayList<>();
        int topIndex, count = 0, last = 0;
        ParenthesesCount pc;
        char[] charArray = s.toCharArray();
        boolean match;
        for (int i = 0; i < charArray.length; i++) {
            match = (charArray[i] == ')' && !piStack.empty() && piStack.peek().type == 0);
            if (match) {
                piStack.pop();
                if (count == 0) last = i;
                count += 2;
                if (i == charArray.length - 1 && count > 0) {
                    topIndex = piStack.empty() ? -1 : piStack.peek().index;
                    while (pcList.size() != 0) {
                        pc = pcList.get(pcList.size() - 1);
                        if (topIndex > pc.index) break;
                        count += pc.count;
                        pcList.remove(pcList.size() - 1);
                    }
                    pcList.add(new ParenthesesCount(last, count));
                    count = 0;
                }
            } else {
                if ((!match || i == charArray.length - 1) && count > 0) {
                    topIndex = piStack.empty() ? -1 : piStack.peek().index;
                    while (pcList.size() != 0) {
                        pc = pcList.get(pcList.size() - 1);
                        if (topIndex > pc.index) break;
                        count += pc.count;
                        pcList.remove(pcList.size() - 1);
                    }
                    pcList.add(new ParenthesesCount(last, count));
                    count = 0;
                }
                if (charArray[i] == '(') {
                    piStack.add(new ParenthesesInfo(i, 0));
                } else {
                    piStack.add(new ParenthesesInfo(i, 1));
                }
            }

        }
        int max = count;
        for (ParenthesesCount pc2 : pcList) {
            if (pc2.count > max) max = pc2.count;
        }
        return max;
    }

    private static int longestValidParentheses3(String s) {
        Stack<ParenthesesInfo> charStk = new Stack<>();
        Stack<ParenthesesCount> parenthesesCount = new Stack<>();
        char c;
        int topIndex, count, max = 0;
        ParenthesesCount pc;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                charStk.add(new ParenthesesInfo(i, 0));
            } else if (c == ')') {
                if (!charStk.empty() && charStk.peek().type == 0) {
                    ParenthesesInfo pi = charStk.pop();
                    if (parenthesesCount.empty()) {
                        parenthesesCount.push(new ParenthesesCount(pi.index, 2));
                    } else {
                        topIndex = charStk.empty() ? -1 : charStk.peek().index;
                        count = 2;
                        while (!parenthesesCount.empty() && topIndex < parenthesesCount.peek().index) {
                            pc = parenthesesCount.pop();
                            count += pc.count;
                        }
                        parenthesesCount.push(new ParenthesesCount(pi.index, count));
                    }
                } else {
                    charStk.add(new ParenthesesInfo(i, 1));
                }

            }
        }
        while (!parenthesesCount.empty()) {
            pc = parenthesesCount.pop();
            if (pc.count > max) max = pc.count;
        }
        return max;
    }

    private static int longestValidParentheses2(String s) {
        Stack<Character> charStk = new Stack<>();
        char c;
        int count = 0, last = 0, lastMax = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                charStk.add(c);
            } else if (c == ')') {
                if (!charStk.empty()) {
                    charStk.pop();
                    count += 2;
                    if (charStk.empty()) {
                        last += count;
                        count = 0;
                    }
                } else {
                    lastMax = Math.max(lastMax, Math.max(last, count));
                    last = count = 0;
                }

            }
        }
        return Math.max(lastMax, Math.max(last, count));
    }

    private static int longestValidParentheses1(String s) {
        char c;
        int left = 0, count = 0, last = 0, lastMax = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                if (count == 0) left++;
                else {
                    last = count;
                    count = 0;
                    left++;
                }
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                    count += 2;
                    if (left == 0) {
                        last = last + count;
                        count = 0;
                    }
                } else {
                    lastMax = Math.max(lastMax, Math.max(last, count));
                    last = count = 0;
                }
            }
        }
        return Math.max(lastMax, Math.max(last, count));
    }
}
