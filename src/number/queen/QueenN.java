package number.queen;

import java.util.ArrayList;
import java.util.List;

public class QueenN {
    private int numQueens;
    private int[] cloumns;

    public List<List<String>> resultLists = new ArrayList<>();

    public QueenN(int numQueens) {
        this.numQueens = numQueens;
        cloumns = new int[numQueens];
    }

    public void placeQueen(int col) {
        if (col == this.numQueens) {
            saveResult();
            return;
        }

        boolean valid;
        for (int i = 0; i < this.numQueens; i++) {
            valid = true;
            cloumns[col] = i;
            for (int j = 0; j < col; j++) {
                if (cloumns[j] == cloumns[col] || Math.abs(col - j) == Math.abs(cloumns[col] - cloumns[j])) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                placeQueen(col + 1);
        }
    }

    public void placeQueen1(int n) {
        if (n == this.numQueens) {
            saveResult();
            return;
        }

        for (int i = 0; i < this.numQueens; i++) {
            cloumns[n] = i;
            if (judge(n)) {
                placeQueen1(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (cloumns[i] == cloumns[n] || Math.abs(n - i) == Math.abs(cloumns[n] - cloumns[i])) {
                return false;
            }
        }
        return true;
    }

    private void saveResult1() {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < numQueens; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < numQueens; j++) {
                sb.append((j == cloumns[i]) ? 'Q' : '.');
            }
            resultList.add(sb.toString());
        }
        resultLists.add(resultList);
    }

    private void saveResult() {
        List<String> resultList = new ArrayList<>();
        int j;
        for (int i = 0; i < numQueens; i++) {
            StringBuilder sb = new StringBuilder();
            for (j = 0; j < cloumns[i]; j++) {
                sb.append('.');
            }
            sb.append('Q');
            for (j = cloumns[i]+1; j < numQueens; j++) {
                sb.append('.');
            }
            resultList.add(sb.toString());
        }
        resultLists.add(resultList);
    }

    public static void main(String[] args) {
        QueenN queueN = new QueenN(4);
        queueN.placeQueen1(0); // 从第 1 行开始放置
    }
}
