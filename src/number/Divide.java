package number;

/**
 * 77. 组合（中等）
 * 【描述】
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 * 【示例】
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 * <p>
 * 【提示】
 * 1）-231 <= dividend, divisor <= 231 - 1
 * 2) divisor != 0
 **/

public class Divide {

    public static void main(String[] args) {
        int dividend = 2147483647, divisor = 3;
        System.out.println("计算结果：" + divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean negative = dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        } else {
            if (dividend > 0) dividend = -dividend;
        }
        if (divisor > 0) divisor = -divisor;

        int result = doDivide(dividend, divisor);
        return negative ? -result : result;
    }

    public static int doDivide(int dividend, int divisor) {
        int count = 0, n;
        int d1 = dividend;
        int d2;
        while (d1 <= divisor) {
            d2 = divisor;
            n = 1;
            while (d2 + d2 >= d1 && d2 >= Integer.MAX_VALUE - d2) {
                d2 <<= 1;
                n <<= 1;
            }
            count += n;
            d1 -= d2;
        }
        return count;
    }

    public static int divide3(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean delta = false;
        boolean negative = dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            delta = true;
            dividend = Integer.MAX_VALUE;
        } else {
            dividend = Math.abs(dividend);
        }
        divisor = Math.abs(divisor);

        int n = doDivide2(dividend, divisor, delta);
        return negative ? -n : n;
    }


    public static int divide2(int dividend, int divisor) {
        boolean negative = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            negative = true;
        }

        int n;
        if (divisor == Integer.MIN_VALUE) {
            n = (dividend == Integer.MIN_VALUE) ? 1 : 0;
        } else {
            boolean delta = false;
            if (dividend == Integer.MIN_VALUE) {
                delta = true;
                dividend = Integer.MAX_VALUE;
            } else dividend = Math.abs(dividend);

            divisor = Math.abs(divisor);

            n = doDivide2(dividend, divisor, delta);
            if (delta && n == Integer.MAX_VALUE && negative) return Integer.MIN_VALUE;
        }

        return negative ? -n : n;
    }

    public static int doDivide2(int dividend, int divisor, boolean delta) {
        int count = 0, n;
        int d1 = dividend;
        int d2 = divisor;
        while (d1 >= divisor) {
            d2 = divisor;
            n = 1;
            while (d2 + d2 < d1 && d2 <= Integer.MAX_VALUE - d2) {
                d2 <<= 1;
                n <<= 1;
            }
            count += n;
            d1 -= d2;
        }
        if (delta && d1 + 1 >= d2 && count < Integer.MAX_VALUE) {
            count++;
        }
        return count;
    }

    public static int divide1(int dividend, int divisor) {
        boolean negative = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            negative = true;
        }

        if (dividend == Integer.MIN_VALUE) dividend = Integer.MAX_VALUE;
        else dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (divisor == 1) {
            if (dividend == Integer.MAX_VALUE && negative) return Integer.MIN_VALUE;
            return negative ? -dividend : dividend;
        }

        int n = 1;
        divisor = Math.abs(divisor);
        int sum = divisor;

        while (sum <= dividend) {
            sum += divisor;
            n++;
        }

        return negative ? -(n - 1) : n - 1;
    }
}
