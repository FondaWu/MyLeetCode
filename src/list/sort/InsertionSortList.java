package list.sort;

import list.base.ListNode;

/*
147. 对链表进行插入排序(中等)
【描述】
给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
插入排序 算法的步骤:
插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
对链表进行插入排序。

【示例】
示例 1：
输入: head = [4,2,1,3]
输出: [1,2,3,4]
示例 2：
输入: head = [-1,5,3,4,0]
输出: [-1,0,3,4,5]

【提示】
1）列表中的节点数在 [1, 5000]范围内
2）-5000 <= Node.val <= 5000
 */
public class InsertionSortList {

    public static void main(String[] args) {
        int[] dataArray = new int[]{-1, 5, 3, 4, 0};
        ListNode head = ListNode.makeList(dataArray);
        insertionSortList(head);
        head.printList();
    }

    private static ListNode insertionSortList(ListNode head) {
        ListNode curNode, startNode;
        for (curNode = head; curNode != null; curNode = curNode.next) {
            for (startNode = head; startNode != curNode; startNode = startNode.next) {
                if (startNode.val > curNode.val) {
                    int tmp = curNode.val;
                    curNode.val = startNode.val;
                    startNode.val = tmp;
                }
            }
        }
        return head;
    }

}
