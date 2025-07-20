package list;

import list.base.ListNode;

import java.util.Arrays;

public class ReversePrint {

    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.makeList(dataArray);
        int[] result = reversePrint(head);
        System.out.println("逆向后生成的数组：" + Arrays.toString(result));

    }

    private static int[] reversePrint(ListNode head) {
        if (head == null) return null;

        int len = 0;
        ListNode curNode = head;
        for (; curNode != null; curNode = curNode.next, len++) ;
        int[] data = new int[len];
        for (curNode = head; curNode != null; curNode = curNode.next) {
            data[--len] = curNode.val;
        }
        return data;
    }
}
