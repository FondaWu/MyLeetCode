package list;

import list.base.ListNode;

import java.util.Arrays;

public class NextLargerNodes {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        ListNode head = ListNode.makeList(nums);
        int[] result = nextLargerNodes(head);
        if (result != null)
            System.out.println("The result is:" + Arrays.toString(result));
    }

    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int[] result = new int[count];
        int i = 0;
        node = head;
        while (node != null) {
            ListNode node2 = node.next;
            while (node2 != null && node2.val <= node.val) {
                node2 = node2.next;
            }
            result[i++] = (node2 == null) ? 0 : node2.val;
            node = node.next;
        }

        return result;
    }
}
