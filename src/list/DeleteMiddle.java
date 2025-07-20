package list;

import list.base.ListNode;

public class DeleteMiddle {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 7, 1, 2, 6};
        ListNode head = ListNode.makeList(nums);

        head = deleteMiddle(head);
        if (head != null)
            head.printList();
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, pre = slow, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static ListNode deleteMiddle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 快慢指针
        ListNode slow = head, last = slow, quick = head;
        // 快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            last = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode midNode = quick.next == null ? last : slow;
        if (midNode.next != null)
            midNode.next = midNode.next.next;
        return head;
    }

}
