package tree.binarytree;

import java.util.*;

/*
235. 二叉搜索树的最近公共祖先（中等）
【描述】
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
【示例】
示例 1:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
【说明】
1）所有节点的值都是唯一的。
2）p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeNode.constructTree(array);
        TreeNode p = TreeNode.findNode(root, 2);
        TreeNode q = TreeNode.findNode(root, 8);

        TreeNode resutl = lowestCommonAncestor(root, p, q);
        if (resutl != null)
            System.out.println("The result is:" + resutl.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodeList1 = new ArrayList<>();
        findAncestors(root, p, nodeList1);

        List<TreeNode> nodeList2 = new ArrayList<>();
        findAncestors(root, q, nodeList2);

        Collections.reverse(nodeList1);
        Collections.reverse(nodeList2);
        for (TreeNode treeNode : nodeList1) {
            if (nodeList2.indexOf(treeNode) != -1)
                return treeNode;
        }

        return null;
    }

    private static boolean findAncestors(TreeNode root, TreeNode node, List<TreeNode> nodeList) {
        nodeList.add(root);
        if (root == node) {
            return true;
        }
        if (root.left != null) {
            if (findAncestors(root.left, node, nodeList) == true)
                return true;
        }
        if (root.right != null) {
            if (findAncestors(root.right, node, nodeList) == true)
                return true;
        }
        nodeList.remove(nodeList.size() - 1);
        return false;
    }

}
