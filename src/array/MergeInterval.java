package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
56. 合并区间（中等）
【描述】
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
【示例】
示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
【提示】
1）1 <= intervals.length <= 104
2）intervals[i].length == 2
3）0 <= starti <= endi <= 104
 */
public class MergeInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] results = new MergeInterval().merge(intervals);
        for (int[] result : results){
            System.out.println(Arrays.toString(result));
        }
    }

    public class MyCompartor implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        Arrays.sort(intervals, new MyCompartor());

        List<int[]> intervalList = new ArrayList<>();
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] >= intervals[i][0]) {
                interval[1] = intervals[i][1] > interval[1] ? intervals[i][1] : interval[1];
            } else {
                intervalList.add(interval.clone());
                interval = intervals[i];
            }
        }
        intervalList.add(interval);
        int[][] result = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++) {
            result[i] = intervalList.get(i);
        }
        return result;
    }
}
