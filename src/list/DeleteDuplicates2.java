package list;

import list.base.ListNode;

public class DeleteDuplicates2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        ListNode head1 = ListNode.makeList(nums);
        head1.printList();
        ListNode head2 = deleteDuplicates2(head1);
        head2.printList();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        boolean sameNode = false;
        ListNode lastNode = null, curNode = head, nextNode = curNode.next;
        while (nextNode != null) {
            if (curNode.val == nextNode.val){
                curNode.next =  nextNode.next;
                sameNode = true;
            } else {
                if (sameNode) {
                    if (lastNode != null)
                        lastNode.next = nextNode;
                    else
                        head = nextNode;
                } else {
                    lastNode = curNode;
                }
                curNode = nextNode;
                sameNode = false;
            }
            nextNode = nextNode.next;
        }
        if (sameNode) {
            if (lastNode  != null) lastNode.next = null;
            else return null;
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
