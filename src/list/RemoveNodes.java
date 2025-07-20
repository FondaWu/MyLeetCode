package list;

import list.base.ListNode;

import java.util.Stack;

public class RemoveNodes {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};

        ListNode head = ListNode.makeList(nums);
        ListNode newHead = removeNodes(head);
        newHead.printList();
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode lastNode = ListNode.reverseList(head, null);
        ListNode curNode, nextNode = lastNode.next;
        lastNode.next = null;
        int maxVal = lastNode.val;
        while (nextNode != null) {
            curNode = nextNode;
            nextNode = nextNode.next;
            if (curNode.val >= maxVal) {
                maxVal = curNode.val;
                curNode.next = lastNode;
                lastNode = curNode;
            }
        }

        return lastNode;
    }

    public static ListNode removeNodes2(ListNode head) {
        Stack<Integer> dataStack = new Stack<>();
        while (head != null) {
            dataStack.push(head.val);
            head = head.next;
        }
        ListNode lastNode = new ListNode(dataStack.pop());
        ListNode curNode;
        int max = lastNode.val;
        int data;
        do {
            data = dataStack.pop();
            if (data >= max) {
                max = data;
                curNode = new ListNode(max);
                curNode.next = lastNode;
                lastNode = curNode;
            }

        } while (!dataStack.empty());

        return lastNode;
    }
}
