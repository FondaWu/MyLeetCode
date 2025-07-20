package tree.binarytree;

public class IsSymmetric {

    public static void main(String[] args) {
        //Integer[] array = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        Integer[] array = new Integer[]{1, 2, 2, null, 3, null, 3};
        TreeNode root = TreeNode.constructTree(array);
        boolean result = isSymmetric(root);
        System.out.println("The tree is balanced: " + result);
    }

    private static boolean isSymmetric(TreeNode root) {
        return traverseTree(root.left, root.right);
    }

    private static boolean traverseTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return (traverseTree(p.left, q.right) && traverseTree(p.right, q.left));
    }
}
