package list;

/*
面试题 02.01. 移除重复节点（简单）
【描述】
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
【示例】
示例1:
 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:
 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
【提示】
链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
【进阶】
如果不得使用临时缓冲区，该怎么解决？
*/

import list.base.ListNode;

import java.util.HashSet;

public class RemoveDuplicateNodes {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 2, 1};
        ListNode head = ListNode.makeList(nums);
        head = removeDuplicateNodes(head);
        if (head != null) head.printList();
    }

    private static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;

        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head, last = null;
        while (cur != null) {
            if (!set.contains(cur.val)){
                set.add(cur.val);
                if (last != null)
                    last.next = cur;
                last = cur;
            }
            cur = cur.next;
        }
        last.next = null;
        return head;
    }
}
