package list.base;

/**
 * @author: FondaWu
 * @create: 2021-03-29 16:30
 * @description: ${description}
 **/
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode makeList(int num) {
        ListNode first = null, last = null;
        do {
            int val = num - (num / 10 * 10);
            ListNode node = new ListNode(val);
            if (first == null) {
                first = node;
            } else {
                last.next = node;

            }
            last = node;
            num /= 10;
        } while (num > 0);
        return first;
    }

    public static ListNode makeList(int[] dataArray) {
        ListNode first = null, last = null;
        for (int i = 0; i< dataArray.length; i++){
            ListNode node = new ListNode(dataArray[i]);
            if (first == null) {
                first = node;
            } else {
                last.next = node;

            }
            last = node;
        }
        return first;
    }

    public void printList() {
        for (ListNode node = this; node != null; node = node.next){
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public ListNode getTailNode(){
        ListNode node  = this;;
        while (node.next != null){
            node = node.next;
        }
        return node;
    }

    // 1->2->3->4
    public ListNode reverse() {
        ListNode curNode = this, lastNode = null, nextNode;
        while (curNode != null){
            nextNode = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = nextNode;
        }
        return lastNode;
    }

    public static ListNode reverseList(ListNode head, ListNode tail) {
        ListNode curNode = head, lastNode = null, nextNode;
        while (curNode != tail) {
            nextNode = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = nextNode;
        }
        return lastNode;
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     *
     * @param head
     * @return
     */
    public static ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针
        ListNode slow = head, quick = head;
        // 快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
