package list;

import list.base.ListNode;

/*
445. 两数相加 II（中等）
【描述】
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
【示例】
示例1：
输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]
示例2：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]
示例3：
输入：l1 = [0], l2 = [0]
输出：[0]

【提示】
1）链表的长度范围为 [1, 100]
2）0 <= node.val <= 9
3）输入数据保证链表代表的数字无前导 0
4）进阶：如果输入链表不能翻转该如何解决？
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{0};
        ListNode head1 = ListNode.makeList(nums1);
        ListNode head2 = ListNode.makeList(nums2);
        addTwoNumbers(head1, head2).printList();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = ListNode.reverseList(l1, null);
        l2 = ListNode.reverseList(l2, null);

        int carry = 0;
        ListNode head = l1;
        while (l1 != null && (l2 != null || carry != 0)){
            int n = l1.val + carry;
            if (l2 != null) {
                n += l2.val;
                l2 = l2.next;
            }
            carry = n / 10;
            l1.val = n - carry *10;
            if (l1.next == null) {
                if (l2 != null) {
                    l1.next = l2;
                    l2 = null;
                } else {
                    if (carry > 0) {
                        l1.next = new ListNode(carry);
                    }
                    break;
                }
            }
            l1 = l1.next;
        }
        return ListNode.reverseList(head, null);
    }

}
