package list;

import list.base.ListNode;

/**
 * @author: FondaWu
 * @create: 2021-03-29 15:08
 * @description: ${description}
 **/
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode head1 = ListNode.makeList(9);
        ListNode head2 = ListNode.makeList(99999999);
        head1.printList();
        head2.printList();

        new AddTwoNumbers().addTwoNumbers(head1, head2).printList();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        while (l1 != null && (l2 != null || carry != 0)){
            int n = l1.val + carry;
            if (l2 != null) {
                n += l2.val;
                l2 = l2.next;
            }
            carry = n / 10;
            l1.val = n - carry *10;
            if (l1.next == null) {
                if (l2 != null) {
                    l1.next = l2;
                    l2 = null;
                } else {
                    if (carry > 0) {
                        l1.next = new ListNode(carry);
                    }
                    break;
                }
            }
            l1 = l1.next;
        }
        return head;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int num = calTotalVal(l1) + calTotalVal(l2);
        return ListNode.makeList(num);
    }

    private static int calTotalVal(ListNode l) {
        if (l == null) return 0;

        int ret = 0;
        int t = 1;
        do {
            ret += l.val * t;
            t *= 10;
            l = l.next;
        } while (l != null);

        return ret;
    }

}
