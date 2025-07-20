package dp;

/*
63. 不同路径 II（中等）
【提示】
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。

【示例】
示例 1：
输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
示例 2：
输入：obstacleGrid = [[0,1],[0,0]]
输出：1
【提示】
1）m == obstacleGrid.length
2）n == obstacleGrid[i].length
3）1 <= m, n <= 100
4）obstacleGrid[i][j] 为 0 或 1
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        //int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        //int[][] obstacleGrid = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        //int[][] obstacleGrid = new int[][]{{0}};
        int[][] obstacleGrid = new int[][]{{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int result = new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid);
        System.out.println("计算结果：" + result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 动态规划遍历
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = (obstacleGrid[i][j] == 0) ? 1 : 0;
                    } else {
                        if (i > 0 && obstacleGrid[i - 1][j] != 1)
                            dp[i][j] = dp[i - 1][j];
                        if (j > 0 && obstacleGrid[i][j - 1] != 1)
                            dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
