package list;

import list.base.ListNode;

/*
25. K 个一组翻转链表(困难)
【描述】
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

【示例】
示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

示例 2：
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

【提示】
1) 链表中的节点数目为 n
2) 1 <= k <= n <= 5000
3) 0 <= Node.val <= 1000

 */
public class ReverseKGroup {

    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = ListNode.makeList(dataArray);
        ListNode head2 = reverseKGroup(head, 3);
        System.out.println("计算结果：");
        head2.printList();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curNode = head;
        ListNode groupHead, groupTail = head, lastGroupTail = null;
        int len = 0;
        while (curNode != null) {
            curNode = curNode.next;
            if (++len % k == 0) {
                groupHead = ListNode.reverseList(groupTail, curNode);
                if (lastGroupTail != null) {
                    lastGroupTail.next = groupHead;
                    lastGroupTail = groupTail;
                } else {
                    lastGroupTail = head;
                    head = groupHead;
                }
                groupTail = curNode;
            }
        }
        lastGroupTail.next = groupTail;
        return head;
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode thisHead = head;
        ListNode curNode = head, lastNode = null, nextNode;
        ListNode nextPreNode = null, preNode = null;
        int len = 0;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }

        curNode = head;
        int n = 0;
        int times = 0, totalTimes = len / k;
        while (curNode != null && times < totalTimes) {
            nextNode = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = nextNode;

            if (++n % k == 0) {
                times++;
                if (preNode != null) {
                    preNode.next = lastNode;
                    preNode = nextPreNode;
                } else {
                    preNode = thisHead;
                    thisHead = lastNode;
                }
                nextPreNode = curNode;
                lastNode = null;
            }
        }

        if (curNode != null) preNode.next = curNode;
        return thisHead;
    }
}
