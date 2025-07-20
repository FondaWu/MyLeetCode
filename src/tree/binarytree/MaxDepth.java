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
public class MaxDepth {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, null, null, 5};
        TreeNode root = TreeNode.constructTree(array);
        int result = maxDepth(root);
        System.out.println("树的最大深度:" + result);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int m = maxDepth(root.left);
        int n = maxDepth(root.right);

        if (m > n) return m + 1;
        else return n + 1;
    }
}
