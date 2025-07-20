package list;

import list.base.ListNode;

public class DeleteNode {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 6, 6};
        ListNode head1 = ListNode.makeList(nums);
        head1.printList();
        deleteNode(head1);
        head1.printList();
    }

    public static void deleteNode(ListNode node) {
        ListNode lastNode = null;
        while (node.next != null){
            node.val = node.next.val;
            lastNode = node;
            node = node.next;
        }
        lastNode.next = null;
    }
}
