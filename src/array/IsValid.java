package array;

public class IsValid {
    public static void main(String[] args) {
        boolean result = isValid4("{[]}");
        System.out.println("result = " + result);
    }

    private static boolean isValid(String s) {
        final char[] symbols1 = {'(', '[', '{'};
        final char[] symbols2 = {')', ']', '}'};
        StringBuffer sb = new StringBuffer();
        char c;
        int j;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            for (j = 0; j < symbols1.length; j++) {
                if (c == symbols1[j]) {
                    sb.append(c);
                    break;
                } else if (c == symbols2[j]) {
                    if (sb.length() < 1 || sb.charAt(sb.length() - 1) != symbols1[j]) return false;
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
            }
            if (j == symbols1.length) return false;
        }
        return sb.length() == 0;
    }

    private static boolean isValid2(String s) {
        final char[] symbols1 = {'(', '[', '{'};
        final char[] symbols2 = {')', ']', '}'};
        StringBuilder sb = new StringBuilder();
        char c;
        int j;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            for (j = 0; j < symbols1.length; j++) {
                if (c == symbols1[j]) {
                    sb.append(c) ;
                    break;
                } else if (c == symbols2[j]) {
                    if (sb.length() < 1 || sb.charAt(sb.length() - 1) != symbols1[j]) return false;
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
            }
            if (j == symbols1.length) return false;
        }
        return sb.length() == 0;
    }

    public static boolean isValid3(String s) {
        final char[] symbols1 = {'(', '[', '{'};
        final char[] symbols2 = {')', ']', '}'};
        char[] stack = new char[s.length() - 1];
        char c;
        int j , n = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            for (j = 0; j < symbols1.length; j++) {
                if (c == symbols1[j]) {
                    stack[n++] = c;
                    break;
                } else if (c == symbols2[j]) {
                    if (n < 1 || stack[n-1] != symbols1[j]) return false;
                    n--;
                    break;
                }
            }
            if (j == symbols1.length) return false;
        }
        return n == 0;
    }

    public static boolean isValid4(String s) {
        final char[] symbols = {'(', ')','[', ']','{', '}'};
        char[] stack = new char[s.length() >> 1];
        char c, n = 0;
        for (char i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            char j = 0;
            for (; j < symbols.length; j++) {
                if (c == symbols[j]) {
                    if (j % 2 == 0) {
                        if (n == (s.length() >> 1)) return false;
                        stack[n++] = c;
                    } else {
                        if (n < 1 || stack[--n] != symbols[j - 1]) return false;
                    }
                    break;
                }
            }
            if (j == symbols.length) return false;
        }
        return n == 0;
    }
}
