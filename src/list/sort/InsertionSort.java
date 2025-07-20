package list.sort;

import list.base.ListNode;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{ 1, 4, 3, 5, 2};
        ListNode head1 = ListNode.makeList(nums);
        head1.printList();
        ListNode head2 = insertionSortList(head1);
        head2.printList();
    }

    private static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node1 = head.next, node2, preNode, nextNode;
        while (node1 != null){
            nextNode = node1.next;
            preNode = node2 = head;
            while (node2.val < node1.val){
                preNode = node2;
                node2 = node2.next;
            }

            if (node1 != node2){
                preNode.next = node1;
                node1.next = node2;
            }

            node1 = nextNode;
        }

        return head;
    }
}
