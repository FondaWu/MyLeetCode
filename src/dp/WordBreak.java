package dp;

import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分（中等）
 * 【描述】
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 【示例】
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 【提示】
 * 1) 1 <= s.length <= 300
 * 2) 1 <= wordDict.length <= 1000
 * 3) 1 <= wordDict[i].length <= 20
 * 4) 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 **/
public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        Boolean result = new WordBreak().wordBreak(s, wordDict);
        System.out.println("计算结果：" + result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

}
