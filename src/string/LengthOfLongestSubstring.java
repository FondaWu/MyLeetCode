package string;

import java.util.HashMap;

/*
3. 无重复字符的最长子串(中等)
描述：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
提示：
1) 0 <= s.length <= 5 * 104
2) s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "abba";
        int result = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (charIndexMap.containsKey(c)) {
                int i = charIndexMap.get(c) + 1;
                if (left > i) {
                    i = i;
                }
                left = Math.max(left, charIndexMap.get(c) + 1);
            }
            charIndexMap.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int i = 0;
        int max = 0;
        StringBuilder sb = new StringBuilder(s);
        String subString = "";
        while (i < sb.length()) {
            char ch = sb.charAt(i);
            int inx = subString.indexOf(ch);
            if (inx != -1) {
                if (max < subString.length()) max = subString.length();
                subString = subString.substring(inx + 1);
            }
            subString += ch;
            i++;
        }
        if (max < subString.length()) max = subString.length();
        return max;
    }
}
