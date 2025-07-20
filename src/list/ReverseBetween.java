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
        // �����������
        if (head.next == null || left == right) return head;
        // ����һ����ڵ����
        ListNode leftNode = head;
        // ����һ����ڵ��ǰһ�ڵ�
        ListNode leftPre = (left == 1) ? null : head;
        int i = 0;
        // �ӽڵ���λ������left�����ҵ���ڵ�
        for (; i < left - 1; i++) {
            if (leftNode == null) return null;
            leftPre = leftNode;
            leftNode = leftNode.next;
        }
        // ����һ���ҽڵ�
        ListNode rightNode = leftNode;
        // �ӽڵ㵱ǰλ�ü�������һ��right�����ҵ��ҽڵ�
        for (; i < right - 1; i++) {
            if (rightNode == null) return null;
            rightNode = rightNode.next;
        }
        // ����һ���ҽڵ�ĺ�һ�ڵ�
        ListNode rightNext = rightNode.next;
        ListNode curNode = leftNode, lastNode = rightNext, nextNode;
        // �Դ���λ�ýڵ㿪ʼ���ҽڵ��һ�ڵ㣬���з�ת
        while (curNode != rightNext) {
            nextNode = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = nextNode;
        }

        // �����ڵ��ǰ�ڵ������һ���ڵ㶼��Ϊ�գ�����ڵ��ǰ�ڵ����һ���ڵ�ָ����λ�ýڵ�
        if (leftPre != null && leftPre.next != null )
            leftPre.next = rightNode;
        else // ���������׽ڵ������λ�ýڵ�
            head = rightNode;

        // ���ؽ��
        return head;
    }
}
