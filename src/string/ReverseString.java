package string;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println("result = " + Arrays.toString(s));
    }

    private static void reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length - 1 - i; i < j; i++, j--) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

}
