package tree.binarytree;

/*
111. 二叉树的最小深度(简单)
【描述】
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。
【提示】
树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
 */

import java.util.List;

public class MinDepth {
    private static int min = 0;

    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, null, 3, null, 4, null, 5, null, 6};
        TreeNode root = TreeNode.constructTree(array);
        int result = minDepth(root);
        System.out.println("树的最小深度:" + result);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        return traversal(root, 1);
    }

    private static int traversal(TreeNode node, int n) {
        if (node.left == null && node.right == null) {
            return n;
        }

        if (node.left == null)
            return traversal(node.right, n + 1);
        if (node.right == null)
            return traversal(node.left, n + 1);
        return Math.min(traversal(node.left, n + 1), traversal(node.right, n + 1));
    }
}
