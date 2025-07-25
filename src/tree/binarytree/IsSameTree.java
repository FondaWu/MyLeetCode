package tree.binarytree;

/**
 * 100. 相同的树(简单)
 * 【描述】
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 【提示】
 * 1）两棵树上的节点数目都在范围 [0, 100] 内
 * 2）-104 <= Node.val <= 104
 **/
public class IsSameTree {

    public static void main(String[] args) {
        Integer[] array1 = new Integer[]{1, 2};
        Integer[] array2 = new Integer[]{1,null,2};
        TreeNode p = TreeNode.constructTree(array1);
        TreeNode q = TreeNode.constructTree(array2);
        boolean result = isSameTree(p, q);
        System.out.println("The two tree is the same:" + result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
