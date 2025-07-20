package list;

import list.base.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.makeList(dataArray);
        reorderList(head);
        head.printList();
    }


    private static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = ListNode.getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = ListNode.reverseList(head2, null);

        ListNode cur1 = head, next1, cur2 = head2, next2;
        while (cur2 != null){
            next1 = cur1.next;
            next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
    }


    private static void reorderList2(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode headNode = head, preTailNode = null;
        ListNode tailNode;
        while (headNode != null && headNode.next != null) {
            tailNode = headNode;
            while (tailNode.next != null) {
                preTailNode = tailNode;
                tailNode = tailNode.next;
            }
            if (preTailNode != null) preTailNode.next = null;
            tailNode.next = headNode.next;
            headNode.next = tailNode;
            headNode = tailNode.next;
        }
    }

    private static void reorderList1(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode tailNode = getTailNode(head);
        tailNode.next = head.next;
        head.next = tailNode;
        reorderList(tailNode.next);
    }

    private static ListNode getTailNode(ListNode node) {
        ListNode curNode = node, preTailNode = null;
        while (curNode.next != null) {
            preTailNode = curNode;
            curNode = curNode.next;
        }
        if (preTailNode != null) preTailNode.next = null;
        return curNode;
    }
}
