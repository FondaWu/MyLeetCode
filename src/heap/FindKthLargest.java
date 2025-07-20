package heap;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int result = findKthLargest(nums, 2);
        System.out.println("计算结果:" + result);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums){
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (queue.peek() < num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }

}
