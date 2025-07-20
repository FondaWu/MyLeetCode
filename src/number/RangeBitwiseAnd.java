package number;

/**
 * 201. 数字范围按位与（中等）
 *  【描述】
 *  给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *
 * 【示例】
 *  示例 1：
 *  输入：left = 5, right = 7
 *  输出：4
 *  示例 2：
 *  输入：left = 0, right = 0
 *  输出：0
 *  示例 3：
 *  输入：left = 1, right = 2147483647
 *  输出：0
 *
 *  【提示】
 *  0 <= left <= right <= 231 - 1
 */
public class RangeBitwiseAnd {

    public static void main(String[] args) {
        int left = 5, right = 7;
        int result = new RangeBitwiseAnd().rangeBitwiseAnd(left, right);
        System.out.println("The result is:" + result);
    }


    public int rangeBitwiseAnd(int left, int right) {
        int result = left;
        for (int data = left + 1; data <= right; data++) {
            result &= data;
        }
        return result;
    }
}
