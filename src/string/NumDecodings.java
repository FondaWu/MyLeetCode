package string;

public class NumDecodings {
    private static int count = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = numDecodings("111111111111111111111111111111111111111111111");
        System.out.println("result = " + result);
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    private static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        numDecodings(chars, 0);
        return count;
    }

    private static void numDecodings(char[] chars, int n) {
        if (n == chars.length) {
            count++;
            return;
        }
        char ch1 = chars[n];
        if (ch1 > 48) {
            numDecodings(chars, n + 1);
            if (n < chars.length - 1) {
                char ch2 = (char) (ch1 * 10 + chars[n + 1] - 528);
                if (ch2 < 27) {
                    numDecodings(chars, n + 2);
                }
            }
        }

    }

    private static int numDecodings1(String s) {
        numDecodings1(s, 0);
        return count;
    }

    private static void numDecodings1(String s, int n) {
        if (n == s.length()) {
            count++;
            return;
        }
        char ch1 = s.charAt(n);
        if (ch1 > 48) {
            numDecodings1(s, n + 1);
            if (n < s.length() - 1) {
                char ch2 = (char) (ch1 * 10 + s.charAt(n + 1) - 528);
                if (ch2 < 27) {
                    numDecodings1(s, n + 2);
                }
            }
        }

    }
}
