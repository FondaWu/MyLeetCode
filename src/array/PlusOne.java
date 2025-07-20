package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> dataList = new ArrayList<>();
        int carry = 0;

        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
            dataList.add(digits[i]);
        }
        if (carry > 0) dataList.add(carry);

        int[] result = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            result[i] = dataList.get(dataList.size()-i-1);
        }

        return result;
    }
}
