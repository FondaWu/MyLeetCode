package number;

import java.util.Arrays;
import java.util.List;

/**
 * 69. x 的平方根 （简单）
 * 【描述】
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 【示例】
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 【提示】
 * 0 <= x <= 231 - 1
 */
public class MySqrt {

    public static void main(String[] args) {
        int x = 8;
        int result = new MySqrt().mySqrt(x);
        System.out.println("result = " + result);
    }

    public int mySqrt(int x) {
        if (x < 0) return -1;

        double err = 1e-15;
        double t = x;
        while (Math.abs(t - x / t) > err * t)
            t = (x / t + t) / 2.0;
        return (int) t;
    }

}
