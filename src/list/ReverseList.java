package list;

import list.base.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2, 3, 4, 5};
        ListNode head1 = ListNode.makeList(dataArray);
        ListNode head2 = ListNode.reverseList(head1, null);
        head2.printList();
    }
}
