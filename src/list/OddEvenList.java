package list;

import list.base.ListNode;

/*
328. 奇偶链表（中等）
【描述】
给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。

【示例】
示例 1:
输入: head = [1,2,3,4,5]
输出: [1,3,5,2,4]
示例 2:
输入: head = [2,1,3,5,6,4,7]
输出: [2,3,6,7,1,5,4]

【提示】
1）n ==  链表中的节点数
2）0 <= n <= 104
3）-106 <= Node.val <= 106
 */
public class OddEvenList {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 5, 6, 4, 7};
        ListNode head = ListNode.makeList(nums);
        head = oddEvenList(null);
        if (head != null) head.printList();
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode node = head, odd = null, even = null, evenHead = null;
        int n = 1;
        while (node != null) {
            if (n++ % 2 == 1) {
                if (odd != null) {
                    odd.next = node;
                }
                odd = node;
            } else {
                if (even != null) {
                    even.next = node;
                } else {
                    evenHead = node;
                }
                even = node;
            }
            node = node.next;
        }
        if (even != null)
            even.next = null;
        if (odd != null)
            odd.next = evenHead;
        return head;
    }
}
