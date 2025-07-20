package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxEvents {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] events = new int[][]{{1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}};
        int result = new MaxEvents().maxEvents(events);
        System.out.println("result = " + result);
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < n && events[j][0] <= i) {
                if (events[j][1] >= i)
                    pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}
