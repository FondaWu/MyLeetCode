package list.sort;

import list.base.ListNode;

public class Bubbleort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 5, 2};
        ListNode head1 = ListNode.makeList(nums);
        head1.printList();
        ListNode head2 = bubbleSort(head1);
        head2.printList();
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int tmp;
        ListNode node1, node2;
        for (node1 = head; node1.next != null; node1 = node1.next) {
            for (node2 = node1; node2 != null; node2 = node2.next) {
                if (node1.val > node2.val) {
                    tmp = node1.val;
                    node1.val = node2.val;
                    node2.val = tmp;
                }
            }
        }
        return head;
    }

    //冒泡排序
    public static ListNode bubbleSort(ListNode head) {
        if (head == null || head.next == null)  //链表为空或者仅有单个结点
            return head;

        ListNode cur = head, tail = null;
        while (cur.next != tail) {
            while (cur.next != tail) {
                if (cur.val > cur.next.val) {
                    int tmp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = tmp;
                }
                cur = cur.next;
            }
            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点
        }

        return head;


    }

}
