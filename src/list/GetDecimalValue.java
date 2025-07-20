package list;

import list.base.ListNode;

public class GetDecimalValue {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode head = ListNode.makeList(nums);
        int result = getDecimalValue(head);
        System.out.println("The result is:" + result);
    }

    private static int getDecimalValue(ListNode head) {
        int result = 0;
        do {
            result = (result << 1) + head.val;
            head = head.next;
        }while (head != null);

        return result;
    }
}
