package number;

import java.util.ArrayList;
import java.util.List;

public class Reverse {

    public static void main(String[] args) {
        int x = 15340;
        System.out.println(reverse2(x));
    }

    private static int reverse1(int x) {
        if (x < -Integer.MAX_VALUE || x > Integer.MAX_VALUE) return 0;

        int m = x;
        int n;
        List<Integer> reverseNumbers = new ArrayList<>();
        while (m != 0) {
            n = m - (m / 10) * 10;
            if (reverseNumbers.size() > 0 || n != 0) {
                reverseNumbers.add(n);
            }
            m = m / 10;
        }

        long  i = 1;
        long result = 0;
        long tmp ;
        for (int j = reverseNumbers.size() - 1; j >= 0; j--) {
            tmp = i * reverseNumbers.get(j);
            result += tmp;
            if (result < -Integer.MAX_VALUE || result > Integer.MAX_VALUE) return 0;
            i *= 10;
        }
        return (int)result;
    }

    private static int reverse2(int x) {
        if (x < -Integer.MAX_VALUE || x > Integer.MAX_VALUE) return 0;

        long result = 0;
        while (x !=0) {
            result = result * 10 + x%10;
            x /= 10;
        }

        if (result < -Integer.MAX_VALUE || result > Integer.MAX_VALUE) return 0;
        return (int) result;
    }
}
