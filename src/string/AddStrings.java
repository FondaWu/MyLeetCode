package string;

public class AddStrings {

    public static void main(String[] args) {
        String num1 = "456", num2 = "77";

        String result = addStrings(num1, num2);
        System.out.println(result);
    }

    private static String addStrings(String num1, String num2) {
        int carry = 0;
        int c;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            c = carry;
            c += i < 0 ? 0 : num1.charAt(i) - 48;
            c += j < 0 ? 0 : num2.charAt(j) - 48;
            carry = c / 10;
            c %= 10;
            sb.append(c);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
