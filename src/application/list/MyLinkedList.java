package application.list;

import list.base.ListNode;

/*
707. 设计链表（中等）
【描述】
你可以选择使用单链表或者双链表，设计并实现自己的链表。
单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
实现 MyLinkedList 类：
MyLinkedList() 初始化 MyLinkedList 对象。
int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。

【示例】
输入
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
输出
[null, null, null, null, 2, null, 3]

解释
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
myLinkedList.get(1);              // 返回 2
myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
myLinkedList.get(1);              // 返回 3

【提示】
1）0 <= index, val <= 1000
2）请不要使用内置的 LinkedList 库。
3）调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。
 */
public class MyLinkedList {
    private int size = 0;
    private ListNode head;
    private ListNode tail;


    public MyLinkedList() {

    }

    public int get(int index) {
        ListNode node = getNode(index);
        if (node == null) return -1;
        return node.val;
    }

    private ListNode getNode(int index) {
        if (index < 0 || index > size - 1) return null;

        int i = 0;
        ListNode curNode = head;
        while (++i <= index) {
            curNode = curNode.next;
        }
        return curNode;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        if (head == null)
            tail = node;
        head = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (tail == null)
            head = node;
        else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode preNode = getNode(index - 1);
            ListNode nextNode = preNode.next;
            preNode.next = newNode;
            newNode.next = nextNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
        } else {
            ListNode preNode = getNode(index - 1);
            if (index == size - 1) {
                preNode.next = null;
                tail = preNode;
            } else {
                ListNode nextNode = preNode.next.next;
                preNode.next = nextNode;
            }
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.get(1);              // 返回 3
    }

}
