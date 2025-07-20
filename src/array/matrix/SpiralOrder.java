package array.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵（中等）
 * 【描述】
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 【示例】
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 【提示】
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = new int[][]{{3}, {2}};
        List<Integer> result = new SpiralOrder().spiralOrder(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int direction = 0;
        int x = -1, y = 0;
        int directions[] = {matrix[0].length - 1, matrix.length - 1, 0, 0};
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (true) {
            if (direction == 0) {
                if (x >= right)
                    break;
                result.add(matrix[y][++x]);
                if (x == right) {
                    top++;
                    direction = 1;
                }
            } else if (direction == 1) {
                if (y >= bottom)
                    break;
                result.add(matrix[++y][x]);
                if (y == bottom) {
                    right--;
                    direction = 2;
                }
            } else if (direction == 2) {
                if (x <= left)
                    break;
                result.add(matrix[y][--x]);
                if (x == left) {
                    bottom--;
                    direction = 3;
                }
            } else if (direction == 3) {
                if (y <= top)
                    break;
                result.add(matrix[--y][x]);
                if (y == top) {
                    left++;
                    direction = 0;
                }
            }
        }
        return result;
    }
}
