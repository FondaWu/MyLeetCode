package list.sort;

import list.base.ListNode;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 5, 2};
        ListNode head1 = ListNode.makeList(nums);
        ListNode head2 = sortList(head1);
        head2.printList();
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = ListNode.getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        System.out.println("mergeSort, head:" + head.val + ", mid:" + mid.val);

        return mergeSort(sortList(head), sortList(right));
    }

    /**
     * 归并两个有序的链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;
        //得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        // 比较链表中的值
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
}
