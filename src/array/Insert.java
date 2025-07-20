package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] results = new Insert().insert(intervals, newInterval);
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        boolean newIntervalInsert = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!newIntervalInsert) {
                int r = intervalCompare(newInterval, intervals[i]);
                if (r == 0) {
                    intervalList.add(newInterval);
                    intervalList.add(intervals[i]);
                    newIntervalInsert = true;
                } else if (r == 4) {
                    intervalList.add(intervals[i]);
                } else {
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }
            } else {
                intervalList.add(intervals[i]);
            }
        }
        if (!newIntervalInsert) {
            intervalList.add(newInterval);
        }
        int[][] result = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++) {
            result[i] = intervalList.get(i);
        }
        return result;
    }

    private int intervalCompare(int[] interval1, int[] interval2) {
        if (interval1[1] < interval2[0]) return 0;
        if (interval1[0] > interval2[1]) return 4;
        if (interval1[0] <= interval2[0]) {
            return interval1[1] <= interval2[1] ? 1 : 5;
        } else {
            return interval1[1] <= interval2[0] ? 2 : 3;
        }
    }
}
