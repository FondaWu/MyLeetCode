package array;

import java.util.Arrays;

public class CountDays {

    public static void main(String[] args) {
        //int days = 10;
        //int[][] meetings = new int[][]{{5, 7}, {1, 3}, {9, 10}};
        //int days = 57;
        //int[][] meetings = new int[][]{{3, 49}, {23, 44}, {21, 56}, {26, 55}, {23, 52}, {2, 9}, {1, 48}, {3, 31}};
        //int days = 50;
        //int[][] meetings = new int[][]{{22, 31}, {7, 42}, {30, 46}, {9, 33}, {9, 18}, {23, 39}, {4, 8}, {18, 19}};
        int days = 48;
        int[][] meetings = new int[][]{{26, 39}, {46, 47}, {9, 33}, {6, 33}, {28, 40}, {37, 39}, {14, 45}, {13, 40}, {14, 17}, {12, 39}};

        int result = new CountDays().countDays(days, meetings);
        System.out.println("The result is:" + result);
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

        int result = 0;
        int max = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] > max + 1)
                result += meetings[i][0] - max - 1;

            max = Math.max(max, meetings[i][1]);
        }

        return days - max + meetings[0][0] - 1 + result;
    }

}
