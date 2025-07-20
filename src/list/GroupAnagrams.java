package list;

import java.util.*;

/*
49. 字母异位词分组（中等）
【描述】
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

【示例】
示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:
输入: strs = [""]
输出: [[""]]

示例 3:
输入: strs = ["a"]
输出: [["a"]]


【提示】
1）1 <= strs.length <= 104
2）0 <= strs[i].length <= 100
3）strs[i] 仅包含小写字母
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        //String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = new String[]{"abbbbbbbbbbb","aaaaaaaaaaab"};

        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        String key;
        StringBuffer sb = new StringBuffer();
        byte[] count = new byte[26];
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    sb.append((char)('a' + i));
                    sb.append(count[i]);
                }
            }
            key = sb.toString();
            List<String> list = strMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            strMap.put(key, list);
            sb.delete(0, sb.length());
            Arrays.fill(count, (byte) 0);
        }
        return new ArrayList<>(strMap.values());
    }

    private static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        String value;
        for (String str : strs) {
            value = sortString(str);
            if (strMap.containsKey(value)) {
                strMap.get(value).add(str);
            } else {
                strMap.put(value, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(strMap.values());
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
