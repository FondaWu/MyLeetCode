package string;

import java.util.Stack;

public class RemoveDuplicateChar {
    public static void main(String[] args) {
        String s = "abbaca";
        String result = removeDuplicates(s);
        System.out.println("result = " + result);
    }

    private static String removeDuplicates(String s) {
        if (s == null || s.length() < 2) return s;
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i + 1 < sb.length()) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                if (i > 0) i--;
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    private static String removeDuplicates2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek()== s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private static String removeDuplicates3(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                if (i != 0) {
                    i -= 2;
                } else {
                    i--;
                }
            }
        }
        return sb.toString();
    }
}
