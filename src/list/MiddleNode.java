package list;

import list.base.ListNode;

public class MiddleNode {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        ListNode head1 = ListNode.makeList(nums);
        head1.printList();
        ListNode head2 = middleNode(head1);
        head2.printList();
    }
    public static ListNode middleNode(ListNode head) {
        ListNode node1 = head, node2 = head;
        while(node2 != null && node2.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return node1;
    }

}
