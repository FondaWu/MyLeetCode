package tree.binarytree;

/*
96. 不同的二叉搜索树（中等）
【提示】
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
【示例】
示例 1：
输入：n = 3
输出：5
示例 2：
输入：n = 1
输出：1
【提示【
1）1 <= n <= 19
 */
public class NumTrees {

    private int count;

    public static void main(String[] args) {
        int result = new NumTrees().numTrees(3);
        System.out.println("The result is:" + result);
    }

    public int numTrees(int n) {
        if (n == 1) return 1;
        return 2 + numTrees(n - 1);
    }


}
