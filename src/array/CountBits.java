package array;

import java.util.Arrays;

public class CountBits {

    public static void main(String[] args) {
        int result[] = countBits2(20);
        System.out.println("The result is:" + Arrays.toString(result));
    }

    private static int[] countBits1(int n) {
        int[] data = new int[n + 1];
        data[0] = 0;
        for (int i = 1; i <= n; i++) {
            data[i] = hammingWeight(i);
        }
        return data;
    }

    private static int hammingWeight(int n) {
        int count = 0;
        for (char i = 0; i < 32; i++) {
            if (((n >> i) & 0x01) > 0) count++;
        }
        return count;
    }

    private static int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
