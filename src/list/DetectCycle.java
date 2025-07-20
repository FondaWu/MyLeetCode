package list;

import list.base.ListNode;

import java.util.HashSet;

public class DetectCycle {
    public static void main(String[] args) {
        int[] dataArray1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        ListNode head = ListNode.makeList(dataArray1);
        ListNode tail = head.getTailNode();
        tail.next = head;
        ListNode cycleBegin = detectCycle(head);
        System.out.println("The list cycle begin with:" + cycleBegin.val);
    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        HashSet<Integer> set = new HashSet<>();
        ListNode node1 = head;
        while (node1 != null) {
            if (set.contains(node1.hashCode())) return node1;
            set.add(node1.hashCode());
            node1 = node1.next;
        }
        return null;
    }
}
