package list;

import list.base.ListNode;

public class RotateRight {

    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2, 3, 4, 5};
        ListNode head1 = ListNode.makeList(dataArray);
        ListNode head2 = rotateRight(head1, 2);
        head2.printList();

    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        ListNode tail;
        for (tail = head; tail.next != null; tail = tail.next) {
            len++;
        }
        tail.next = head;

        k = k % len;
        ListNode curNode = head;
        for (int i = 0; i < len - k - 1; i++) {
            curNode = curNode.next;
        }
        head = curNode.next;
        curNode.next = null;
        return head;
    }
}
