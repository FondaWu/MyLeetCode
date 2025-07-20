package string;

public class Strstr {
    public static void main(String[] args) {
        String haystack = "a", needle = "a";
        int result = strStr(haystack, needle);
        System.out.println("第一个匹配项的下标:" + result);
    }

    public static int strStr(String haystack, String needle) {
        int m = 0, n ;
        int len1 = haystack.length();
        int len2 = needle.length();
        while (m + len2 <= len1) {
            for (n = 0; n < len2; n++) {
                if (haystack.charAt(m + n) != needle.charAt(n)) {
                    break;
                }
            }
            if (n == len2) return m;
            m++;
        }
        return -1;
    }
}
