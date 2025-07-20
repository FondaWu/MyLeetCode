package list;

import list.base.ListNode;
import tree.binarytree.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树（中等）
 * 【描述】
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 * 【示例】
 * 示例 1:
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 示例 2:
 * 输入: head = []
 * 输出: []
 * 【提示】
 * 1）head 中的节点数在[0, 2 * 104] 范围内
 * 2）-105 <= Node.val <= 105
 */
public class SortedListToBST {

    public static void main(String[] args) {
        int[] dataArray = new int[]{0};
        //int[] dataArray = new int[]{-10, -3, 0, 5, 9};
        //int[] dataArray = new int[]{0, 1, 2, 3, 4, 5};
        ListNode head = ListNode.makeList(dataArray);
        TreeNode root = new SortedListToBST().sortedListToBST(head);
        if (root != null) {
            root.print();
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode middleNode = middleNode(head, tail);
        TreeNode root = new TreeNode(middleNode.val);
        root.left = sortedListToBST(head, middleNode);
        root.right = sortedListToBST(middleNode.next, tail);
        return root;
    }

    private TreeNode sortedListToBST1(ListNode head, ListNode tail) {
        if (head == null || head == tail) return null;
        ListNode middleNode = middleNode(head, tail);
        if (middleNode == null) return null;
        TreeNode root = new TreeNode(middleNode.val);
        TreeNode left = sortedListToBST(head, middleNode);
        root.left = left;
        if (middleNode.next != null) {
            root.right = sortedListToBST(middleNode.next, tail);
        }
        return root;
    }

    private ListNode middleNode(ListNode head, ListNode tail) {
        ListNode node1 = head, node2 = head;
        while (node2 != tail && node2.next != tail) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return node1;
    }
}
