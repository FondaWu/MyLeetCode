package number;

public class MyPow {
    public static void main(String[] args) {
        double x = 2;
        int n = -2147483648;
        double result = new MyPow().myPow(x, n);
        System.out.println("The result is:" + result);
    }

    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static double myPow1(double x, int n) {
        if (x == 1 || n == 0) return 1.0;

        if (x == -1.0) {
            return (n % 2 == 0) ? 1 : -1;
        }
        double result = 1.0, x1;

        boolean negative1 = (x < 0 && n % 2 == 1);
        boolean negative2 = (n < 0);
        int c, n1 = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(n);
        while (n1 > 0) {
            c = 1;
            x1 = Math.abs(x);
            while ((c << 1) <= n1) {
                if (x1 == 0.0) return 0.0;
                if (x1 > Integer.MAX_VALUE / x1) {
                    x1 = Integer.MAX_VALUE;
                    break;
                } else {
                    x1 *= x1;
                }
                c = (c << 1);
            }
            if (result > Integer.MAX_VALUE / x1) {
                result = Integer.MAX_VALUE;
                break;
            } else {
                result *= x1;
            }
            n1 -= c;
        }

        result = negative1 ? -result : result;
        return negative2 ? 1.0 / result : result;
    }
}
