package list;

import list.base.ListNode;

/*
86. 分隔链表（中等）
【描述】
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你应当 保留 两个分区中每个节点的初始相对位置。
【示例】
示例 1：
输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]
示例 2：
输入：head = [2,1], x = 2
输出：[1,2]
【提示】
1）链表中节点的数目在范围 [0, 200] 内
2）-100 <= Node.val <= 100
3）-200 <= x <= 200
 */
public class Partition {

    public static void main(String[] args) {
        //int[] nums = new int[]{1, 4, 3, 2, 5, 2};
        int[] nums = new int[]{};
        ListNode head = ListNode.makeList(nums);
        head = partition(head, 2);
        if (head != null) head.printList();
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode node1 = head, lastNode = null, nextNode, head2 = null, node2 = null;

        while (node1 != null) {
            nextNode = node1.next;
            if (node1.val >= x) {
                if (lastNode != null) {
                    lastNode.next = node1.next;
                }
                if (node2 != null) {
                    node2.next = node1;
                } else {
                    head2 = node1;
                }
                node2 = node1;
                node2.next = null;
            } else {
                if (lastNode == null) {
                    head = node1;
                }
                lastNode = node1;
            }
            node1 = nextNode;
        }
        if (lastNode != null)
            lastNode.next = head2;

        return head;
    }

}
