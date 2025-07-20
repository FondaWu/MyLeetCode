package tree.binarytree;

public class IsBalanced {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        TreeNode root = TreeNode.constructTree(array);
        boolean result = isBalanced(root);
        System.out.println("The tree is balanced:" + result);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int m = maxDepth(root.left);
        int n = maxDepth(root.right);
        return Math.abs(m - n) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int m = maxDepth(root.left);
        int n = maxDepth(root.right);

        return m > n ? m + 1 : n + 1;
    }
}
