package array;

public class CountServers {

    public static void main(String[] args) {
        //int[][] grid = new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};

        int[][] grid = new int[][]{{1, 0}, {1, 1}};
        int result = countServers(grid);
        System.out.println("The result is:" + result);
    }

    public static int countServers1(int[][] grid) {
        int i, j, count, result = 0;
        for (i = 0; i < grid.length; i++) {
            count = 0;
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) count++;
            }
            if (count > 1) result += count;
        }

        for (j = 0; j < grid[0].length; j++) {
            count = 0;
            for (i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) count++;
            }
            if (count > 1) result += count;
        }
        return result;
    }

    public static int countServers(int[][] grid) {
        int i = 0, j = 0;
        int height = grid.length;
        int width = grid[0].length;
        while (i <= height && j < width) {

        }
        return 0;
    }
}
