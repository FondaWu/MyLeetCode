package tree.binarytree;

import java.util.Arrays;
import java.util.List;

/*
222. 完全二叉树的节点个数（简单）
【描述】
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
示例 1：
输入：root = [1,2,3,4,5,6]
输出：6
示例 2：
输入：root = []
输出：0
示例 3：
输入：root = [1]
输出：1
【提示】
1）树中节点的数目范围是[0, 5 * 104]
2）0 <= Node.val <= 5 * 104
3）题目数据保证输入的树是 完全二叉树
 */
public class CountNodes {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        TreeNode root = TreeNode.constructTree(array);
        int result = new CountNodes().countNodes(root);
        System.out.println("The result is:" + result);
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
