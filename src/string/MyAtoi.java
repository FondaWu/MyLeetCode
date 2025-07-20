package string;

public class MyAtoi {

    public static void main(String[] args) {
        int result = myAtoi("00000-42a1234");
        System.out.println("result = " + result);
    }

    private static int myAtoi(String s) {
        char c;
        int result = 0;
        int sign = 0;
        boolean digit = false;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ' && sign == 0 && !digit) {
            } else if (c == '-' && sign == 0 && !digit) {
                sign = -1;
            } else if (c == '+' && sign == 0 && !digit) {
                sign = 1;
            } else if (c >= '0' && c <= '9') {
                digit = true;
                if (result > Integer.MAX_VALUE / 10 || result ==  Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10) {
                    return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else {
                    result = result * 10 + c - '0' ;
                }
            } else {
                break;
            }
        }
        return sign < 0 ? -result : result;
    }

}
