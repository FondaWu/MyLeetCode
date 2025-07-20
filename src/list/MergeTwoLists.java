package list;

import list.base.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4};
        ListNode list1 = ListNode.makeList(l1);
        ListNode list2 = ListNode.makeList(l2);

        ListNode list3 = mergeTwoLists(list1, list2);
        list3.printList();
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode headNode, curNode;
        if (list1.val < list2.val) {
            headNode = curNode = list1;
            list1 = list1.next;
        } else {
            headNode = curNode = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curNode.next = list1;
                curNode = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                curNode = list2;
                list2 = list2.next;
            }
        }
        curNode.next = list1 != null ? list1 : list2;

        return headNode;
    }
}
