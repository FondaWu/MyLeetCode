package list;

import list.base.ListNode;

public class MergeKLists {
    public static void main(String[] args) {
        int dataArray[][] = {{1, 4, 5}, {1, 3, 4}, {2, 6}};

        ListNode[] lists = new ListNode[dataArray.length];
        for (int i = 0; i < dataArray.length; i++) {
            lists[i] = ListNode.makeList(dataArray[i]);
        }
        ListNode head = mergeKLists(lists);
        head.printList();
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, lastNode = null;
        while (true) {
            int minInx = findMinNode(lists);
            if (minInx == -1) break;
            if (head == null) {
                head = lastNode = lists[minInx];
            } else {
                lastNode.next = lists[minInx];
                lastNode = lastNode.next;
            }
            lists[minInx] = lists[minInx].next;
        }

        return head;
    }

    private static int findMinNode(ListNode[] lists) {
        int minInx = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && minVal > lists[i].val) {
                minVal = lists[i].val;
                minInx = i;
            }
        }
        return minInx;
    }
}
