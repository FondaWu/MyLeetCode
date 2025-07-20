package list;

import list.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
234. 回文链表(简单)
【描述】
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
【示例】
示例 1：
输入：head = [1,2,2,1]
输出：true

示例 2：
输入：head = [1,2]
输出：false

【提示】
1）链表中节点数目在范围[1, 105] 内
2）0 <= Node.val <= 9
 */
public class IsPalindrome {

    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 0, 1};
        ListNode head = ListNode.makeList(dataArray);
        boolean result = isPalindrome(head);
        System.out.println("计算结果：" + result);

    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail =  slow;
        ListNode node1 = reverseList(head, tail);
        ListNode node2 = fast == null ? slow : slow.next;
        while (node1 != slow && node2 != null) {
            if (node1.val != node2.val) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head, ListNode tail) {
        ListNode curNode = head, lastNode = null, nextNode;
        while (curNode != tail) {
            nextNode = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = nextNode;
        }
        return lastNode;
    }

    private static boolean isPalindrome2(ListNode head) {
        ListNode curNode = head;
        List<Integer> numbers = new ArrayList<>();
        while (curNode != null) {
            numbers.add(curNode.val);
            curNode = curNode.next;
        }
        for (int i = 0; i < numbers.size() - i; i++) {
            if (numbers.get(i) != numbers.get(numbers.size() - i - 1))
                return false;
        }
        return true;
    }

    private static boolean isPalindrome1(ListNode head) {
        ListNode curNode, preNode = null;
        while (head != null) {
            curNode = head;
            while (curNode.next != null) {
                preNode = curNode;
                curNode = curNode.next;
            }

            if (curNode.val != head.val) return false;
            head = head.next;
            if (preNode != null) preNode.next = null;
        }

        return true;
    }

}
