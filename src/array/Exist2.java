package array;

public class Exist2 {

    public static void main(String[] args) {
        //char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        //char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";

        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        int i = 0, j = 0;
        char[][] mark = new char[board.length][board[0].length];

        for (; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (next(board, i, j, word, 1, mark))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean next(char[][] board, int i, int j, String word, int n, char[][] mark) {
        if (n == word.length()) return true;

        mark[i][j] = 1;
        if (j + 1 < board[0].length && mark[i][j+1]  == 0 && board[i][j + 1] == word.charAt(n)) {
            if (next(board, i, j + 1, word, n + 1, mark)) return true;
        }
        if (i + 1 < board.length && mark[i+1][j]  == 0 && board[i + 1][j] == word.charAt(n)) {
            if (next(board, i + 1, j, word, n + 1, mark)) return true;

        }

        if (j - 1 >= 0 && mark[i][j-1] == 0 && board[i][j - 1] == word.charAt(n)) {
            if (next(board, i, j - 1, word, n + 1, mark)) return true;
        }


        if (i - 1 >= 0 && mark[i-1][j] == 0 && board[i - 1][j] == word.charAt(n)) {
            if (next(board, i - 1, j, word, n + 1, mark)) return true;
        }

        mark[i][j] = 0;
        return false;
    }
}
