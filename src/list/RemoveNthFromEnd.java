package list;

import list.base.ListNode;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2};
        ListNode head1 = ListNode.makeList(dataArray);
        head1.printList();
        ListNode head2 = removeNthFromEnd(head1, 2);
        head2.printList();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n > 0 && head.next == null) return null;

        int i = 1;
        ListNode node1 = head;
        while (node1.next != null && i < n) {
            node1 = node1.next;
            i++;
        }
        if (i < n) return head;

        ListNode node2 = head;
        ListNode preNode2 = node2;
        while (node1.next != null) {
            node1 = node1.next;
            preNode2 = node2;
            node2 = node2.next;
        }

        if (preNode2 == node1){
            head = head.next;
        } else
            preNode2.next = node2.next;

        return head;
    }

}
