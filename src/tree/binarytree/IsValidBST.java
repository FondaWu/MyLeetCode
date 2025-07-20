package tree.binarytree;

public class IsValidBST {

    public static void main(String[] args) {
        //Integer[] array = new Integer[]{5, 4, 6, null, null, 3, 7};
        Integer[] array = new Integer[]{2, 1, 3};
        TreeNode root = TreeNode.constructTree(array);
        boolean result = isValidBST(root);
        System.out.println("The tree is balanced: " + result);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean check = traverseChildTree(root.left, root.val, true) && traverseChildTree(root.right, root.val, false);
        if (!check) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private static boolean traverseChildTree(TreeNode p, int parentVal, boolean left) {
        if (p == null) return true;
        boolean check = left && p.val < parentVal || !left && p.val > parentVal;
        if (!check) return false;
        return traverseChildTree(p.left, parentVal, left) && traverseChildTree(p.right, parentVal, left);
    }

    public static boolean isValidBST1(TreeNode root) {
        if (root == null) return true;

        boolean leftValid = root.left != null ? root.left.val < root.val : true;
        boolean rightValid = root.right != null ? root.right.val > root.val : true;

        return leftValid && rightValid && isValidBST(root.left) && isValidBST(root.right);
    }

}
