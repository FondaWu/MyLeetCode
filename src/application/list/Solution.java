package application.list;

import list.base.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> numList;

    public Solution(ListNode head) {
        numList = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null) {
            numList.add(curNode.val);
            curNode = curNode.next;
        }
    }

    public int getRandom() {
        int i = (int) (Math.random() * numList.size());
        return numList.get(i);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 10, 20, 100};
        ListNode head = ListNode.makeList(nums);
        Solution solution = new Solution(head);
        for (int i = 0; i < 20; i++) {
            System.out.print(solution.getRandom() + " ");
        }
    }
}
