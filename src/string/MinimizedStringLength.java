package string;

import java.util.Arrays;

public class MinimizedStringLength {

    public static void main(String[] args) {
        String s = "aaabc";
        //String s = "bb";
        System.out.println("运行结果：" + minimizedStringLength(s));
    }

    public static int minimizedStringLength(String s) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 97] = 1;
        }
        return Arrays.stream(chars).sum();
    }

    public static int minimizedStringLength2(String s) {
        if (s.length() < 1) return 0;

        int len = s.length();
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len--;
            }
            if (i < s.length() - 1) {
                if (s.charAt(i - 1) == s.charAt(i + 1)) {
                    len--;
                    i++;
                }
            }
            i++;
        }
        return len;
    }

    public static int minimizedStringLength1(String s) {
        if (s.length() < 1) return 0;

        char lastChar = s.charAt(0);
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != lastChar) {
                len++;
                lastChar = s.charAt(i);
            }
        }

        return len;
    }

}
