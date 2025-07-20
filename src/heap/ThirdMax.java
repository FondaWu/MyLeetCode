package heap;

import java.util.PriorityQueue;

public class ThirdMax {

    public static void main(String[] args) {
        //int[] nums = new int[]{2, 2, 3, 1};
        int[] nums = new int[]{1, 2, 2};
        int result = new ThirdMax().thirdMax(nums);
        System.out.println("计算结果:" + result);
    }

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        for (int num : nums) {
            if (!queue.isEmpty() && queue.contains(num)) continue;
            if (queue.size() < 3) {
                queue.offer(num);
            } else {
                if (queue.peek() < num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }

        if (queue.size() < 3) {
            while (queue.size() != 1)
                queue.poll();
        }
        return queue.peek();
    }

}
