package list;

import list.base.ListNode;

public class ReverseBetween {
    public static void main(String[] args) {
        //int[] dataArray = new int[]{1, 2, 3, 4, 5};
        int[] dataArray = new int[]{1, 2, 3};
        ListNode head1 = ListNode.makeList(dataArray);
        ListNode head2 = new ReverseBetween().reverseBetween(head1, 1, 2);
        head2.printList();

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 特殊情况处理
        if (head.next == null || left == right) return head;
        // 定义一个左节点变量
        ListNode leftNode = head;
        // 定义一个左节点的前一节点
        ListNode leftPre = (left == 1) ? null : head;
        int i = 0;
        // 从节点首位置行走left步，找到左节点
        for (; i < left - 1; i++) {
            if (leftNode == null) return null;
            leftPre = leftNode;
            leftNode = leftNode.next;
        }
        // 定义一个右节点
        ListNode rightNode = leftNode;
        // 从节点当前位置继续行走一共right步，找到右节点
        for (; i < right - 1; i++) {
            if (rightNode == null) return null;
            rightNode = rightNode.next;
        }
        // 定义一个右节点的后一节点
        ListNode rightNext = rightNode.next;
        ListNode curNode = leftNode, lastNode = rightNext, nextNode;
        // 对从左位置节点开始到右节点后一节点，进行翻转
        while (curNode != rightNext) {
            nextNode = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = nextNode;
        }

        // 如果左节点的前节点和其下一个节点都不为空，将左节点的前节点的下一个节点指向右位置节点
        if (leftPre != null && leftPre.next != null )
            leftPre.next = rightNode;
        else // 否则链表首节点就是右位置节点
            head = rightNode;

        // 返回结果
        return head;
    }
}
