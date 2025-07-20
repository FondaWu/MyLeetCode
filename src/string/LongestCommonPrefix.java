package string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[] {"", ""};

        String result = longestCommonPrefix(strs);
        System.out.println("最长前缀:" + result);
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuffer sb = new StringBuffer();
        int n = 0;
        if (strs[0].length() < 1) return "";
        while (true) {
            if (strs[0].length()  < n + 1) return sb.toString();
            char c = strs[0].charAt(n);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length()  < n + 1 || strs[i].charAt(n) != c)
                    return sb.toString();
            }
            sb.append(c);
            n++;
        }
    }
}
