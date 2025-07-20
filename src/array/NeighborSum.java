package array;

/**
 * 3242. 设计相邻元素求和服务（简单）
 * 给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1] 内的不重复元素。
 * 实现 neighborSum 类：
 * neighborSum(int [][]grid) 初始化对象。
 * int adjacentSum(int value) 返回在 grid 中与 value 相邻的元素之和，相邻指的是与 value 在上、左、右或下的元素。
 * int diagonalSum(int value) 返回在 grid 中与 value 对角线相邻的元素之和，对角线相邻指的是与 value 在左上、右上、左下或右下的元素。
 * <p>
 * 示例 1：
 * 输入：
 * ["neighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]
 * [[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]
 * 输出： [null, 6, 16, 16, 4]
 * 解释：
 * 1 的相邻元素是 0、2 和 4。
 * 4 的相邻元素是 1、3、5 和 7。
 * 4 的对角线相邻元素是 0、2、6 和 8。
 * 8 的对角线相邻元素是 4。
 * 示例 2：
 * 输入：
 * ["neighborSum", "adjacentSum", "diagonalSum"]
 * [[[[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]], [15], [9]]
 * 输出： [null, 23, 45]
 * 解释：
 * 15 的相邻元素是 0、10、7 和 6。
 * 9 的对角线相邻元素是 4、12、14 和 15。
 * 【提示】
 * 1.3 <= n == grid.length == grid[0].length <= 10
 * 2.0 <= grid[i][j] <= n2 - 1
 * 3.所有 grid[i][j] 值均不重复。
 * 4.adjacentSum 和 diagonalSum 中的 value 均在范围 [0, n2 - 1] 内。
 * 5.最多会调用 adjacentSum 和 diagonalSum 总共 2 * n2 次。
 */
public class NeighborSum {
    private int[][] grid;
    private int i;
    private int j;

    public static void main(String[] args) {
        //int[][] grid = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int[][] grid = {{3, 6, 0}, {8, 5, 1}, {2, 4, 7}};

        NeighborSum obj = new NeighborSum(grid);
        System.out.println("Adjacent sum of 1：" + obj.adjacentSum(1));
        System.out.println("Adjacent sum of  4：" + obj.adjacentSum(3));
        System.out.println("Diagonal sum of 4：" + obj.diagonalSum(4));
        System.out.println("Diagonal sum of 8：" + obj.diagonalSum(8));
    }

    public NeighborSum(int[][] grid) {
        this.grid = grid;
    }

    public int adjacentSum(int value) {
        if (!findValue(value)) {
            return -1;
        }
        int sum = 0;
        if (i > 0)
            sum += this.grid[i - 1][j];
        if (i < this.grid.length - 1)
            sum += this.grid[i + 1][j];

        if (j > 0)
            sum += this.grid[i][j - 1];
        if (j < this.grid[0].length - 1)
            sum += this.grid[i][j + 1];

        return sum;
    }


    public int diagonalSum(int value) {
        if (!findValue(value)) {
            return -1;
        }
        int sum = 0;
        if (i > 0 && j > 0)
            sum += this.grid[i - 1][j - 1];
        if (i > 0 && j < this.grid[0].length - 1)
            sum += this.grid[i - 1][j + 1];
        if (i < this.grid.length - 1 && j > 0)
            sum += this.grid[i + 1][j - 1];
        if (i < this.grid.length - 1 && j < this.grid[0].length - 1)
            sum += this.grid[i + 1][j + 1];

        return sum;
    }

    private boolean findValue(int value) {
        this.i = 0;
        this.j = 0;
        Label:
        for (; i < this.grid.length; i++) {
            for (j = 0; j < this.grid[0].length; j++) {
                if (this.grid[i][j] == value)
                    break Label;
            }
        }

        if (i < 0 || i >= this.grid[0].length || j < 0 || j >= this.grid[0].length)
            return false;
        return true;
    }
}
