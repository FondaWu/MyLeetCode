package string;

import java.awt.*;

public class RomanToInt {

    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println("计算结果：" + result);
    }

    private static int romanToInt(String s) {
        char[] romains1 = {'M', 'D', 'L', 'V'};
        int[] nums1 = {1000, 500, 50, 5};
        char[] romains2 = {'C', 'X', 'I'};
        int[] nums2 = {100, 10,  1};
        String[] romains3 = {"CM", "CD", "XC", "XL", "IX", "IV",};
        int[] nums3 = {900, 400, 90, 40, 9, 4};

        int result = 0, n = 0, i;
        String c;

        boolean match;
        while (n < s.length()) {
            if (s.length() > n + 1) {
                for (i = 0; i < romains2.length; i++) {
                    if (s.charAt(n) == romains2[i]) {
                        result += nums1[i];
                        n++;
                        break;
                    }
                }
            }
            for (i = 0; i < romains1.length; i++) {
                if (s.charAt(n) == romains1[i]) {
                    result += nums1[i];
                    n++;
                    break;
                }
            }

        }
        return result;
    }

    private static int romanToInt1(String s) {
        char[] romains1 = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] nums1 = {1000, 500, 100, 50, 10, 5, 1};
        String[] romains2 = {"CM", "CD", "XC", "XL", "IX", "IV",};
        int[] nums2 = {900, 400, 90, 40, 9, 4};

        int result = 0, n = 0, i;
        String c;

        boolean match;
        while (n < s.length()) {
            match = false;
            if (s.length() > n + 1) {
                c = s.substring(n, n + 2);
                for (i = 0; i < romains2.length; i++) {
                    if (c.compareTo(romains2[i]) == 0) {
                        result += nums2[i];
                        n += 2;
                        match = true;
                        break;
                    }
                }
            }
            if (match == false) {
                for (i = 0; i < romains1.length; i++) {
                    if (s.charAt(n) == romains1[i]) {
                        result += nums1[i];
                        n++;
                        break;
                    }
                }
            }

        }
        return result;
    }
}
