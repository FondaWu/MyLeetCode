package list;

import list.base.ListNode;

public class HasCycle {

    public static void main(String[] args) {
        int[] dataArray1 = new int[]{1, 2, 3, 4, 5};

        ListNode head = ListNode.makeList(dataArray1);
        ListNode tail = head.getTailNode();
        tail.next = head.next.next;
        Boolean hasCycle = hasCycle(head);
        System.out.println("The list has cycle:" + hasCycle);
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode node1 = head, node2 = head;
        while (node2.next != null && node2.next.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) return true;
        }

        return false;
    }

}
