package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
118. 杨辉三角（简单）
【描述】
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。

【示例】
示例 1:
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:
输入: numRows = 1
输出: [[1]]

【提示】
1 <= numRows <= 30
*/
public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(6);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] lastArr = null;
        for (int i = 0; i < numRows; i++) {
            int[] arr = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    arr[j] = 1;
                else
                    arr[j] = lastArr[j - 1] + lastArr[j];
            }
            List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
            lists.add(lst);
            lastArr = arr;
        }
        return lists;
    }

    private static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> lastList = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else
                    list.add(lastList.get(j - 1) + lastList.get(j));
            }
            lists.add(list);
            lastList = list;
        }

        return lists;
    }

}
