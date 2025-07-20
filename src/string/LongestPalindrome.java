package string;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        String result = longestPalindrome(s);
        System.out.println("字符" + s + "最长回文:" + result);
    }

    private static String longestPalindrome(String s) {
        int max = 0, c = 0, left = 0;
        int len = s.length();
        int j;
        for (int i = 0; i < len; i++) {
            for (j = 0; (i - j >= 0) && (i + j < len); j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                c = j * 2 + 1;
            }
            if (c > max) {
                max = c;
                left = i - max / 2;
            }
            for (j = 0; (i - j >= 0) && (i + j + 1 < len); j++) {
                if (s.charAt(i - j) != s.charAt(i + j + 1)) {
                    break;
                }
                c = j * 2 + 2;
            }
            if (c > max) {
                max = c;
                left = i - max / 2;
            }
        }

        return s.substring(left, left + max);
    }
}
