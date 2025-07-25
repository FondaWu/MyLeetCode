package tree.binarytree;

/*
114. 二叉树展开为链表（中等）
【描述】
给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。

【示例】
示例 1：
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [0]
输出：[0]

【提示】
1）树中结点数在范围 [0, 2000] 内
2）-100 <= Node.val <= 100

【进阶】
你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class Flatten {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, null, 3};
        TreeNode root = TreeNode.constructTree(array);
        System.out.println("Before flatten");
        root.print();
        flatten(root);
        System.out.println("\nAfter flatten");
        root.print();
    }

    private static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            flatten(left);
            root.left = null;
            root.right = left;
            while (left.right != null)
                left = left.right;
            left.right = right;
        }
        if (right != null) {
            flatten(root.right);
        }
    }
}
