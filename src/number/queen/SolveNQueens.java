package number.queen;

import java.util.Arrays;
import java.util.List;

/*
面试题 08.12. 八皇后(困难)
【描述】
设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
【示例】
输入：4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
【提示】
本题相对原题做了扩展
 */
public class SolveNQueens {

    public static void main(String[] args) {
        List<List<String>> resultLists = solveNQueens(4);
        for (List<String> resultList : resultLists) {
            System.out.println(Arrays.toString(resultList.toArray()));
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        QueenN queueN = new QueenN(n);
        queueN.placeQueen(0); // 从第 1 行开始放置

        return queueN.resultLists;
    }


}
