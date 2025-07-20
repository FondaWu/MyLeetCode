package list;

import list.base.ListNode;

public class SwapPairs {
    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2, 3, 4};
        ListNode head1 = ListNode.makeList(dataArray);
        head1.printList();
        ListNode head2 = swapPairs(head1);
        head2.printList();
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node1 = head;
        ListNode node2 = head.next;
        int tmp;
        while (node2 != null) {
            tmp = node2.val;
            node2.val = node1.val;
            node1.val = tmp;

            node1 = node2.next;
            if (node1 == null)
                break;
            node2 = node1.next;
        }
        return head;
    }
}
