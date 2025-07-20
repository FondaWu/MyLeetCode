package string;

/*
171. Excel 表列序号（简单）
【描述】
给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
例如：
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
 【示例】
示例 1:
输入: columnTitle = "A"
输出: 1
示例 2:
输入: columnTitle = "AB"
输出: 28
示例 3:
输入: columnTitle = "ZY"
输出: 701

【提示】
1）1 <= columnTitle.length <= 7
2）columnTitle 仅由大写英文组成
3）columnTitle 在范围 ["A", "FXSHRXW"] 内
 */
public class TitleToNumber {

    public static void main(String[] args) {
        //String s = "ZY";
        String s = "FXSHRXW";
        int result = titleToNumber(s);
        System.out.println("计算结果：" + result);
    }

    private static int titleToNumber(String columnTitle) {
        char ch;
        int count = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ch = (char) (columnTitle.charAt(i) - 64);
            count += ch * multi(26, columnTitle.length() - i - 1);
        }
        return count;
    }

    private static int multi(int base, int times) {
        int result = 1;
        for (int i = 0; i < times; i++) {
            result *= base;
        }
        return result;
    }

}
