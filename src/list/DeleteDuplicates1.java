package list;

import list.base.ListNode;

public class DeleteDuplicates1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        ListNode head1 = ListNode.makeList(nums);
        head1.printList();
        ListNode head2 = deleteDuplicates(head1);
        head2.printList();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode curNode = head, nextNode = curNode.next;
        while (nextNode != null){
            if (curNode.val == nextNode.val) {
                curNode.next = nextNode.next;
            } else {
                curNode = nextNode;
            }
            nextNode = nextNode.next;
        }
        return head;
    }
}
