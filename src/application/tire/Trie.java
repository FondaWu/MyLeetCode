package application.tire;

import java.util.HashMap;
import java.util.Hashtable;

/*
208. 实现 Trie (前缀树) - 中等
【描述】
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
请你实现 Trie 类：
Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

【示例】
输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]
解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True

【提示】
1）1 <= word.length, prefix.length <= 2000
2）word 和 prefix 仅由小写英文字母组成
3）insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class Trie {

    public class TireNode {

        private int level; // 所在层级
        private boolean end; // 是否为词尾
        private HashMap<Character, TireNode> nextChs; // 后续所有词节点

        TireNode(int level, boolean end) {
            this.level = level;
            this.end = end;
        }
        // 插入下一几点
        public TireNode putNext(char ch, boolean end) {
            TireNode newNode = new TireNode(this.level + 1, end);
            if (this.nextChs == null) this.nextChs = new HashMap<>();
            this.nextChs.put(ch, newNode);
            return newNode;
        }

    }
    private TireNode root;

    public Trie() {
        // 初始化一个根节点
        root = new TireNode(-1, false);
    }

    public void insert(String word) {
        TireNode node = match(word);
        for (int i = node.level + 1; i < word.length(); i++) {
            node = node.putNext(word.charAt(i), false);
        }
        // 这个一定要加上，因为插入词的所有字符可能都存在树里，但是作为另外某些词的一部分。
        node.end = true;
    }


    public boolean search(String word) {
        TireNode node = match(word);
        // 判断匹配的节点层级是否为词尾，并且此节点为词尾节点。
        return node.level == word.length() - 1 && node.end == true;
    }

    public boolean startsWith(String prefix) {
        TireNode node = match(prefix);
        // 判断匹配的节点层级是否为输入字符串的末尾
        return node.level == prefix.length() - 1;
    }

    // 这是插入和查找等函数的关键基础函数，通过词查找最大匹配的节点
    private TireNode match(String word) {
        TireNode node = root;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (node.nextChs != null && node.nextChs.containsKey(ch)) {
                node = node.nextChs.get(ch);
            } else
                break;
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        //trie.insert("app");
        trie.insert("apple");
        boolean result = trie.search("apple");   // 返回 True
        System.out.println("result = " + result);
        result = trie.search("app");     // 返回 False
        System.out.println("result = " + result);
        result = trie.startsWith("app"); // 返回 True
        System.out.println("result = " + result);
        trie.insert("app");
        result = trie.search("app");     // 返回 True
        System.out.println("result = " + result);
    }
}
