package list;

import list.base.ListNode;

public class RemoveElements {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 6, 6};
        ListNode head1 = ListNode.makeList(nums);
        head1.printList();
        ListNode head2 = removeElements(head1, 6);
        head2.printList();
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        return dummy.next;
    }
}
