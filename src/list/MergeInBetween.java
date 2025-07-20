package list;

import list.base.ListNode;

/*
1669. 合并两个链表(中等)
【描述】
给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
下图中蓝色边和节点展示了操作后的结果：请你返回结果链表的头指针。
【示例】
示例 1：
输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
输出：[0,1,2,1000000,1000001,1000002,5]
解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
示例 2：
输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
解释：上图中蓝色的边和节点为答案链表。
【提示】
3 <= list1.length <= 104
1 <= a <= b < list1.length - 1
1 <= list2.length <= 104
 */
public class MergeInBetween {

    public static void main(String[] args) {
        int[] l1 = new int[]{0, 1, 2, 3, 4, 5, 6};
        int[] l2 = new int[]{1000000, 1000001, 1000002, 1000003, 1000004};
        ListNode list1 = ListNode.makeList(l1);
        ListNode list2 = ListNode.makeList(l2);

        ListNode list3 = new MergeInBetween().mergeInBetween(list1, 2, 5, list2);
        list3.printList();
    }

    private ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 先从list1的首节点走a-1步找到节点a前一节点
        ListNode preANode = followingNode(list1, a - 1);
        // 再从a节点走b-a+2步找到节点b+1
        ListNode nextBNode = followingNode(preANode, b - a + 2);
        // 找到list2的尾节点
        ListNode tailNode2 = getTailNode(list2);
        // 将节点a下一节点指向list2首节点
        preANode.next = list2;
        // 将list2的尾节点指向节点b下一个节点
        tailNode2.next = nextBNode;
        return list1;
    }

    private ListNode followingNode(ListNode node, int step) {
        int i = 0;
        ListNode node2 = node;
        while (i < step) {
            node2 = node2.next;
            i++;
        }
        return node2;
    }

    private ListNode getTailNode(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
