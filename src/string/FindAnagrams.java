package string;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词（中等）
 * 【提示】
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 【提示】
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd",  p= "abc";
        List<Integer> result = new FindAnagrams().findAnagrams(s, p);
        System.out.println("The result is:" + Arrays.toString(result.toArray()));
    }


    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return result;
    }

}
