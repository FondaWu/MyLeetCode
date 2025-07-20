package array.matrix;

import java.util.Arrays;
import java.util.List;

/**
 * 59. 螺旋矩阵 II（中等）
 * 【描述】
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 【示例】
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 【提示】
 * 1 <= n <= 20
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] matrix = new GenerateMatrix().generateMatrix(3);
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int direction = 0;
        int x = -1, y = 0;
        int data = 1;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (true) {
            if (direction == 0) {
                if (x >= right)
                    break;
                matrix[y][++x] = data++;
                if (x == right) {
                    top++;
                    direction = 1;
                }
            } else if (direction == 1) {
                if (y >= bottom)
                    break;
                matrix[++y][x] = data++;
                if (y == bottom) {
                    right--;
                    direction = 2;
                }
            } else if (direction == 2) {
                if (x <= left)
                    break;
                matrix[y][--x] = data++;
                if (x == left) {
                    bottom--;
                    direction = 3;
                }
            } else if (direction == 3) {
                if (y <= top)
                    break;
                matrix[--y][x] = data++;
                if (y == top) {
                    left++;
                    direction = 0;
                }
            }
        }
        return matrix;
    }
}
