package array.matrix;

import java.util.Arrays;

public class SortTheStudents {

    public static void main(String[] args) {
        //int scores[][] = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, k = 2;
        int scores[][] = {{64766,11978,20502,21365,79611,36797,58431,89540,59373,25955}, {51305,66104,88468,5333,17233,32521,14087,42738,46669,65662},{93306,92793,54009,9715,24354,24895,20069,93332,73836,64359}, {23358,84599,4675,20979,76889,34630,64098,23468,71448,17848}};
        int k = 2;

        int sortedScores[][] = new SortTheStudents().sortTheStudents(scores, k);
        for (int[] score : sortedScores) {
            System.out.println(Arrays.toString(score));
        }
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        int startRow = 0;
        while (startRow < score.length - 1) {
            int minRow = startRow;
            for (int i = startRow + 1; i < score.length; i++ ) {
                if (score[i][k] > score[minRow][k]) {
                    minRow = i;
                }
            }
            int tmp;
            for (int i = 0; i < score[minRow].length; i++) {
                tmp = score[startRow][i];
                score[startRow][i] = score[minRow][i];
                score[minRow][i] = tmp;
            }
            startRow++;
        }
        return score;
    }
}
