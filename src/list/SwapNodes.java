package list;

import list.base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwapNodes {

    public static void main(String[] args) {
        int[] dataArray = new int[]{1, 2, 3, 4, 5};
        ListNode head1 = ListNode.makeList(dataArray);
        ListNode head2 = new SwapNodes().swapNodes(head1, 2);
        head2.printList();

    }

    private ListNode swapNodes(ListNode head, int k) {
        List<Integer> nodeList = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodeList.add(node.val);
            node = node.next;
        }

        int val1 = nodeList.get(k - 1);
        int val2 = nodeList.get(nodeList.size() - k);
        nodeList.set(k-1, val2);
        nodeList.set(nodeList.size() - k, val1);

        return makeList(nodeList);
    }

    private ListNode makeList(List<Integer> dataArray) {
        ListNode first = null, last = null;
        for (int i = 0; i < dataArray.size(); i++) {
            ListNode node = new ListNode(dataArray.get(i));
            if (first == null) {
                first = node;
            } else {
                last.next = node;

            }
            last = node;
        }
        return first;
    }

}
